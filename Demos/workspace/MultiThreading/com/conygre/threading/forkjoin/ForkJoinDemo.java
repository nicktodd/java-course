package com.conygre.threading.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Demonstrates the Fork/Join framework (Java 7+).
 *
 * Fork/Join is designed for parallelising DIVIDE-AND-CONQUER algorithms.
 * A large task is recursively split ("forked") into smaller subtasks until
 * they are small enough to compute directly. Results are then merged ("joined")
 * back up the call tree.
 *
 * Key classes:
 *
 *   ForkJoinPool
 *     The thread pool used to execute Fork/Join tasks. The common pool
 *     (ForkJoinPool.commonPool()) is shared across the JVM and is the right
 *     choice for most uses. By default it uses Runtime.availableProcessors()-1
 *     threads. Java 8 parallel streams also use the common pool.
 *
 *   RecursiveTask<V>
 *     A Fork/Join task that RETURNS a value. Override compute() to either:
 *       a) Solve directly if the problem is small enough (base case), or
 *       b) Split into subtasks, fork them, join their results (recursive case).
 *
 *   RecursiveAction
 *     A Fork/Join task with NO return value (e.g. in-place array operations).
 *     Same pattern as RecursiveTask.
 *
 * Work-stealing:
 *   Each worker thread has its own deque of tasks. When a thread runs out
 *   of work, it "steals" tasks from the tail of another thread's deque.
 *   This keeps all CPUs busy and improves throughput on uneven workloads.
 *
 * Threshold:
 *   The threshold controls when to stop splitting and compute directly.
 *   Too small a threshold: overhead of creating tasks outweighs the benefit.
 *   Too large a threshold: insufficient parallelism.
 *   A typical starting point is tasks of a few thousand elements.
 *
 * When to use Fork/Join vs parallel streams:
 *   Parallel streams (array.stream().parallel()) use ForkJoinPool internally
 *   and are simpler for standard aggregate operations.
 *   Use Fork/Join directly when you need custom splitting logic or
 *   non-standard result merging.
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        demonstrateRecursiveTask();
        demonstrateRecursiveAction();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: RecursiveTask — parallel sum of a large array
    // -------------------------------------------------------------------------
    static void demonstrateRecursiveTask() {
        System.out.println("=== RecursiveTask: Parallel Sum ===");

        long[] numbers = new long[10_000_000];
        Arrays.fill(numbers, 1L);

        // Use the common pool — shared across the JVM, no need to shut it down
        ForkJoinPool pool = ForkJoinPool.commonPool();

        long start = System.currentTimeMillis();
        long sum = pool.invoke(new SumTask(numbers, 0, numbers.length));
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Sum of 10,000,000 ones = " + sum
            + " (expected 10000000) in " + elapsed + "ms");
        System.out.println("Pool parallelism: " + pool.getParallelism());
    }

    // -------------------------------------------------------------------------
    // DEMO 2: RecursiveAction — parallel array fill (no return value)
    // -------------------------------------------------------------------------
    static void demonstrateRecursiveAction() {
        System.out.println("\n=== RecursiveAction: Parallel Fill ===");

        int[] data = new int[5_000_000];

        ForkJoinPool.commonPool().invoke(new FillAction(data, 0, data.length, 42));

        boolean correct = data[0] == 42 && data[2_500_000] == 42 && data[4_999_999] == 42;
        System.out.println("Array filled correctly with 42: " + correct);
    }

    // =========================================================================
    // RecursiveTask implementation: sum a sub-range of a long array
    // =========================================================================
    static class SumTask extends RecursiveTask<Long> {

        // Below this threshold, compute the sum sequentially
        private static final int THRESHOLD = 100_000;

        private final long[] array;
        private final int start;
        private final int end;

        SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // Base case: small enough to compute directly
                long sum = 0;
                for (int i = start; i < end; i++) sum += array[i];
                return sum;
            }

            // Recursive case: split in half and process both halves in parallel
            int mid = (start + end) / 2;
            SumTask leftTask  = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            // fork() submits leftTask to the pool asynchronously
            leftTask.fork();

            // compute() right inline (more efficient than forking both)
            long rightResult = rightTask.compute();

            // join() blocks until the left task finishes and returns its result
            long leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }

    // =========================================================================
    // RecursiveAction implementation: fill an int array in parallel
    // =========================================================================
    static class FillAction extends RecursiveAction {

        private static final int THRESHOLD = 50_000;

        private final int[] array;
        private final int start;
        private final int end;
        private final int value;

        FillAction(int[] array, int start, int end, int value) {
            this.array = array;
            this.start = start;
            this.end   = end;
            this.value = value;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                // Base case: fill this range directly
                Arrays.fill(array, start, end, value);
                return;
            }

            // Recursive case: split and fork both halves
            int mid = (start + end) / 2;
            FillAction left  = new FillAction(array, start, mid, value);
            FillAction right = new FillAction(array, mid, end, value);

            // invokeAll forks both tasks and waits for both to complete
            invokeAll(left, right);
        }
    }
}
