package com.conygre.concurrent.phasers;

import java.util.concurrent.CyclicBarrier;

public class PhaserDriver {
	public static void main(String[] args) {
		int nThreads = 3;
		// create the CyclicBarrier which will invoke its Runnable when 
		// every time it receives 3 notifications from worker threads
		CyclicBarrier barrier = new CyclicBarrier(nThreads, new Runnable() {
			public void run() {
				System.out.println("Barrier reached");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		for (int i = 0; i < nThreads; i++) {
			new Worker(i, barrier).start();
		}
	}
}