
public class MyRunnable implements Runnable {

	// Part 2
	private String message = "hello from the thread";

	// Part 1
//	public void run() {
//		for (int i=0; i<3; i++)
//		{
//			System.out.println("hello from the thread");
//		}
//	}

	// Part 2
	public  void run()
	{
		for (int i=0; i<3; i++)
		{
			slowMessage(message);
		}

	}

	// Part 2
	public synchronized void slowMessage(String s)
	//public  void slowMessage(String s)
	{
		//synchronized (this)
		//{
			try {
				for (int i=0; i<s.length(); i++) {
					System.out.print(s.charAt(i));
					Thread.sleep(10);
				}
				System.out.println();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
	}

}
