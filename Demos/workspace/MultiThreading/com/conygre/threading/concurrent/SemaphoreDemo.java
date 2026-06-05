package com.conygre.threading.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Demonstrates Semaphore (Java 5+).
 *
 * A Semaphore manages a set of PERMITS. Before a thread can proceed, it must
 * acquire() a permit. If no permits are available, acquire() blocks until one
 * is released by another thread calling release().
 *
 * Semaphore variants:
 *   new Semaphore(n)         — unfair (default): threads are not served in FIFO order
 *   new Semaphore(n, true)   — fair: threads acquire permits in FIFO order
 *                              (prevents starvation, but lower throughput)
 *
 * Key methods:
 *   acquire()                — acquire one permit (blocking)
 *   acquire(n)               — acquire n permits (blocking)
 *   tryAcquire()             — acquire if available, return false immediately if not
 *   tryAcquire(t, unit)      — acquire with timeout
 *   release()                — return one permit
 *   release(n)               — return n permits
 *   availablePermits()       — number of currently available permits
 *
 * Important: unlike synchronized/ReentrantLock, a semaphore CAN be released
 * by a DIFFERENT thread than the one that acquired it. This enables
 * inter-thread signalling patterns.
 *
 * A Semaphore with 1 permit acts as a binary mutex, but unlike ReentrantLock
 * it is NOT reentrant — the same thread acquiring it twice will deadlock.
 *
 * Common use cases:
 *   - Limiting concurrent access to a resource pool (e.g. database connections)
 *   - Throttling: allow at most N operations in parallel
 *   - Signalling: one thread signals another (release before the other acquires)
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        demonstrateConnectionPool();
        demonstrateSignalling();
    }

    // -------------------------------------------------------------------------
    // DEMO 1: Limit concurrent access — simulated connection pool
    // -------------------------------------------------------------------------
    static void demonstrateConnectionPool() throws InterruptedException {
        System.out.println("=== Connection Pool (max 3 concurrent) ===");

        // At most 3 threads may hold a "connection" simultaneously
        Semaphore pool = new Semaphore(3, true); // fair

        Thread[] clients = new Thread[8];
        for (int i = 0; i < 8; i++) {
            final int id = i;
            clients[i] = new Thread(() -> {
                try {
                    System.out.println("Client-" + id + " waiting...");
                    pool.acquire(); // blocks if all 3 slots are taken
                    System.out.println("Client-" + id + " connected ("
                        + (3 - pool.availablePermits()) + "/3 connections in use)");

                    Thread.sleep((long) (Math.random() * 300 + 100)); // simulate work

                    System.out.println("Client-" + id + " disconnected");
                    pool.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Client-" + i);
            clients[i].start();
        }

        for (Thread c : clients) c.join();
        System.out.println("All clients done");
    }

    // -------------------------------------------------------------------------
    // DEMO 2: Binary semaphore for inter-thread signalling
    // -------------------------------------------------------------------------
    // A Semaphore(0) starts with no permits. The consumer must wait until the
    // producer calls release(). This is a lightweight signal mechanism.
    static void demonstrateSignalling() throws InterruptedException {
        System.out.println("\n=== Inter-thread Signalling ===");
        Semaphore signal = new Semaphore(0); // starts locked

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer: waiting for data...");
                signal.acquire(); // blocks until a permit is released
                System.out.println("Consumer: received signal, processing data");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "consumer");

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(300);
                System.out.println("Producer: data ready, signalling consumer");
                signal.release(); // unblocks the consumer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "producer");

        consumer.start();
        Thread.sleep(50); // ensure consumer is waiting first
        producer.start();
        consumer.join();
        producer.join();
    }
}
