public class SynchroExample implements Runnable{

	private String _str= "";
	
	public void run() {
//		synchronized(this) { // b) In addition to a) put loop of messages in a sync(this) block
		synchronized(_str) { // c) Instead of using this to synchronise on, use a String member variable instead.
			for(int i=0; i<3; i++)
				System.out.println("This is a message from a thread");
		}
		slowMsg("This is a slow message");
	}

	public synchronized	// a)
	void slowMsg(String s) {
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
	}

	SynchroExample() {
//		Thread t= null;
//		for (int i=0; i<2; i++) {
		Thread t= new Thread(new Runnable() {
			public void run(){ System.out.println("Message number 1");	} });
		t.start();
		Thread t2= new Thread(new Runnable() {
			public void run(){ System.out.println("Message number 2");	} });
		t2.start();
		Thread t3= new Thread(new Runnable() {
			public void run(){ System.out.println("Message number 3");	} });
		t3.start();
		}
	
	
	public static void main(String[] args) {
		new SynchroExample();
	}
	
}
