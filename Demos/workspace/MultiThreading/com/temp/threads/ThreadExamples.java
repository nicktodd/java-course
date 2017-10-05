package com.temp.threads;

class MyThread extends Thread {
	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	
	public void run() {
		while (!this.isInterrupted()) {
			System.out.println(name + "hello from thread");
			Thread.yield();
		
		}
	}
}

public class ThreadExamples {
	
	public static void main(String[] args) {
		Thread t = new MyThread("Fred");
		//t.setPriority(10);
		Thread t1 = new MyThread("Barnie");
		//t1.setPriority(1);
		t1.start();
		t.start();
		
		
		
		Singleton single = Singleton.getInstance();
		
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.interrupt();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
		
		
	}

}

class Account{
	private double balance;
	
	public void withdraw(double amount) {
		// blah blah blah	
		synchronized (this) {
			balance -= amount;
		}
		
		// blah blah blah
	}
	
	
}


