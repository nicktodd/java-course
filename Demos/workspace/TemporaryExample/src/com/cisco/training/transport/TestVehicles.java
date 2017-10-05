package com.cisco.training.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestVehicles {
	
	
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunner("goodbye"));
		
		t1.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.interrupt();
		
		
		
	}

}
class MyRunner implements Runnable {

	private String message;
	
	public MyRunner(String message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(message + "...");
			Thread.yield();
			
			if (Thread.interrupted()) {
				break;
			}
			
		}
		
	}
	
	
	
}



class MyThread extends Thread {
	
	private String message;
	
	public MyThread(String s) {
		message = s;
	}
	
	@Override
	public void run() {
		
		while(true) {
			System.out.println(message + "...");
		}
		
		
	}
	
}
