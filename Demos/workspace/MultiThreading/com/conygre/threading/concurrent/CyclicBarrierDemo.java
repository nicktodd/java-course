package com.conygre.threading.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Demonstrates CyclicBarrier (Java 5+).
 *
 * A CyclicBarrier makes a fixed set of threads ("parties") wait for each
 * other at a synchronisation point (the barrier). Once ALL parties have
 * arrived, an optional barrier action runs (in one of the arriving threads),
 * and then all threads are released to continue.
 *
 * Key differences from CountDownLatch:
 *   - CyclicBarrier is REUSABLE: it automatically resets for the next round
 *     after each barrier trip, making it "cyclic". CountDownLatch is one-shot.
 *   - CyclicBarrier waits for parties (threads), not a numeric count.
 *   - If a thread is interrupted or times out while waiting, the barrier is
 *     "broken" and remaining threads receive BrokenBarrierException.
 *
 * Key methods:
 *   await()               — signal arrival; block until all parties arrive
 *   await(timeout, unit)  — same, but throws TimeoutException if too long
 *   getNumberWaiting()    — current count of threads waiting at the barrier
 *   reset()               — force-reset the barrier (breaks any waiting threads)
 *   isBroken()            — true if the barrier was broken
 *
 * Typical use case: parallel algorithms that proceed in phases.
 *   All threads must finish phase N before any thread starts phase N+1.
 *   Examples: parallel matrix operations, multi-pass image processing,
 *   simulation steps where all agents must update before the next tick.
 *
 * For dynamic registration/deregistration of parties, see PhaserDemo.
 */
public class CyclicBarrierDemo {

    static final int PHASES = 3;
    static final int WORKERS = 4;

    public static void main(String[] args) throws InterruptedException {

        // The barrier action runs once each time all workers arrive.
        // It runs in one of the arriving threads (not a separate thread).
        CyclicBarrier barrier = new CyclicBarrier(WORKERS, () -> {
            System.out.println("\n  [Barrier] All workers reached the barrier "
                + "— advancing to next phase\n");
        });

        Thread[] workers = new Thread[WORKERS];
        for (int i = 0; i < WORKERS; i++) {
            final int id = i;
            workers[i] = new Thread(() -> {
                try {
                    for (int phase = 1; phase <= PHASES; phase++) {
                        // Simulate work of varying duration
                        long work = (long) (Math.random() * 300 + 50);
                        Thread.sleep(work);
                        System.out.println("  Worker-" + id
                            + " completed phase " + phase
                            + " (took " + work + "ms)");

                        // Block here until all WORKERS threads call await()
                        // The barrier auto-resets after each trip (cyclic!)
                        barrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Worker-" + i);
            workers[i].start();
        }

        for (Thread w : workers) w.join();
        System.out.println("All " + PHASES + " phases complete");
    }
}
