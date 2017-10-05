package com.conygre.concurrent.letters;

public class Consumer extends Thread {
	private Letters pool;

	public Consumer(Letters thePool, String threadName) {
		super(threadName); // Sets the thread's name
		this.pool = thePool; // Reference to the shared resource
	}

	public void run() {
		char ch;
		// Take 10 letters from the pool
		for (int i = 0; i < 10; i++) {
			ch = pool.takeLetter();
			// Diagnostic print
			System.out.println("Thread: " + getName() + " took letter : " + ch);
			// Random wait before we grab the next letter
			try {
				sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
			}
		}
	}
}
