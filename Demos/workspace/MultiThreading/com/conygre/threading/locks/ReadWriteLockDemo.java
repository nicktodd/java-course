package com.conygre.threading.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Demonstrates ReentrantReadWriteLock (Java 5+).
 *
 * A ReadWriteLock maintains a PAIR of associated locks:
 *   - Read lock  (shared):    multiple threads may hold it simultaneously,
 *                             as long as no thread holds the write lock.
 *   - Write lock (exclusive): only one thread may hold it, and only when
 *                             no threads hold the read lock.
 *
 * This is optimal for data structures that are read far more often than
 * written (e.g. configuration caches, reference data, lookup tables).
 * Using a plain ReentrantLock or synchronized would block all reads whenever
 * any reader is active, which is unnecessarily restrictive.
 *
 * Rules at a glance:
 *   Thread holds write lock   → no other thread can hold either lock
 *   Thread holds read lock    → other threads can also hold the read lock,
 *                               but no thread can hold the write lock
 *
 * Important: ReentrantReadWriteLock is NOT a fair lock by default.
 *   Construct with new ReentrantReadWriteLock(true) for fair (FIFO) access.
 *   Without fairness, writers can starve under heavy read load.
 *
 * When to prefer StampedLock (Java 8+):
 *   StampedLock adds an "optimistic read" mode that avoids acquiring the lock
 *   at all for reads, falling back to a real read lock only if a write occurred.
 *   See StampedLockDemo. However, StampedLock is NOT reentrant.
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCache<String, String> cache = new ThreadSafeCache<>();

        // Writer populates the cache slowly
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                cache.put("key" + i, "value" + i);
                System.out.println("Wrote: key" + i + " = value" + i);
                try { Thread.sleep(80); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); break;
                }
            }
        }, "writer");

        // Multiple readers can proceed concurrently while no write is happening
        Thread[] readers = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int readerId = i;
            readers[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    String val = cache.get("key" + j);
                    System.out.println("Reader-" + readerId
                        + " read key" + j + " = " + val);
                    try { Thread.sleep(30); } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); break;
                    }
                }
            }, "reader-" + i);
        }

        writer.start();
        for (Thread r : readers) r.start();
        writer.join();
        for (Thread r : readers) r.join();
    }

    /**
     * A thread-safe cache that allows concurrent reads but exclusive writes.
     *
     * Using HashMap (not ConcurrentHashMap) to demonstrate explicit locking.
     * In practice you might prefer ConcurrentHashMap for its built-in
     * thread safety and higher throughput under concurrent writes.
     */
    static class ThreadSafeCache<K, V> {
        private final Map<K, V> map = new HashMap<>();
        private final ReadWriteLock lock = new ReentrantReadWriteLock();

        /**
         * Multiple threads may call get() simultaneously because they all
         * acquire the READ lock, which is shared.
         */
        public V get(K key) {
            lock.readLock().lock();
            try {
                return map.get(key);
            } finally {
                lock.readLock().unlock(); // always in finally
            }
        }

        /**
         * put() acquires the WRITE lock, which is exclusive.
         * All readers are blocked until the write completes.
         */
        public void put(K key, V value) {
            lock.writeLock().lock();
            try {
                map.put(key, value);
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
