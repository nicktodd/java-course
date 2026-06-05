package com.conygre.threading.locks;

import java.util.concurrent.locks.StampedLock;

/**
 * Demonstrates StampedLock (Java 8+).
 *
 * StampedLock is an alternative to ReentrantReadWriteLock that introduces a
 * third "optimistic read" mode, making read-heavy workloads even faster.
 *
 * The three modes:
 *
 *   1. WRITE lock (exclusive)
 *      long stamp = lock.writeLock();
 *      try { ... } finally { lock.unlockWrite(stamp); }
 *
 *   2. READ lock (shared, pessimistic)
 *      long stamp = lock.readLock();
 *      try { ... } finally { lock.unlockRead(stamp); }
 *
 *   3. OPTIMISTIC READ (no lock acquired)
 *      long stamp = lock.tryOptimisticRead();
 *      // read fields
 *      if (!lock.validate(stamp)) {
 *          // a write happened during our read — fall back to real read lock
 *          stamp = lock.readLock();
 *          try { // re-read fields } finally { lock.unlockRead(stamp); }
 *      }
 *
 * Why optimistic reads are fast:
 *   tryOptimisticRead() does not acquire any lock. It returns a stamp that
 *   encodes the current write version. validate() checks whether any write
 *   occurred since that stamp was obtained. If not, the read is safe and no
 *   locking overhead was paid at all.
 *
 * IMPORTANT differences from ReentrantReadWriteLock:
 *   - StampedLock is NOT reentrant. A thread that already holds the lock
 *     must NOT try to acquire it again — this will deadlock.
 *   - Locks must be released using the stamp returned on acquisition.
 *   - There are no Condition objects; use ReentrantLock if you need them.
 *
 * Best suited for: data structures read very frequently, written rarely,
 * where the overhead of even a read lock would become a bottleneck.
 */
public class StampedLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Point point = new Point(3.0, 4.0);

        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 4; i++) {
                try { Thread.sleep(120); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); return;
                }
                point.move(i * 0.5, i * 0.5);
            }
        }, "writer");

        Thread reader = new Thread(() -> {
            for (int i = 0; i < 8; i++) {
                try { Thread.sleep(60); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); return;
                }
                System.out.printf("Distance from origin: %.2f%n",
                    point.distanceFromOrigin());
            }
        }, "reader");

        writer.start();
        reader.start();
        writer.join();
        reader.join();
    }

    /**
     * An (x, y) point protected by a StampedLock.
     * Reads use optimistic mode; writes use the exclusive write lock.
     */
    static class Point {
        private double x, y;
        private final StampedLock lock = new StampedLock();

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void move(double deltaX, double deltaY) {
            long stamp = lock.writeLock(); // exclusive write
            try {
                x += deltaX;
                y += deltaY;
                System.out.printf("Moved to (%.1f, %.1f)%n", x, y);
            } finally {
                lock.unlockWrite(stamp);
            }
        }

        public double distanceFromOrigin() {
            // Step 1: try optimistic read — no lock acquired
            long stamp = lock.tryOptimisticRead();
            double curX = x;
            double curY = y;

            // Step 2: validate — did a write occur while we were reading?
            if (!lock.validate(stamp)) {
                // Step 3: a write overlapped our read — fall back to a real read lock
                stamp = lock.readLock();
                try {
                    curX = x;
                    curY = y;
                } finally {
                    lock.unlockRead(stamp);
                }
            }
            return Math.sqrt(curX * curX + curY * curY);
        }
    }
}
