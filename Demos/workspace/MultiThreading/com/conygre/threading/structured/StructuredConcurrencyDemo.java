package com.conygre.threading.structured;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

/**
 * Demonstrates Structured Concurrency (Java 21 preview → standard in Java 25).
 *
 * COMPILATION NOTE:
 *   Java 21–24: compile and run with --enable-preview
 *     javac --enable-preview --release 21 StructuredConcurrencyDemo.java
 *     java  --enable-preview StructuredConcurrencyDemo
 *   Java 25+: no preview flags needed.
 *
 * -------------------------------------------------------------------------
 * What is Structured Concurrency?
 * -------------------------------------------------------------------------
 * Structured concurrency applies the same discipline to concurrent tasks that
 * structured programming (if/for/while) applies to control flow:
 *
 *   - Subtasks are SCOPED: they cannot outlive the block that created them.
 *   - When the scope block exits (normally or exceptionally), ALL subtasks
 *     are guaranteed to have completed or been cancelled.
 *   - There are NO "escaped" threads — no thread leaks.
 *
 * This solves long-standing problems with ExecutorService:
 *   - A subtask failure is hard to propagate to the parent thread.
 *   - Cancellation requires manual coordination.
 *   - Forgetting to await a Future causes silent thread leaks.
 *
 * -------------------------------------------------------------------------
 * StructuredTaskScope policies
 * -------------------------------------------------------------------------
 *
 *   ShutdownOnFailure
 *     If ANY subtask fails, all others are cancelled. The scope waits for
 *     all cancellations to complete. throwIfFailed() propagates the first
 *     failure. Use when ALL subtasks must succeed (parallel fan-out).
 *
 *   ShutdownOnSuccess
 *     If ANY subtask succeeds, all others are cancelled. The scope waits
 *     for all cancellations to complete. result() returns the first
 *     successful value. Use when only the FASTEST result is needed
 *     (hedged requests, querying multiple replicas).
 *
 * Key methods:
 *   scope.fork(Callable)     — submit a subtask; returns a Subtask<T> handle
 *   scope.join()             — wait for the scope's shutdown condition to be met
 *   scope.join().throwIfFailed()  — ShutdownOnFailure: propagate first failure
 *   scope.result()           — ShutdownOnSuccess: get the first successful result
 *   subtask.get()            — retrieve the subtask's result (call after join())
 *   subtask.state()          — UNAVAILABLE, SUCCESS, or FAILED
 */
public class StructuredConcurrencyDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        demonstrateShutdownOnFailure();
        demonstrateShutdownOnSuccess();
        demonstrateFailurePropagation();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: ShutdownOnFailure — all subtasks must succeed
    // -------------------------------------------------------------------------
    // Classic pattern: fetch a user and their orders in parallel.
    // If either call fails, there is no point waiting for the other.
    static void demonstrateShutdownOnFailure() throws InterruptedException, ExecutionException {
        System.out.println("=== ShutdownOnFailure (parallel fan-out) ===");

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            StructuredTaskScope.Subtask<String> userTask  = scope.fork(() -> fetchUser(1));
            StructuredTaskScope.Subtask<String> orderTask = scope.fork(() -> fetchOrders(1));

            scope.join()           // block until both complete or one fails
                 .throwIfFailed(); // re-throw the first failure as ExecutionException

            // Only reached if BOTH tasks succeeded
            System.out.println("User:   " + userTask.get());
            System.out.println("Orders: " + orderTask.get());
        }
    }

    // -------------------------------------------------------------------------
    // DEMO 2: ShutdownOnSuccess — first successful result wins
    // -------------------------------------------------------------------------
    // Hedged request pattern: query multiple replicas and use the fastest.
    // The scope cancels the slower replicas as soon as one responds.
    static void demonstrateShutdownOnSuccess() throws InterruptedException, ExecutionException {
        System.out.println("\n=== ShutdownOnSuccess (first-win / hedged request) ===");

        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {
            scope.fork(() -> { Thread.sleep(300); return "Response from replica A (300ms)"; });
            scope.fork(() -> { Thread.sleep(100); return "Response from replica B (100ms)"; });
            scope.fork(() -> { Thread.sleep(200); return "Response from replica C (200ms)"; });

            scope.join(); // block until the first task succeeds
            System.out.println("Winner: " + scope.result()); // should be replica B
        }
    }

    // -------------------------------------------------------------------------
    // DEMO 3: Failure propagation — clean lifecycle when a subtask throws
    // -------------------------------------------------------------------------
    static void demonstrateFailurePropagation() throws InterruptedException {
        System.out.println("\n=== Failure Propagation ===");

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            scope.fork(() -> { Thread.sleep(200); return "Task A succeeded"; });
            scope.fork(() -> {
                Thread.sleep(50);
                throw new RuntimeException("Task B failed!");
            });

            scope.join().throwIfFailed();
            System.out.println("This line is NOT reached");
        } catch (ExecutionException e) {
            // The cause is the original exception thrown by the failing subtask
            System.out.println("Caught: " + e.getCause().getMessage());
            System.out.println("Task A was automatically cancelled when Task B failed");
        }
    }

    // -------------------------------------------------------------------------
    // Simulated remote service calls
    // -------------------------------------------------------------------------
    static String fetchUser(int id) throws InterruptedException {
        Thread.sleep(150);
        return "User-" + id;
    }

    static String fetchOrders(int userId) throws InterruptedException {
        Thread.sleep(200);
        return "Orders for user " + userId + ": [order-1, order-2]";
    }
}
