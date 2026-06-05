package com.conygre.threading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrates ReentrantLock from java.util.concurrent.locks.
 *
 * ReentrantLock provides the same mutual exclusion as the synchronized keyword
 * but with significantly more flexibility:
 *
 *   tryLock()                   — attempt acquisition without blocking; returns
 *                                 immediately with true/false.
 *   tryLock(timeout, unit)      — attempt acquisition with a timeout.
 *   lockInterruptibly()         — acquire the lock but throw InterruptedException
 *                                 if the thread is interrupted while waiting.
 *   newCondition()              — create a Condition for fine-grained wait/signal,
 *                                 replacing Object.wait()/notify() (see below).
 *   new ReentrantLock(true)     — fair mode: threads acquire in FIFO order,
 *                                 preventing starvation (but lower throughput).
 *   getHoldCount()              — how many times this thread has locked it
 *                                 (lock is "reentrant": same thread can re-acquire).
 *
 * IMPORTANT: always release the lock in a finally block.
 *   lock.lock();
 *   try {
 *       // critical section
 *   } finally {
 *       lock.unlock(); // executed even if an exception is thrown
 *   }
 *
 * When to choose ReentrantLock over synchronized:
 *   - You need tryLock() (non-blocking or timed acquisition)
 *   - You need lockInterruptibly()
 *   - You need multiple Condition objects on the same lock
 *   - You need fairness guarantees
 *   Otherwise, synchronized is simpler and just as effective.
 */
public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {
        demonstrateBasicLock();
        demonstrateTryLock();
        demonstrateCondition();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: Basic lock/unlock as a synchronized replacement
    // -------------------------------------------------------------------------
    static void demonstrateBasicLock() throws InterruptedException {
        System.out.println("=== Basic Lock ===");
        ReentrantLock lock = new ReentrantLock();
        int[] counter = {0}; // array trick: lambda needs effectively-final ref

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock();
                try {
                    counter[0]++;
                } finally {
                    lock.unlock(); // ALWAYS in finally
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter (expected 2000): " + counter[0]);
    }

    // -------------------------------------------------------------------------
    // DEMO 2: tryLock — acquire without blocking indefinitely
    // -------------------------------------------------------------------------
    static void demonstrateTryLock() throws InterruptedException {
        System.out.println("\n=== tryLock ===");
        ReentrantLock lock = new ReentrantLock();

        // Thread that holds the lock for 300ms
        Thread longHolder = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("LongHolder: acquired lock, sleeping 300ms");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
                System.out.println("LongHolder: released lock");
            }
        });

        longHolder.start();
        Thread.sleep(50); // ensure longHolder acquires first

        // Try to acquire the lock with a 100ms timeout
        boolean acquired = false;
        try {
            acquired = lock.tryLock(100, TimeUnit.MILLISECONDS);
            if (acquired) {
                System.out.println("Main: got the lock");
            } else {
                System.out.println("Main: could not acquire lock within 100ms — doing other work");
            }
        } finally {
            if (acquired) lock.unlock();
        }

        longHolder.join();
    }

    // -------------------------------------------------------------------------
    // DEMO 3: Condition — fine-grained wait/signal (replaces wait/notifyAll)
    // -------------------------------------------------------------------------
    // A Condition is always associated with a specific ReentrantLock.
    // You can have MULTIPLE Conditions per lock, which is useful when there
    // are two distinct waiting conditions (e.g. "not full" and "not empty").
    static void demonstrateCondition() throws InterruptedException {
        System.out.println("\n=== Condition ===");
        ReentrantLock lock = new ReentrantLock();
        Condition dataAvailable = lock.newCondition();
        String[] message = {null};

        Thread consumer = new Thread(() -> {
            lock.lock();
            try {
                // await() atomically releases the lock and suspends the thread.
                // When signalled, it re-acquires the lock before returning.
                while (message[0] == null) {
                    try {
                        dataAvailable.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println("Consumer received: " + message[0]);
            } finally {
                lock.unlock();
            }
        }, "consumer");

        Thread producer = new Thread(() -> {
            lock.lock();
            try {
                message[0] = "Hello from producer";
                System.out.println("Producer sent message, signalling consumer");
                dataAvailable.signal(); // wake the waiting consumer
            } finally {
                lock.unlock();
            }
        }, "producer");

        consumer.start();
        Thread.sleep(100); // ensure consumer is waiting first
        producer.start();
        consumer.join();
        producer.join();
    }
}
