package com.conygre.threading.patterns;

/**
 * Demonstrates thread-safe Singleton patterns.
 *
 * A Singleton ensures only one instance of a class exists in the JVM.
 * In a multi-threaded environment, naïve lazy initialisation can create
 * multiple instances. Several patterns exist; some are much better than others.
 *
 * This class shows three approaches, from best to worst:
 *
 *   1. Enum singleton           — simplest, most robust (recommended)
 *   2. Initialization-on-demand holder — lazy, lock-free, widely used
 *   3. Double-checked locking   — complex, error-prone (avoid unless necessary)
 *
 * The "just initialise eagerly" approach (static final field in the class)
 * is also valid and simplest of all if lazy loading is not required.
 */
public class SingletonDemo {

    public static void main(String[] args) {
        // Demonstrate that each approach returns the same instance every time
        System.out.println("=== Holder Singleton ===");
        HolderSingleton a = HolderSingleton.getInstance();
        HolderSingleton b = HolderSingleton.getInstance();
        System.out.println("Same instance: " + (a == b)); // true

        System.out.println("\n=== Enum Singleton ===");
        EnumSingleton.INSTANCE.doWork();
        System.out.println("Same instance: "
            + (EnumSingleton.INSTANCE == EnumSingleton.INSTANCE)); // always true

        System.out.println("\n=== Double-Checked (for reference only) ===");
        DoubleCheckedSingleton c = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton d = DoubleCheckedSingleton.getInstance();
        System.out.println("Same instance: " + (c == d)); // true
    }

    // =========================================================================
    // APPROACH 1 (Recommended): Initialization-on-demand holder idiom
    // =========================================================================
    // The static inner class 'Holder' is not loaded by the ClassLoader until
    // getInstance() is called for the first time. Class loading is thread-safe
    // by the JVM specification (class initialisation is performed under a lock),
    // so the singleton is created exactly once without any explicit synchronisation.
    //
    // Properties:
    //   ✓ Lazy (created on first access, not at class load)
    //   ✓ Thread-safe (relies on JVM class loading guarantee)
    //   ✓ No synchronisation overhead on every call
    //   ✓ Works correctly with serialisation if readResolve() is implemented
    static class HolderSingleton {
        private HolderSingleton() {}

        private static class Holder {
            static final HolderSingleton INSTANCE = new HolderSingleton();
        }

        public static HolderSingleton getInstance() {
            return Holder.INSTANCE;
        }

        @Override
        public String toString() {
            return "HolderSingleton@" + Integer.toHexString(System.identityHashCode(this));
        }
    }

    // =========================================================================
    // APPROACH 2 (Simplest and most robust): Enum singleton
    // =========================================================================
    // The JVM guarantees that enum values are instantiated exactly once, and
    // enum instantiation is thread-safe. This is Joshua Bloch's recommendation
    // in Effective Java.
    //
    // Additional advantages over class-based singletons:
    //   ✓ Immune to reflection attacks (cannot call constructor via reflection)
    //   ✓ Serialisation is handled automatically by Java — the same instance
    //     is always returned even after deserialisation (no readResolve needed)
    //
    // Limitation: cannot lazily initialise, cannot extend another class.
    enum EnumSingleton {
        INSTANCE;

        public void doWork() {
            System.out.println("EnumSingleton doing work (identity: "
                + Integer.toHexString(System.identityHashCode(this)) + ")");
        }
    }

    // =========================================================================
    // APPROACH 3 (Avoid): Double-checked locking
    // =========================================================================
    // Shown here for completeness and because it appears often in older code.
    //
    // The volatile keyword on 'instance' is ESSENTIAL:
    //   Without volatile, the JVM may publish a partially-constructed object
    //   due to instruction reordering. Another thread could read a non-null
    //   but incompletely initialised reference and proceed with broken state.
    //   volatile establishes a happens-before relationship, preventing this.
    //
    // Even with volatile this is more complex than it needs to be.
    // Prefer the Holder idiom or Enum singleton.
    static class DoubleCheckedSingleton {
        private static volatile DoubleCheckedSingleton instance; // volatile is mandatory

        private DoubleCheckedSingleton() {}

        public static DoubleCheckedSingleton getInstance() {
            if (instance == null) {                       // First check (no lock)
                synchronized (DoubleCheckedSingleton.class) {
                    if (instance == null) {               // Second check (under lock)
                        instance = new DoubleCheckedSingleton();
                    }
                }
            }
            return instance;
        }
    }
}
