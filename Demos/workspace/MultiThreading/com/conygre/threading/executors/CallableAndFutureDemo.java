package com.conygre.threading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Demonstrates Callable and Future for tasks that produce a result.
 *
 * Callable<V>:
 *   Like Runnable, but the call() method returns a value of type V and
 *   is allowed to throw checked exceptions. Submit to an ExecutorService
 *   via executor.submit(callable), which returns a Future<V>.
 *
 * Future<V>:
 *   A handle to a pending result. Key methods:
 *
 *   get()                   — block until the result is ready (or throws if
 *                             the task threw an exception, wrapped in ExecutionException)
 *   get(timeout, unit)      — block with a timeout; throws TimeoutException if
 *                             the result is not available in time
 *   isDone()                — non-blocking check; true when task is complete
 *                             (successfully, exceptionally, or cancelled)
 *   cancel(mayInterrupt)    — attempt to cancel; if mayInterrupt is true and
 *                             the task is running, the thread is interrupted
 *   isCancelled()           — true if the task was cancelled before completing
 *
 * Batch submission patterns:
 *
 *   invokeAll(tasks)
 *       Submits all tasks, BLOCKS until ALL have completed, returns a list
 *       of completed Futures in the same order as submission.
 *
 *   invokeAny(tasks)
 *       Submits all tasks, returns the result of the FIRST to succeed, and
 *       cancels the remaining tasks. Throws if all tasks fail.
 *
 * For non-blocking, callback-based result handling, see CompletableFutureDemo.
 */
public class CallableAndFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        demonstrateFuture();
        demonstrateFutureTimeout();
        demonstrateInvokeAll();
        demonstrateInvokeAny();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: Submit tasks and collect results in order
    // -------------------------------------------------------------------------
    static void demonstrateFuture() throws InterruptedException, ExecutionException {
        System.out.println("=== Callable + Future ===");
        ExecutorService pool = Executors.newFixedThreadPool(4);

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final int id = i;
            futures.add(pool.submit(() -> {
                Thread.sleep((long) (Math.random() * 400 + 100));
                return "Result from task " + id;
            }));
        }

        // Iterating in submission order: get() blocks on slow tasks even if
        // later tasks have already finished. See CompletionServiceDemo for
        // completion-order processing.
        for (Future<String> f : futures) {
            System.out.println(f.get()); // blocks until this particular task finishes
        }

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }

    // -------------------------------------------------------------------------
    // DEMO 2: Future with timeout — avoid blocking forever
    // -------------------------------------------------------------------------
    static void demonstrateFutureTimeout() throws InterruptedException {
        System.out.println("\n=== Future with Timeout ===");
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Future<String> slowTask = pool.submit(() -> {
            Thread.sleep(2000); // simulates a very slow operation
            return "Slow result";
        });

        try {
            String result = slowTask.get(500, TimeUnit.MILLISECONDS);
            System.out.println("Got: " + result);
        } catch (TimeoutException e) {
            System.out.println("Task timed out — cancelling");
            slowTask.cancel(true); // interrupt the running task
        } catch (ExecutionException e) {
            System.out.println("Task failed: " + e.getCause());
        }

        pool.shutdownNow();
    }

    // -------------------------------------------------------------------------
    // DEMO 3: invokeAll — wait for all tasks to complete
    // -------------------------------------------------------------------------
    static void demonstrateInvokeAll() throws InterruptedException, ExecutionException {
        System.out.println("\n=== invokeAll ===");
        ExecutorService pool = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            final int n = i;
            tasks.add(() -> {
                Thread.sleep(n * 50L);
                return n * n; // return square of n
            });
        }

        // Blocks until ALL tasks are done; returns Futures in submission order
        List<Future<Integer>> results = pool.invokeAll(tasks);
        System.out.print("Squares: ");
        for (Future<Integer> r : results) {
            System.out.print(r.get() + " "); // each get() returns immediately (already done)
        }
        System.out.println();

        pool.shutdown();
    }

    // -------------------------------------------------------------------------
    // DEMO 4: invokeAny — first successful result wins
    // -------------------------------------------------------------------------
    static void demonstrateInvokeAny() throws InterruptedException, ExecutionException {
        System.out.println("\n=== invokeAny ===");
        ExecutorService pool = Executors.newCachedThreadPool();

        // Simulate querying three replicas; use the fastest response.
        List<Callable<String>> replicas = List.of(
            () -> { Thread.sleep(300); return "Response from replica A"; },
            () -> { Thread.sleep(100); return "Response from replica B"; }, // fastest
            () -> { Thread.sleep(200); return "Response from replica C"; }
        );

        // Returns as soon as one task succeeds; cancels the others
        String winner = pool.invokeAny(replicas);
        System.out.println("invokeAny winner: " + winner);

        pool.shutdown();
    }
}
