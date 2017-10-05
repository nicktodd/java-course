
public class ArrayTes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t = new Thread(new Runnable(){
			public void run()
			{
				while (true)
				{
					System.out.println("hello from important thread");
					Thread.yield();
				}
			}
		});
		t.setPriority(5);
		
		Thread t1 = new Thread(new Runnable(){
			public void run()
			{
				while (true)
				{
					System.out.println("hello from lesser thread");
					Thread.yield();
				}
			}
		});
		t1.setPriority(5);
		
		t.start();
		t1.start();
		
		
		}



}
