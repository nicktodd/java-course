package com.conygre.concurrent.latches;

import java.util.concurrent.CountDownLatch;

public class LatchWorker extends Thread {
	private CountDownLatch startGate; // What to wait for before starting
	private CountDownLatch endGate; // What to signal when finished

	public LatchWorker(int n, CountDownLatch start, CountDownLatch end) {
		super("LatchWorker" + n);
		startGate = start;
		endGate = end;
	}

	public void run() {
		try {
			startGate.await(); // Wait for latch to open
			System.out.println("i'm off because the first gate opened" + this.getName());
			Thread.sleep((int) (Math.random() * 1000)); // Do something
			//System.out.println("im working af" + this.getName());
		} catch (InterruptedException ie) {
			// Whatever
		} finally {
			endGate.countDown(); // Signal finished
		}
	}
}
