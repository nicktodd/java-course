package com.conygre.concurrent.letters;

public class Producer extends Thread {
	private Letters pool;
	private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public Producer(Letters thePool, String threadName) {
		super(threadName); // Sets the thread's name
		this.pool = thePool; // Reference to the shared resource
	}

	public void run() {
		char ch;
		// Add 10 letters to the pool
		for (int i = 0; i < 10; i++) {
			ch = ALPHABET.charAt((int) (Math.random() * 26));
			pool.addLetter(ch);
			// Diagnostic print
			System.out.println("Thread: " + getName() + " added " + ch);
			// Random wait before we add the next letter
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
