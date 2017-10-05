
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Part 1 Creating a basic thread
		
		Runnable run = new MyRunnable();
		
		Thread thread1 = new Thread(run);
		Thread thread2 = new Thread(run);
		Thread thread3 = new Thread(run);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		
		
	}

}

