package com.conygre.threading.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Demonstrates CountDownLatch (Java 5+).
 *
 * A CountDownLatch is initialised with a count. Threads calling await() block
 * until the count reaches zero, at which point ALL waiting threads are released
 * simultaneously. countDown() decrements the count by one.
 *
 * Key characteristics:
 *   - One-shot: once the count reaches zero it stays at zero; it CANNOT be reset.
 *     (Use CyclicBarrier or Phaser if you need a reusable barrier.)
 *   - Any number of threads can await(); any number of threads can countDown().
 *   - countDown() never blocks — it just decrements the count.
 *
 * Two classic patterns:
 *
 *   STARTING GATE (count = 1):
 *     Initialise with 1. Multiple worker threads call await() to wait at the gate.
 *     A controller thread calls countDown() once, releasing all workers simultaneously.
 *     Useful for: ensuring all threads start together (e.g. for benchmark accuracy).
 *
 *   END GATE (count = N):
 *     Initialise with the number of workers. Workers call countDown() when done.
 *     A waiting thread calls await() to block until all workers have finished.
 *     Useful for: waiting for a batch of concurrent tasks to complete.
 *
 * This demo combines BOTH patterns in a simulated race:
 *   - readyLatch: workers signal they are ready (end gate pattern)
 *   - startLatch: the controller releases all workers at once (starting gate pattern)
 *   - finishLatch: the controller waits for all workers to finish (end gate pattern)
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int runnerCount = 5;

        // End gate: main waits until all runners signal they are ready
        CountDownLatch readyLatch = new CountDownLatch(runnerCount);

        // Starting gate: all runners wait here until the gun fires
        CountDownLatch startLatch = new CountDownLatch(1);

        // End gate: main waits until all runners cross the finish line
        CountDownLatch finishLatch = new CountDownLatch(runnerCount);

        for (int i = 0; i < runnerCount; i++) {
            final int id = i;
            new Thread(() -> {
                // Signal that this runner is at the start line
                System.out.println("Runner " + id + " is at the start");
                readyLatch.countDown();

                try {
                    // Block until the starting gun fires
                    startLatch.await();

                    long time = (long) (Math.random() * 500 + 100);
                    Thread.sleep(time);
                    System.out.println("Runner " + id + " finished in " + time + "ms");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown(); // signal this runner is done
                }
            }, "Runner-" + id).start();
        }

        // Wait at the start line until ALL runners are ready
        readyLatch.await();
        System.out.println("All runners ready — BANG! Race started!");
        startLatch.countDown(); // fire the starting gun; all runners released at once

        // Wait until all runners have crossed the finish line
        finishLatch.await();
        System.out.println("Race complete!");
    }
}
