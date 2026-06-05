package com.conygre.threading.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates ExecutorService — the central component of Java's Executor framework.
 *
 * Instead of creating and managing Thread objects directly, the Executor
 * framework separates TASK SUBMISSION from THREAD MANAGEMENT:
 *   - You submit Runnable or Callable tasks.
 *   - The ExecutorService decides when and how to run them (thread pool, etc.).
 *
 * Common factory methods (Executors class):
 *
 *   newFixedThreadPool(n)
 *       Pool of exactly n threads. Extra tasks queue until a thread is free.
 *       Good for: CPU-bound work where n = number of CPU cores.
 *
 *   newCachedThreadPool()
 *       Creates new threads on demand; reuses idle threads (idle timeout 60s).
 *       Good for: many short-lived I/O-bound tasks.
 *       Caution: can create unbounded threads under heavy load.
 *
 *   newSingleThreadExecutor()
 *       One background thread; tasks execute sequentially in submission order.
 *       Good for: serialising access to a resource from multiple threads.
 *
 *   newScheduledThreadPool(n)
 *       Runs tasks after a delay or at a fixed rate/interval.
 *
 *   newWorkStealingPool() (Java 8+)
 *       Backed by ForkJoinPool; uses all available CPU cores by default.
 *       Idle threads steal tasks from busy threads' queues.
 *       Good for: parallelisable, independent tasks.
 *
 *   newVirtualThreadPerTaskExecutor() (Java 21+)
 *       Creates one virtual thread per submitted task — see virtualthreads package.
 *
 * Lifecycle:
 *   submit(task)           — accept a task; returns a Future
 *   shutdown()             — stop accepting tasks; existing tasks complete
 *   shutdownNow()          — attempt to cancel running tasks; returns pending tasks
 *   awaitTermination(t, u) — block until all tasks finish or timeout elapses
 *   isTerminated()         — true once all tasks have finished after shutdown
 *
 * Always shut down the executor when done; otherwise the JVM may not exit.
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        demonstrateFixedPool();
        demonstrateScheduled();
        demonstrateCustomThreadFactory();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: Fixed thread pool — submit Runnables and Callables
    // -------------------------------------------------------------------------
    static void demonstrateFixedPool() throws InterruptedException, ExecutionException {
        System.out.println("=== Fixed Thread Pool ===");

        // A pool with 3 threads. Submitting 5 tasks: the first 3 run immediately,
        // the remaining 2 wait in the queue until a thread becomes free.
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            // submit(Runnable) — fire and forget; the returned Future<?>
            // can be used to check for exceptions or wait for completion.
            pool.submit(() ->
                System.out.println("Task " + taskId + " on "
                    + Thread.currentThread().getName())
            );
        }

        // Callable returns a typed result via Future.get()
        Future<Integer> future = pool.submit(() -> {
            Thread.sleep(100);
            return 42;
        });

        // future.get() blocks until the result is ready (or throws if the task failed)
        System.out.println("Callable result: " + future.get());

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }

    // -------------------------------------------------------------------------
    // DEMO 2: Scheduled executor — delay and periodic tasks
    // -------------------------------------------------------------------------
    static void demonstrateScheduled() throws InterruptedException {
        System.out.println("\n=== Scheduled Executor ===");

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Run once after a delay
        scheduler.schedule(
            () -> System.out.println("One-shot task ran"),
            200, TimeUnit.MILLISECONDS
        );

        // Run at a fixed RATE: first execution after initialDelay,
        // subsequent executions every 'period' ms (regardless of task duration).
        ScheduledFuture<?> repeating = scheduler.scheduleAtFixedRate(
            () -> System.out.println("Repeating task at " + System.currentTimeMillis()),
            100, 200, TimeUnit.MILLISECONDS
        );

        Thread.sleep(700);
        repeating.cancel(false); // stop after current execution completes

        scheduler.shutdown();
        scheduler.awaitTermination(1, TimeUnit.SECONDS);
    }

    // -------------------------------------------------------------------------
    // DEMO 3: Custom ThreadFactory — control thread attributes
    // -------------------------------------------------------------------------
    // A ThreadFactory lets you name threads (vital for debugging/profiling),
    // make them daemons, set priority, or add uncaught exception handlers.
    static void demonstrateCustomThreadFactory() throws InterruptedException {
        System.out.println("\n=== Custom Thread Factory ===");

        ThreadFactory factory = runnable -> {
            Thread t = new Thread(runnable, "custom-worker");
            t.setDaemon(true); // daemon threads do not prevent JVM shutdown
            t.setPriority(Thread.NORM_PRIORITY);
            return t;
        };

        ExecutorService pool = Executors.newFixedThreadPool(2, factory);
        pool.submit(() ->
            System.out.println("Running on: " + Thread.currentThread().getName()
                + " (daemon=" + Thread.currentThread().isDaemon() + ")")
        );

        pool.shutdown();
        pool.awaitTermination(2, TimeUnit.SECONDS);
    }
}
