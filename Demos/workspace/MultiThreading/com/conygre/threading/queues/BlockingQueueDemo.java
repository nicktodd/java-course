package com.conygre.threading.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Demonstrates BlockingQueue (Java 5+) for the producer-consumer pattern.
 *
 * BlockingQueue is the PREFERRED way to pass data between threads. It handles
 * all the synchronisation (wait/notify, locks) internally, so you do not need
 * to write any synchronisation code yourself. See WaitNotifyDemo for the
 * equivalent manual implementation — BlockingQueue is cleaner and less error-prone.
 *
 * Blocking operations (will block the calling thread):
 *   put(e)           — add element; block if the queue is full (bounded queues)
 *   take()           — remove and return head element; block if queue is empty
 *
 * Non-blocking / timed operations:
 *   offer(e)              — add element; return false immediately if full
 *   offer(e, t, unit)     — add element; wait up to timeout; return false if still full
 *   poll()                — remove head; return null immediately if empty
 *   poll(t, unit)         — remove head; wait up to timeout; return null if still empty
 *   peek()                — inspect head without removing; null if empty (non-blocking)
 *
 * Common implementations:
 *   ArrayBlockingQueue(capacity)
 *       Bounded, backed by an array. FIFO order. Capacity is fixed at creation.
 *       Fair constructor option: new ArrayBlockingQueue<>(cap, true) for FIFO thread access.
 *
 *   LinkedBlockingQueue()           — optionally bounded linked-node queue. FIFO.
 *   LinkedBlockingQueue(capacity)   — bounded version.
 *
 *   PriorityBlockingQueue           — unbounded; elements ordered by natural order or Comparator.
 *
 *   SynchronousQueue                — zero-capacity; each put() must rendezvous with a take().
 *                                     See SynchronousQueueDemo.
 *
 *   DelayQueue                      — elements only become available after a per-element delay.
 *
 *   LinkedTransferQueue (Java 7+)   — like SynchronousQueue but optionally buffered.
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // Bounded queue: at most 5 items in flight at once.
        // When full, the producer blocks; when empty, the consumer blocks.
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        int itemCount = 20;

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= itemCount; i++) {
                    queue.put(i); // blocks if the queue is full
                    System.out.println("Produced: " + i
                        + " | queue size: " + queue.size());
                }
                queue.put(-1); // sentinel value to signal end of stream
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "producer");

        // Consumer is slower than the producer, so the queue will fill up,
        // demonstrating that the producer is naturally backpressured.
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int item = queue.take(); // blocks if queue is empty
                    if (item == -1) break;   // sentinel received — stop

                    System.out.println("          Consumed: " + item);
                    Thread.sleep(80);        // simulate slower processing
                }
                System.out.println("Consumer: done");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "consumer");

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
