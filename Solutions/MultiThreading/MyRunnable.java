
public class MyRunnable implements Runnable {

	private final String message = "hello from the thread";
	private final Object lock = new Object();

	public  void run()
	{
		for (int i=0; i<3; i++)
		{
			slowMessage(message);
		}

	}

	public void slowMessage(String s)
	{
		synchronized (lock)
		{
			try {
				for (int i=0; i<s.length(); i++) {
					System.out.print(s.charAt(i));
					Thread.sleep(10);
				}
				System.out.println();
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}

}
