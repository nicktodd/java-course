package com.conygre.threading.basics;

/**
 * HISTORICAL REFERENCE: Subclassing Thread directly.
 *
 * This was a common pattern in early Java (Java 1.0–1.4) but is generally
 * discouraged today for the following reasons:
 *
 *   1. Single inheritance limitation: Java classes can only extend one class.
 *      If your class extends Thread, it cannot extend anything else.
 *
 *   2. Tight coupling: the task logic (what to do) is mixed with the thread
 *      mechanism (how it runs). These concerns should be separate.
 *
 *   3. Not compatible with Executor framework: Thread subclasses cannot be
 *      submitted directly to an ExecutorService as tasks.
 *
 * The preferred modern approach is to implement Runnable (or Callable for
 * tasks with return values) and submit to an ExecutorService.
 * See RunnableDemo and the executors package.
 *
 * When you MIGHT still extend Thread:
 *   - Rarely, if you need to override Thread behaviour beyond just run()
 *     (e.g. adding per-thread resources via ThreadLocal would not require it,
 *     but adding a custom join() policy might).
 */
public class LegacyThreadSubclassDemo {

    public static void main(String[] args) throws InterruptedException {
        NamedThread t = new NamedThread("Fred");
        t.start();
        t.join();
        System.out.println("Thread finished");
    }

    /**
     * A Thread subclass. Note that by extending Thread, NamedThread cannot
     * extend any other class. Compare with WorkerRunnable in RunnableDemo,
     * which has no such constraint.
     */
    static class NamedThread extends Thread {
        private final String workerName;

        NamedThread(String workerName) {
            // We could also pass a name to Thread's constructor:
            // super("my-thread-name");
            this.workerName = workerName;
        }

        @Override
        public void run() {
            System.out.println(workerName + " executing on: " + getName());
        }
    }
}
