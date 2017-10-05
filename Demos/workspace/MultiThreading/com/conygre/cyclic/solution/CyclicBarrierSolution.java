package com.conygre.cyclic.solution;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSolution {
	
	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(3);
		new Thread(new CountTo20Runnable(barrier)).start();
		new Thread(new CountTo20Runnable(barrier)).start();
		new Thread(new CountTo20Runnable(barrier)).start();		
	}
	
	

}
