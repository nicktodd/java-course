package com.conygre.concurrent.latches;

import java.util.concurrent.CountDownLatch;

public class LatchExample {
	public static void main(String[] args) {
		int nThreads = 6;
		CountDownLatch readyToGo = new CountDownLatch(1);
		CountDownLatch allDone = new CountDownLatch(nThreads);
		
		
		// Create and set up the worker threads�
		for (int i = 0; i < nThreads; i++) {
			new LatchWorker(i, readyToGo, allDone).start();
		}
		//////
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignore) {
		}
		// Now we assume all threads are ready to go, open the latch�
		// the latch opens because the value goes from 1 to 0.
		readyToGo.countDown();
		
		// Wait for all the threads to complete
		try {
			// this will open when all threads are finished, as each thread calls
			// the countDown() method on the allDone latch, so it will also eventually
			// reach 0.
			allDone.await();
		} catch (InterruptedException ie) {
			System.out.println("Interrupted");
		}
		System.out.println("Done!");
	}
}
