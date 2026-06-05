package com.conygre.threading.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Demonstrates CompletableFuture (Java 8+).
 *
 * CompletableFuture is the modern replacement for Future and represents the
 * standard approach for asynchronous programming in Java. Unlike Future, it:
 *   - Supports non-blocking callbacks (no polling with isDone())
 *   - Allows chaining of asynchronous steps (pipeline style)
 *   - Supports combining multiple futures in parallel
 *   - Has built-in exception handling in the pipeline
 *   - Can be completed manually (hence "Completable")
 *
 * Starting a pipeline:
 *   supplyAsync(Supplier<T>)    — start async task returning a value
 *   runAsync(Runnable)          — start async task with no return value
 *   (Both use ForkJoinPool.commonPool() by default; an Executor can be
 *    supplied as a second argument to control which thread pool is used.)
 *
 * Transformation (non-blocking callbacks):
 *   thenApply(Function<T,U>)    — transform result; like Stream.map()
 *   thenAccept(Consumer<T>)     — consume result; no return value
 *   thenRun(Runnable)           — run when done; no access to result
 *   thenCompose(Function<T, CompletableFuture<U>>)
 *                               — chain another async stage; like Stream.flatMap()
 *
 * Combining two futures:
 *   thenCombine(other, BiFunction)  — combine results of two futures when both done
 *   thenAcceptBoth(other, BiConsumer)
 *   runAfterBoth(other, Runnable)
 *
 * Waiting for multiple futures:
 *   allOf(futures...)           — returns a future that completes when ALL complete
 *   anyOf(futures...)           — returns a future that completes when ANY completes
 *
 * Exception handling:
 *   exceptionally(Function<Throwable, T>) — provide a fallback value on error
 *   handle(BiFunction<T, Throwable, U>)   — handle both success and failure
 *   whenComplete(BiConsumer<T, Throwable>)— observe completion without changing result
 *
 * Retrieving the result:
 *   get()      — blocking; throws checked exceptions
 *   join()     — blocking; throws unchecked CompletionException (friendlier in streams)
 *   getNow(default)— non-blocking; returns default if not yet done
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        demonstrateChaining();
        demonstrateCombining();
        demonstrateAllOf();
        demonstrateExceptionHandling();
        demonstrateThenCompose();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: Chain transformation steps
    // -------------------------------------------------------------------------
    static void demonstrateChaining() throws ExecutionException, InterruptedException {
        System.out.println("=== Chaining ===");

        CompletableFuture<String> pipeline = CompletableFuture
            .supplyAsync(() -> {
                sleep(100);
                return "  hello world  "; // simulate fetching data
            })
            .thenApply(String::trim)          // trim whitespace
            .thenApply(String::toUpperCase);  // convert to upper case

        // get() blocks until the whole pipeline completes
        System.out.println("Result: " + pipeline.get());
    }

    // -------------------------------------------------------------------------
    // DEMO 2: Combine two independent async tasks when both finish
    // -------------------------------------------------------------------------
    static void demonstrateCombining() throws ExecutionException, InterruptedException {
        System.out.println("\n=== Combining ===");

        // Both run concurrently on ForkJoinPool threads
        CompletableFuture<String> firstName = CompletableFuture.supplyAsync(() -> {
            sleep(200);
            return "Jane";
        });
        CompletableFuture<String> lastName = CompletableFuture.supplyAsync(() -> {
            sleep(100);
            return "Smith";
        });

        // thenCombine waits for BOTH and merges the results
        CompletableFuture<String> fullName = firstName
            .thenCombine(lastName, (f, l) -> f + " " + l);

        System.out.println("Full name: " + fullName.get()); // ~200ms total, not 300ms
    }

    // -------------------------------------------------------------------------
    // DEMO 3: allOf — wait for all futures, then collect results
    // -------------------------------------------------------------------------
    static void demonstrateAllOf() throws ExecutionException, InterruptedException {
        System.out.println("\n=== allOf ===");

        List<CompletableFuture<String>> futures = List.of(
            CompletableFuture.supplyAsync(() -> { sleep(300); return "A"; }),
            CompletableFuture.supplyAsync(() -> { sleep(100); return "B"; }),
            CompletableFuture.supplyAsync(() -> { sleep(200); return "C"; })
        );

        // allOf returns a CompletableFuture<Void> that completes when ALL complete.
        // join() on the individual futures after allOf is instant (they are all done).
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        List<String> results = futures.stream()
            .map(CompletableFuture::join) // non-blocking at this point
            .collect(Collectors.toList());

        System.out.println("All results: " + results);
    }

    // -------------------------------------------------------------------------
    // DEMO 4: Exception handling within the pipeline
    // -------------------------------------------------------------------------
    static void demonstrateExceptionHandling() throws ExecutionException, InterruptedException {
        System.out.println("\n=== Exception Handling ===");

        // exceptionally: triggered on error; provides a fallback value
        CompletableFuture<String> withFallback = CompletableFuture
            .<String>supplyAsync(() -> {
                throw new RuntimeException("Service unavailable");
            })
            .exceptionally(ex -> "Fallback: " + ex.getMessage());

        System.out.println(withFallback.get());

        // handle: receives both the result AND the exception (one will be null)
        CompletableFuture<String> withHandle = CompletableFuture
            .supplyAsync(() -> "OK")
            .handle((result, ex) -> {
                if (ex != null) return "Error: " + ex.getMessage();
                return result.toUpperCase();
            });

        System.out.println("handle result: " + withHandle.get());
    }

    // -------------------------------------------------------------------------
    // DEMO 5: thenCompose — chain dependent async steps (flatMap equivalent)
    // -------------------------------------------------------------------------
    // thenApply returns CompletableFuture<CompletableFuture<T>> (nested).
    // thenCompose flattens that to CompletableFuture<T>.
    // Use it when the next async step depends on the result of the previous one.
    static void demonstrateThenCompose() throws ExecutionException, InterruptedException {
        System.out.println("\n=== thenCompose ===");

        CompletableFuture<String> result = fetchUserId()         // step 1: get user ID
            .thenCompose(userId -> fetchUserProfile(userId));     // step 2: use ID to fetch profile

        System.out.println("Profile: " + result.get());
    }

    // Simulates async step 1: fetch a user ID
    static CompletableFuture<Integer> fetchUserId() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(100);
            return 42;
        });
    }

    // Simulates async step 2: fetch profile using the ID from step 1
    static CompletableFuture<String> fetchUserProfile(int userId) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(100);
            return "Profile for user " + userId;
        });
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
