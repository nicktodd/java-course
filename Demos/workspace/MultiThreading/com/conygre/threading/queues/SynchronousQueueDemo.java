package com.conygre.threading.queues;

import java.util.concurrent.SynchronousQueue;

/**
 * Demonstrates SynchronousQueue (Java 5+).
 *
 * SynchronousQueue has ZERO internal capacity. It is not a queue in the
 * traditional sense — it is a direct handoff channel between threads:
 *
 *   - A producer calling put() blocks until a consumer calls take().
 *   - A consumer calling take() blocks until a producer calls put().
 *   - The data passes directly from the producing thread to the consuming thread
 *     without any buffering.
 *
 * This means every put() must rendezvous with a take() before either can proceed.
 *
 * Compare with ArrayBlockingQueue:
 *   ArrayBlockingQueue(5) lets a producer run up to 5 items ahead of the consumer.
 *   SynchronousQueue forces the producer and consumer to meet for every item,
 *   providing maximum backpressure.
 *
 * Where SynchronousQueue is used internally:
 *   Executors.newCachedThreadPool() uses one to hand off tasks from submitting
 *   threads directly to idle worker threads (no queuing — instant handoff or
 *   a new thread is created).
 *
 * Fair mode:
 *   new SynchronousQueue<>(true) — waiting threads served in FIFO order (fairer,
 *   but lower throughput). Default (false) is non-fair.
 *
 * Typical use cases:
 *   - Thread handoff: one thread hands work to a specific waiting thread
 *   - Strict backpressure: producer must wait until consumer is ready
 *   - Pipeline stages: direct coupling of producer and consumer speed
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<String> handoff = new SynchronousQueue<>();

        // The consumer waits for each item individually
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    // take() blocks until a producer calls put()
                    String item = handoff.take();
                    if ("STOP".equals(item)) break;
                    System.out.println("          Consumer received: " + item);
                    Thread.sleep(200); // simulate processing time
                }
                System.out.println("Consumer: done");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "consumer");

        consumer.start();

        // Producer sends items one at a time; each put() blocks until
        // the consumer calls take() — demonstrating strict synchronisation.
        String[] items = {"Fred", "Barnie", "Wilma", "Betty"};
        for (String item : items) {
            System.out.println("Producer: sending '" + item + "'...");
            handoff.put(item); // blocks until consumer calls take()
            System.out.println("Producer: '" + item + "' handed off");
        }

        handoff.put("STOP"); // sentinel to terminate the consumer
        consumer.join();
        System.out.println("Done");
    }
}
