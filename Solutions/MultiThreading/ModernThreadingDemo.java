import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModernThreadingDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		Runnable task = new MyRunnable();

		executor.submit(task);
		executor.submit(task);
		executor.submit(task);

		executor.shutdown();

		// If you are using Java 21+, compare this with:
		// try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
		// 	executor.submit(task);
		// 	executor.submit(task);
		// 	executor.submit(task);
		// }
	}
}