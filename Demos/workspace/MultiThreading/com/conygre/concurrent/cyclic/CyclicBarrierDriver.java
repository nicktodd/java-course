package com.conygre.concurrent.cyclic;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDriver {
	public static void main(String[] args) {
		int nThreads = 3;
		// create the CyclicBarrier which will invoke its Runnable 
		// every time it receives 3 notifications from worker threads
		CyclicBarrier barrier = new CyclicBarrier(nThreads, () -> {

			System.out.println("Barrier reached");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		for (int i = 0; i < nThreads; i++) {
			new Worker(i, barrier).start();
		}
	}
}