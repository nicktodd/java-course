
public class TestCloseable {
	
	
	
	public static void main(String[] args) {
		
		Thread myThread = new Thread(() -> {
				while(true) {
					System.out.println("hello from the thread");
				}			
		});
		myThread.start();
		
	}

}

