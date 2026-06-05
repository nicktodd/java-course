package com.conygre.threading.synchronization;

/**
 * Demonstrates the synchronized keyword for mutual exclusion.
 *
 * A race condition occurs when two or more threads read and write shared
 * mutable state without coordination, leading to unpredictable results.
 * The synchronized keyword prevents this by ensuring only one thread at a
 * time executes a critical section.
 *
 * How monitors work:
 *   Every Java object has an intrinsic lock (monitor). A synchronized method
 *   or block acquires this lock on entry and releases it on exit (even if an
 *   exception is thrown). Other threads attempting to acquire the same lock
 *   will block until it is released.
 *
 * Lock object rules:
 *   - synchronized instance method:  lock is 'this'
 *   - synchronized static method:    lock is the Class object
 *   - synchronized(obj) block:       lock is 'obj'
 *   All threads accessing shared state MUST synchronize on the SAME object.
 *
 * Visibility guarantee:
 *   When a thread releases a lock, all writes it made are flushed to main
 *   memory. When another thread acquires the same lock, it reads those writes.
 *   This means synchronized also solves visibility problems (not just atomicity).
 *
 * Limitations:
 *   - No timeout, no try-lock, no interruptible lock acquisition.
 *   - For more flexible locking see the locks package (ReentrantLockDemo).
 */
public class SynchronizedDemo {

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000.0);

        // 10 threads each perform 10 withdrawals of £10.
        // Total withdrawal = £1000, so the final balance should be exactly £0.
        // Without synchronization, concurrent increments cause lost updates and
        // the result would be wrong.
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    account.withdraw(10.0);
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        // With proper synchronization this is always 0.0.
        System.out.println("Final balance: £" + account.getBalance());
    }

    static class BankAccount {
        private double balance;

        BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        // synchronized ensures only one thread can execute this method at a time.
        // The lock is acquired on 'this' (the BankAccount instance).
        public synchronized void withdraw(double amount) {
            if (balance >= amount) {
                // Without synchronized, another thread could read 'balance'
                // between our read and write, leading to incorrect results.
                balance -= amount;
            }
        }

        // Read also synchronized so it sees the latest written value.
        public synchronized double getBalance() {
            return balance;
        }
    }
}
