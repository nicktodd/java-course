package com.conygre.threading.basics;

/**
 * Demonstrates Thread.UncaughtExceptionHandler.
 *
 * When a thread terminates due to an uncaught exception, the JVM calls the
 * thread's UncaughtExceptionHandler. Without a handler, the exception is
 * printed to stderr and the thread silently dies — which can be hard to
 * diagnose in production.
 *
 * Two levels of handler:
 *   1. Per-thread:  thread.setUncaughtExceptionHandler(handler)
 *      Applied to a single thread; overrides the default handler for that thread.
 *
 *   2. Global default: Thread.setDefaultUncaughtExceptionHandler(handler)
 *      Applied to any thread that does not have its own handler set.
 *      Useful for logging all unhandled exceptions in an application.
 *
 * Common uses:
 *   - Logging exceptions from background threads to a monitoring system
 *   - Sending alerts when a critical background thread crashes
 *   - Restarting a crashed thread (though ThreadPoolExecutor is better for this)
 */
public class UncaughtExceptionDemo {

    public static void main(String[] args) throws InterruptedException {

        // Set the global default handler for threads without a per-thread handler.
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) ->
            System.err.println("[DEFAULT HANDLER] Thread '"
                + thread.getName() + "' threw: " + throwable)
        );

        // This thread has its OWN handler — the default handler will NOT be called.
        Thread t1 = new Thread(() -> {
            throw new IllegalStateException("Something went wrong in t1");
        }, "risky-thread-1");

        t1.setUncaughtExceptionHandler((thread, throwable) ->
            System.err.println("[SPECIFIC HANDLER] Thread '"
                + thread.getName() + "' threw: " + throwable)
        );

        // This thread has NO per-thread handler, so the default handler fires.
        Thread t2 = new Thread(() -> {
            throw new RuntimeException("Something went wrong in t2");
        }, "risky-thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
