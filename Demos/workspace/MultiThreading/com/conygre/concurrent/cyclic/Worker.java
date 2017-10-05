package com.conygre.concurrent.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
//			try {
//				theBarrier.await(20, TimeUnit.SECONDS);
//			} catch (TimeoutException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
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