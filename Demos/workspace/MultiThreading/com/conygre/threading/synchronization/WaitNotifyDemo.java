package com.conygre.threading.synchronization;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demonstrates Object.wait() and notifyAll() for thread coordination.
 *
 * wait() / notify() / notifyAll() are the classic Java mechanism for one thread
 * to signal another about a state change. They must be called from within a
 * synchronized block on the same monitor object.
 *
 * How it works:
 *   wait()        — atomically releases the lock and suspends the thread.
 *                   When awakened, the thread re-acquires the lock before returning.
 *   notify()      — wakes ONE arbitrarily chosen waiting thread.
 *   notifyAll()   — wakes ALL waiting threads (generally preferred to avoid
 *                   missed signals when multiple threads might be waiting).
 *
 * CRITICAL: always call wait() inside a WHILE loop, not an if statement.
 * Threads can experience spurious wakeups (wake up without being notified),
 * and with notifyAll() multiple threads wake but only one can proceed,
 * so the rest must loop back and wait again.
 *
 * Correct pattern:
 *   synchronized (lock) {
 *       while (!conditionIsTrue()) {
 *           lock.wait();
 *       }
 *       // proceed
 *   }
 *
 * Modern alternative:
 *   In most cases prefer BlockingQueue (see queues package) — it handles all
 *   the wait/notify logic internally with no risk of mistakes.
 *   Use wait/notifyAll when you need custom coordination logic that
 *   BlockingQueue cannot express.
 */
public class WaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.put(i);
                    System.out.println("Produced: " + i
                        + " | buffer size: " + buffer.size());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "producer");

        // Consumer is deliberately slower to demonstrate blocking
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(150); // simulate slower processing
                    int value = buffer.take();
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "consumer");

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Done");
    }

    /**
     * A thread-safe bounded buffer using wait/notifyAll.
     *
     * When the buffer is full, producers wait. When it is empty, consumers wait.
     * Calling notifyAll() after each put/take wakes any threads that may be
     * waiting on the opposite condition.
     */
    static class BoundedBuffer<T> {
        private final Queue<T> queue = new LinkedList<>();
        private final int capacity;

        BoundedBuffer(int capacity) {
            this.capacity = capacity;
        }

        public synchronized void put(T item) throws InterruptedException {
            // While loop — not if — to guard against spurious wakeups and
            // the case where multiple threads wake simultaneously.
            while (queue.size() == capacity) {
                wait(); // releases lock, suspends until notified
            }
            queue.add(item);
            notifyAll(); // wake any threads waiting because the buffer was empty
        }

        public synchronized T take() throws InterruptedException {
            while (queue.isEmpty()) {
                wait(); // releases lock, suspends until notified
            }
            T item = queue.poll();
            notifyAll(); // wake any threads waiting because the buffer was full
            return item;
        }

        public synchronized int size() {
            return queue.size();
        }
    }
}
