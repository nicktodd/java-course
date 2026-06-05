package com.conygre.threading.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Demonstrates the java.util.concurrent.atomic package.
 *
 * Atomic classes provide thread-safe operations on single variables WITHOUT
 * using synchronized blocks or explicit locks. They use hardware-level
 * Compare-And-Swap (CAS) instructions, which are typically much faster than
 * acquiring a lock, especially under low to moderate contention.
 *
 * Core atomic classes:
 *   AtomicInteger / AtomicLong / AtomicBoolean
 *       Thread-safe wrappers for primitive types.
 *   AtomicReference<T>
 *       Thread-safe wrapper for an object reference.
 *   AtomicIntegerArray / AtomicLongArray / AtomicReferenceArray
 *       Thread-safe element-wise operations on arrays.
 *   LongAdder / LongAccumulator (Java 8+)
 *       Better than AtomicLong for high-contention counters;
 *       uses striped counters to reduce CAS collisions.
 *
 * Key operations on AtomicInteger:
 *   get()                         — read current value
 *   set(int)                      — unconditionally write a value
 *   incrementAndGet()             — atomically ++i (returns new value)
 *   getAndIncrement()             — atomically i++ (returns old value)
 *   addAndGet(delta)              — atomically add and return new value
 *   compareAndSet(expected, update) — CAS: set only if current == expected
 *   updateAndGet(UnaryOperator)   — Java 8+, apply a function atomically
 *
 * When to use atomics vs synchronized:
 *   - Single-variable operations: use atomics (simpler, faster)
 *   - Multi-variable operations that must be atomic together: use synchronized
 *     or ReentrantLock (see locks package)
 */
public class AtomicCounterDemo {

    public static void main(String[] args) throws InterruptedException {
        demonstrateAtomicIncrement();
        demonstrateCompareAndSet();
        demonstrateAtomicReference();
    }

    // --- Atomic increment: multiple threads safely incrementing a counter ---
    static void demonstrateAtomicIncrement() throws InterruptedException {
        System.out.println("=== Atomic Increment ===");
        AtomicInteger counter = new AtomicInteger(0);

        // 10 threads each increment 1000 times = 10,000 total
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();

        // Always prints 10000 because incrementAndGet is atomic.
        // A plain int counter without synchronization would give a wrong result.
        System.out.println("Counter (expected 10000): " + counter.get());
    }

    // --- Compare-And-Set: conditional update ---
    static void demonstrateCompareAndSet() {
        System.out.println("\n=== Compare-And-Set ===");
        AtomicInteger value = new AtomicInteger(5);

        // Succeeds: current value IS 5, so it is updated to 10
        boolean success = value.compareAndSet(5, 10);
        System.out.println("CAS(5 -> 10) succeeded: " + success + ", value: " + value.get());

        // Fails: current value is 10, not 5, so no update occurs
        success = value.compareAndSet(5, 20);
        System.out.println("CAS(5 -> 20) succeeded: " + success + ", value: " + value.get());

        // Java 8+ functional update: atomically apply a function
        int prev = value.getAndUpdate(v -> v * 2); // double the value
        System.out.println("getAndUpdate(*2): was " + prev + ", now " + value.get());
    }

    // --- AtomicReference: thread-safe object reference swap ---
    static void demonstrateAtomicReference() {
        System.out.println("\n=== AtomicReference ===");

        // Useful when you need to atomically swap the object a field points to,
        // for example publishing an updated immutable snapshot.
        AtomicReference<String> ref = new AtomicReference<>("version-1");

        // CAS on a reference uses == (identity) comparison, not equals()
        boolean updated = ref.compareAndSet("version-1", "version-2");
        System.out.println("Updated to version-2: " + updated + ", ref: " + ref.get());

        // Functional update (Java 8+)
        String old = ref.getAndUpdate(v -> v + "-patched");
        System.out.println("Was: " + old + ", now: " + ref.get());
    }
}
