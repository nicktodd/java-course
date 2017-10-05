public class MyRunner  implements Runnable {

	private String name = "";
	
	public MyRunner(String name)
	{
		this.name = name;
	}
	public void run()
	{
		while (true)
		{
//			if (Thread.interrupted()) {
//				return;
//			}
			System.out.println("Hello from the thread" + name);
			// what difference will this make, and why
			Thread.yield();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			throw new NullPointerException();
		}
	}
	
}
