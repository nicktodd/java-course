
public class ThreadsWithSubclasses {

	public static void main(String[] args) {
		Thread myThread = new MyThread();
		myThread.start();
		
}
	
}

class MyThread extends Thread
{
	public void run()
	{
		while (true)
		{
			System.out.println("hello from the thread");
		}
	}
}
