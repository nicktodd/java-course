package com.conygre.cyclic.solution;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CountTo20Runnable implements Runnable {

	private CyclicBarrier barrier;
	
	public  CountTo20Runnable(CyclicBarrier barrier) {
		// TODO Auto-generated constructor stub
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		for(int i=1; i<11; i++) {
			System.out.println(i);
			Thread.yield();
		}
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=11; i<21; i++) {
			System.out.println(i);
			Thread.yield();
		}
		
	}
	
	

}
