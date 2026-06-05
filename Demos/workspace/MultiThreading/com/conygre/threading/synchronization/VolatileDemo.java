package com.conygre.threading.synchronization;

/**
 * Demonstrates the volatile keyword and the Java Memory Model (JMM).
 *
 * The Java Memory Model allows the JVM and CPU to:
 *   - Cache variable values in thread-local registers or CPU caches
 *   - Reorder instructions for performance
 *
 * This means changes made by one thread to a shared variable may NOT be
 * immediately visible to other threads — a "visibility problem".
 *
 * The volatile keyword provides two guarantees:
 *   1. Visibility: every read of a volatile variable sees the most recently
 *      written value from any thread. Writes are flushed to main memory
 *      immediately and reads bypass the cache.
 *   2. Ordering: accesses to a volatile variable cannot be reordered with
 *      respect to other memory accesses (happens-before relationship).
 *
 * volatile does NOT guarantee atomicity for compound operations.
 *   i++ is actually three operations: read, increment, write.
 *   Even on a volatile int, i++ is not atomic. For atomic compound operations
 *   use AtomicInteger (see atomic package) or synchronized.
 *
 * When to use volatile vs synchronized vs AtomicInteger:
 *   volatile    — for a simple flag or reference that one thread writes and
 *                 others only read. No compound operations.
 *   AtomicInteger — for a counter that multiple threads increment/decrement.
 *   synchronized  — for any multi-step operation that must be atomic as a whole.
 */
public class VolatileDemo {

    // Without volatile, the JVM may keep 'running' in a CPU register and the
    // worker thread might loop forever, never seeing main's update.
    // With volatile, main's write is immediately visible to the worker.
    private static volatile boolean running = true;

    // Counter is only written by one thread (the worker), so it does not
    // need volatile here — but it shows that volatile is not the tool for
    // multi-threaded increment (that would need AtomicLong or synchronized).
    private static long count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (running) {
                count++; // safe here: only one writer
            }
            System.out.println("Worker stopped. Counted: " + count + " iterations");
        }, "worker");

        worker.start();
        Thread.sleep(100); // let the worker run for a short time
        System.out.println("Signalling worker to stop...");
        running = false; // visible to worker because 'running' is volatile
        worker.join();
        System.out.println("Done");
    }
}
