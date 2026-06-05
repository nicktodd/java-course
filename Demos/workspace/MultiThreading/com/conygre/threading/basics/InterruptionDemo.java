package com.conygre.threading.basics;

/**
 * Demonstrates correct thread interruption.
 *
 * Threads should be designed to be stoppable. Java uses a cooperative
 * interruption model: one thread requests interruption, the target thread
 * decides how to respond.
 *
 * The interrupt flag:
 *   Thread.interrupt()               — sets the interrupted flag on a thread
 *   Thread.isInterrupted()           — tests the flag WITHOUT clearing it
 *   Thread.interrupted() (static)    — tests AND clears the flag
 *
 * Interaction with blocking methods:
 *   Methods like Thread.sleep(), Object.wait(), and BlockingQueue.take()
 *   throw InterruptedException when the thread is interrupted. Crucially,
 *   throwing InterruptedException CLEARS the interrupt flag. If you catch it
 *   and cannot re-throw it, you MUST restore the flag with:
 *       Thread.currentThread().interrupt();
 *   Otherwise the caller cannot detect that an interruption occurred.
 *
 * Rule of thumb:
 *   - If your method declares throws InterruptedException, just let it propagate.
 *   - If you must catch it (e.g. inside Runnable.run()), restore the flag.
 *   - Never silently swallow InterruptedException.
 */
public class InterruptionDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            System.out.println("Worker started");

            // Check isInterrupted() in the loop guard so the thread can
            // exit cleanly without relying on an exception.
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Worker doing work...");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    // sleep() clears the interrupt flag when it throws, so
                    // we must restore it here before exiting the loop.
                    Thread.currentThread().interrupt();
                    System.out.println("Worker interrupted during sleep — stopping cleanly");
                    break;
                }
            }

            System.out.println("Worker finished (interrupted="
                + Thread.currentThread().isInterrupted() + ")");
        }, "worker-thread");

        worker.start();
        Thread.sleep(1200); // let it run for a while

        System.out.println("Main thread requesting interruption...");
        worker.interrupt();

        worker.join();
        System.out.println("Main thread done");
    }
}
