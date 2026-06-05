package com.conygre.threading.executors;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Demonstrates ExecutorCompletionService (Java 5+).
 *
 * Problem with a plain list of Futures:
 *   When you submit multiple tasks and iterate their Futures calling get(),
 *   you process results in submission order. If task 0 is slow and task 3
 *   finishes first, you still block on task 0 even though task 3 is ready.
 *
 * Solution: ExecutorCompletionService
 *   It wraps an ExecutorService and internally queues completed Futures as
 *   they finish. Calling take() dequeues the next completed Future, allowing
 *   you to process results in COMPLETION ORDER — fastest first.
 *
 * Key methods:
 *   submit(Callable)    — submit a task (delegates to the underlying executor)
 *   take()              — block until the next task completes; return its Future
 *   poll()              — return the next completed Future, or null if none ready
 *   poll(timeout, unit) — return the next completed Future within timeout, or null
 *
 * Typical use cases:
 *   - A batch of independent tasks where you want to process each result
 *     as soon as it is ready (e.g. image processing, data enrichment)
 *   - "First result wins": take the first completed result and cancel the rest
 *
 * Note: For modern code, CompletableFuture.anyOf / allOf (see completablefuture
 * package) or structured concurrency (see structured package) often provide
 * a more expressive alternative.
 */
public class CompletionServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        demonstrateCompletionOrder();
        demonstrateFirstWins();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: Process results as they complete (completion order)
    // -------------------------------------------------------------------------
    static void demonstrateCompletionOrder()
            throws InterruptedException, ExecutionException {
        System.out.println("=== Completion Order Processing ===");

        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> completionService =
            new ExecutorCompletionService<>(executor);

        String[] files = {"fileA", "fileB", "fileC", "fileD", "fileE"};

        // Submit all tasks up front
        for (String file : files) {
            completionService.submit(() -> {
                long delay = (long) (Math.random() * 400 + 100);
                Thread.sleep(delay);
                return "Processed " + file + " (took " + delay + "ms)";
            });
        }

        // Process results in the order they finish — not submission order
        for (int i = 0; i < files.length; i++) {
            Future<String> done = completionService.take();
            System.out.println(done.get());
        }

        executor.shutdown();
    }

    // -------------------------------------------------------------------------
    // DEMO 2: First result wins — process the fastest, discard the rest
    // -------------------------------------------------------------------------
    static void demonstrateFirstWins() throws InterruptedException, ExecutionException {
        System.out.println("\n=== First Result Wins ===");

        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> cs = new ExecutorCompletionService<>(executor);
        int taskCount = 4;

        for (int i = 0; i < taskCount; i++) {
            final int id = i;
            cs.submit(() -> {
                long delay = (long) (Math.random() * 500 + 100);
                Thread.sleep(delay);
                return "Response from server " + id + " after " + delay + "ms";
            });
        }

        // Take only the first result
        Future<String> first = cs.take();
        System.out.println("First response: " + first.get());

        // Shut down cleanly — remaining tasks will be cancelled
        executor.shutdownNow();
    }
}
