
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new MyThread2("Fred");
		//t.setDaemon(true);
		//Thread t1 = new MyThread2("Barnie");
		//t1.setDaemon(true);
		t.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.interrupt();
		
		//t1.start();
	}

}

class MyThread2 extends Thread
{
	private String name;
	public MyThread2(String name) {
		this.name=name;
	}
	
	public void run()
	{
		while (true) {
			System.out.println(name + " hello from the thread");
			//Thread.yield();
			if (this.isInterrupted())
				return;
		}
	}
	
}
