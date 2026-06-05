package com.conygre.threading.concurrent;

import java.util.concurrent.Phaser;

/**
 * Demonstrates Phaser (Java 7+).
 *
 * Phaser is the most flexible synchronisation barrier. It combines ideas from
 * CountDownLatch (countdown to zero) and CyclicBarrier (reusable, phased) and
 * adds unique capabilities:
 *
 *   Dynamic registration: threads can register and deregister at runtime.
 *     This is the key advantage over CyclicBarrier, which has a fixed party count.
 *
 *   Phase numbering: every time the barrier is tripped, the phase number
 *     increments. You can query getPhase() to find the current phase.
 *
 *   Termination: when all parties deregister the Phaser terminates automatically.
 *     You can also terminate manually with forceTermination().
 *
 *   Tiered Phasers: a child Phaser can be attached to a parent, useful for
 *     tree-structured coordination of many threads.
 *
 * Key methods:
 *   register()                  — register ONE additional party
 *   bulkRegister(n)             — register n additional parties
 *   arriveAndAwaitAdvance()     — signal arrival and block until phase advances
 *   arriveAndDeregister()       — signal arrival and permanently leave the Phaser
 *   arrive()                    — signal arrival WITHOUT waiting (async)
 *   awaitAdvance(phase)         — block until the Phaser advances past the given phase
 *   getPhase()                  — current phase number
 *   getRegisteredParties()      — number of registered parties
 *
 * This demo shows workers that participate in some phases but not all,
 * which is something CyclicBarrier cannot handle.
 */
public class PhaserDemo {

    public static void main(String[] args) throws InterruptedException {
        // Register the main thread as a party so it can drive the phases
        Phaser phaser = new Phaser(1);

        int workerCount = 5;
        for (int i = 0; i < workerCount; i++) {
            final int id = i;
            phaser.register(); // register this worker BEFORE starting it

            new Thread(() -> {
                // --- Phase 0: ALL workers participate ---
                doWork(id, 0);
                phaser.arriveAndAwaitAdvance(); // wait for everyone to finish phase 0

                // --- Phase 1: only workers 0-2 continue; the rest drop out ---
                if (id >= 3) {
                    System.out.println("Worker-" + id
                        + " dropping out after phase 0 "
                        + "(registered parties now: "
                        + (phaser.getRegisteredParties() - 1) + ")");
                    phaser.arriveAndDeregister(); // permanently leave the phaser
                    return;
                }

                doWork(id, 1);
                phaser.arriveAndAwaitAdvance(); // wait for workers 0-2 to finish phase 1

                // --- Phase 2: only workers 0-2 ---
                doWork(id, 2);
                phaser.arriveAndDeregister(); // done; deregister
            }, "Worker-" + i).start();
        }

        // Main thread drives the barrier through each phase
        phaser.arriveAndAwaitAdvance(); // let all 5 workers finish phase 0
        System.out.println("\n>> Main: all workers finished phase 0 <<\n");

        phaser.arriveAndAwaitAdvance(); // let workers 0-2 finish phase 1
        System.out.println("\n>> Main: remaining workers finished phase 1 <<\n");

        phaser.arriveAndDeregister(); // main is done

        // Give remaining threads time to complete phase 2 before printing summary
        Thread.sleep(500);
        System.out.println("\nPhaser terminated: " + phaser.isTerminated());
    }

    static void doWork(int workerId, int phase) {
        long duration = (long) (Math.random() * 200 + 50);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Worker-" + workerId
            + " completed phase " + phase
            + " (" + duration + "ms)");
    }
}
