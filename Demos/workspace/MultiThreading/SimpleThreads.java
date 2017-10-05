
public class SimpleThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		
		Thread myThread = new Thread(new MyRunner("Fred"));
		//myThread.setPriority(2);
		//myThread.setDaemon(true);
		Thread myThread1 = new Thread(new MyRunner("Barnie"));
		//myThread1.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		//myThread1.setDaemon(true);
		//myThread1.setPriority(8);
		myThread.start();
		myThread1.start();
	
//		try {
//			//Thread.sleep(10);
//			//Thread.currentThread().interrupt();
//			
//		}
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	}

}
