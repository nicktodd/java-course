package com.conygre.concurrent.phasers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker extends Thread {
	private CyclicBarrier theBarrier;

	public Worker(int i, CyclicBarrier b) {
		super("Worker" + i);
		theBarrier = b;
	}

	public void run() {
		try {
			// Wait until all Worker threads reach this point
			// ie are ready to start their work
			System.out.println(this.getName() + " waiting to start");
			//await notifies the barrier
			theBarrier.await();
			// Do some work
			Thread.sleep((int) (Math.random() * 1000));
			System.out.println(this.getName() + " has done its work");
			// Wait until all Worker threads reach this point
			// ie have finished their work
			theBarrier.await();
			System.out.println("finished");
			theBarrier.await();
		} catch (InterruptedException ignore) {
		} catch (BrokenBarrierException bbe) {
			System.out.println("Barrier broken!");
		}
	}
}