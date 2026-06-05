package com.conygre.threading.virtualthreads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Demonstrates Virtual Threads (Java 21 — Project Loom, JEP 444).
 *
 * Virtual threads are lightweight threads managed by the JVM rather than the OS.
 *
 * PLATFORM THREADS (traditional Java threads, before virtual threads):
 *   - Each maps 1:1 to an OS thread.
 *   - OS threads consume ~1–2 MB of stack memory each.
 *   - The JVM can typically support only a few thousand platform threads before
 *     running out of memory or degrading performance.
 *   - A blocked platform thread (waiting for I/O, sleep, etc.) ties up an OS thread
 *     for the entire duration of the wait. This is expensive.
 *
 * VIRTUAL THREADS (Java 21+):
 *   - Managed entirely by the JVM; multiplexed over a small pool of "carrier"
 *     OS threads (typically one per CPU core).
 *   - Consume only a few hundred bytes of memory each.
 *   - You can create MILLIONS of virtual threads in the same JVM.
 *   - When a virtual thread blocks (sleep, I/O, lock, etc.), the JVM
 *     automatically UNMOUNTS it from its carrier thread, freeing that OS thread
 *     to run other virtual threads. When the blocking operation completes,
 *     the virtual thread is REMOUNTED on an available carrier thread.
 *   - The blocking code looks exactly the same — no async/reactive boilerplate.
 *
 * When to use virtual threads:
 *   - I/O-bound, high-concurrency workloads (REST clients, JDBC, file I/O)
 *   - Server applications handling thousands of concurrent connections
 *   - Any place where you previously used a thread pool to limit concurrency
 *     due to memory/OS thread limits
 *
 * When NOT to use virtual threads:
 *   - CPU-bound work: use parallel streams or ForkJoinPool for CPU-bound parallelism.
 *     Virtual threads do not add CPU parallelism; they improve I/O concurrency.
 *   - Code with "pinning" issues: a virtual thread is pinned (cannot unmount)
 *     if it is inside a synchronized block/method or a native method while
 *     blocking. Replace synchronized with ReentrantLock in such cases.
 *
 * Key API (Java 21):
 *   Thread.ofVirtual().start(runnable)
 *   Thread.ofVirtual().name("name").start(runnable)
 *   Thread.ofVirtual().unstarted(runnable)
 *   Thread.currentThread().isVirtual()
 *   Executors.newVirtualThreadPerTaskExecutor()
 */
public class VirtualThreadsDemo {

    public static void main(String[] args) throws InterruptedException {
        demonstrateCreation();
        demonstrateScale();
        demonstrateExecutor();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: Thread.Builder API — create virtual and platform threads
    // -------------------------------------------------------------------------
    static void demonstrateCreation() throws InterruptedException {
        System.out.println("=== Thread Builder API ===");

        // Virtual thread
        Thread vt = Thread.ofVirtual()
            .name("my-virtual-thread")
            .start(() -> System.out.println(
                "Virtual thread: isVirtual=" + Thread.currentThread().isVirtual()
                + ", thread=" + Thread.currentThread()
            ));
        vt.join();

        // Platform thread (for comparison)
        Thread pt = Thread.ofPlatform()
            .name("my-platform-thread")
            .start(() -> System.out.println(
                "Platform thread: isVirtual=" + Thread.currentThread().isVirtual()
                + ", thread=" + Thread.currentThread()
            ));
        pt.join();
    }

    // -------------------------------------------------------------------------
    // DEMO 2: Scale — 10,000 virtual threads, each sleeping 100ms
    // -------------------------------------------------------------------------
    // With a traditional 10-thread pool this would take ~100 seconds
    // (10,000 tasks / 10 threads × 100ms each).
    // With virtual threads it completes in ~100ms regardless of thread count.
    static void demonstrateScale() throws InterruptedException {
        System.out.println("\n=== Scale: 10,000 virtual threads ===");

        int count = 10_000;
        AtomicInteger completed = new AtomicInteger(0);
        Thread[] threads = new Thread[count];

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            threads[i] = Thread.ofVirtual().start(() -> {
                try {
                    // Each thread blocks for 100ms, simulating I/O.
                    // Virtual threads unmount from the carrier during the sleep,
                    // so only a handful of OS threads are active at any one time.
                    Thread.sleep(Duration.ofMillis(100));
                    completed.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        for (Thread t : threads) t.join();
        long elapsed = System.currentTimeMillis() - start;

        System.out.println(count + " virtual threads completed in " + elapsed + "ms");
        System.out.println("Completed: " + completed.get());
        System.out.println("(With a 10-thread pool this would take ~" + (count / 10 * 100 / 1000) + "s)");
    }

    // -------------------------------------------------------------------------
    // DEMO 3: newVirtualThreadPerTaskExecutor — recommended for server code
    // -------------------------------------------------------------------------
    // This executor creates one virtual thread per submitted task and does NOT
    // pool threads (virtual threads are cheap enough that pooling is unnecessary
    // and actually harmful — pooled virtual threads may carry thread-local state).
    static void demonstrateExecutor() throws InterruptedException {
        System.out.println("\n=== Virtual Thread Per Task Executor ===");

        // try-with-resources calls executor.close(), which waits for all tasks
        // to complete — like awaitTermination, but without needing to call shutdown().
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10).forEach(i ->
                executor.submit(() -> {
                    System.out.println("Task " + i + " on: "
                        + Thread.currentThread()
                        + " (virtual=" + Thread.currentThread().isVirtual() + ")");
                    return i;
                })
            );
        } // executor.close() here — waits for all tasks
    }
}
