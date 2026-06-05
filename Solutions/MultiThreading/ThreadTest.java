
public class ThreadTest {

	public static void main(String[] args) {
		
		Runnable run = new MyRunnable();
		
		Thread thread1 = new Thread(run, "thread-1");
		Thread thread2 = new Thread(run, "thread-2");
		Thread thread3 = new Thread(run, "thread-3");
		
		thread1.start();
		thread2.start();
		thread3.start();

		// Lambda version for part 1:
		// Runnable lambdaRun = () -> {
		// 	for (int i = 0; i < 3; i++) {
		// 		System.out.println("hello from the lambda thread");
		// 	}
		// };
	}

}

