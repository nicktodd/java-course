import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		SynchronousQueue<String> queue = new SynchronousQueue<>();
		
		
		new Thread( () -> {
			try {
				while(true) {
					String result = queue.take();
					System.out.println("got this from the queue " + result);
				}
			}
			catch(InterruptedException e) {
				
			}
			
		}).start();
		
		
		System.out.println("about to add one");
		queue.put("Fred");
		
		
		System.out.println("added one");
		queue.put("Barnie");
		System.out.println("added two");
		
	}

}
