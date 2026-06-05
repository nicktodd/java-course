package com.conygre.threading.basics;

/**
 * Demonstrates the fundamental ways to create and start threads in Java.
 *
 * There are two mechanisms for providing the code a thread should run:
 *
 *   1. Implement the Runnable interface — preferred approach
 *   2. Subclass Thread directly — historical approach, generally avoided
 *      (see LegacyThreadSubclassDemo for why it is discouraged)
 *
 * Since Java 8, a Runnable can be written as a lambda expression because
 * Runnable is a @FunctionalInterface with a single abstract method: run().
 *
 * Key Thread lifecycle methods:
 *   start()  — schedules the thread to run; returns immediately
 *   join()   — blocks the calling thread until the target thread finishes
 *   getName()— returns the thread's name (auto-generated or set in constructor)
 *   isAlive()— returns true if the thread has been started and not yet terminated
 *
 * Note: calling run() directly does NOT start a new thread — it executes
 * the Runnable on the calling thread, just like any other method call.
 */
public class RunnableDemo {

    public static void main(String[] args) throws InterruptedException {

        // --- Approach 1: Anonymous Runnable class (pre-Java 8 style) ---
        // Verbose but explicit; useful when the Runnable needs complex state.
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 (anonymous Runnable) on: "
                    + Thread.currentThread().getName());
            }
        });

        // --- Approach 2: Lambda expression (Java 8+) ---
        // Concise and idiomatic for simple tasks. Works because Runnable
        // is a functional interface.
        Thread t2 = new Thread(() ->
            System.out.println("Thread 2 (lambda) on: "
                + Thread.currentThread().getName())
        );

        // --- Approach 3: Named Runnable class ---
        // Best when the task is complex, needs its own fields, or is reused.
        // You can also give the thread a descriptive name for easier debugging.
        Runnable worker = new WorkerRunnable("Worker-A");
        Thread t3 = new Thread(worker, "my-custom-thread");

        // start() hands the thread off to the JVM scheduler; the order in
        // which the threads actually run is non-deterministic.
        t1.start();
        t2.start();
        t3.start();

        // join() makes the calling thread (main) wait for each to finish.
        // Without join(), main might exit before the worker threads print.
        t1.join();
        t2.join();
        t3.join();

        System.out.println("All threads finished");
    }

    /**
     * A named, reusable Runnable. Implementing Runnable (rather than extending
     * Thread) keeps task logic separate from thread management, and allows this
     * class to extend another class if needed.
     */
    static class WorkerRunnable implements Runnable {
        private final String workerName;

        WorkerRunnable(String workerName) {
            this.workerName = workerName;
        }

        @Override
        public void run() {
            System.out.println(workerName + " executing on thread: "
                + Thread.currentThread().getName());
        }
    }
}
