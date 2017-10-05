package com.jgserv.threading;

import java.io.*;
import java.util.*;

public class Factory
{
	public static void main(String[] args)
	{
		DataOutputStream dout=null;
		try
		{	
			PipedOutputStream pipe = new PipedOutputStream();
			Producer p = new Producer(pipe);
			dout = new DataOutputStream(pipe);

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			for(;;)
			{
				System.out.println ("Type number of objects to build or <Enter> to exit?");
				String line = in.readLine();
				if (line==null || line.length()==0)
				{
					dout.writeInt(0);		// shut down factory
					break;
				}
				try
				{
					int n = Integer.parseInt(line);
					if (n <= 0)
						throw (new NumberFormatException());
					dout.writeInt(n);
				}
				catch (NumberFormatException ex)
				{
					System.out.println (line+": is not a positive integer");
				}
			}
		}
		catch (IOException ex)
			{System.out.println(ex);}
		if (dout!=null)
			try {dout.close();} catch (IOException ex){}
		System.out.println("Factory closed down.");
	}

}



class Carrier
{
	LinkedList list = new LinkedList();
	Consumer consumer = new Consumer(this);
	boolean closingDown;

	public synchronized void add(int n)
	{
		list.add(new Integer(n));
		if (list.size() == 1)		// was empty
		{							// wake up the carrier
			Thread t = new Thread(){
				public void run()
				{
					synchronized(consumer)
					{
						consumer.notify ();
					}
				}
			};
			t.start();
		}
	}
	
	public synchronized int get()
	{
		if (list.size() > 0)
		{
			Integer n = (Integer)list.getFirst();
			list.removeFirst();
			return n.intValue();
		}
		if (closingDown)
		{
			consumer.interrupt();
			consumer = null;
			list = null;
		}
		return -1;
	}

	public synchronized void finish()
	{
		closingDown = true;
		synchronized(consumer)
		{
			consumer.notify ();
		}
	}
}

class Consumer extends Thread
{
	Carrier carrier;
	public Consumer(Carrier c)
	{
		carrier = c;
		start();
	}

	public void run()
	{
		System.out.println ("Consumer starting up");
		try
		{
			for(;;)
			{
				synchronized(this) {wait();}				// wait for wakeup
				int n;
				while ((n=carrier.get()) != -1)
				{
					System.out.println("Comsumed "+n);
					sleep(2000);
				}
			}
		}
		catch (InterruptedException ex) {}
		System.out.println ("Consumer closing down");
	}
}

class Producer extends Thread
{
	DataInputStream din;
	Carrier delivery;
	
	public Producer(PipedOutputStream from)
	{
		try
		{
			PipedInputStream in = new PipedInputStream(from);
			din = new DataInputStream(in);
			delivery = new Carrier();
		}
		catch (IOException ex) {}
		start();
	}

	public void run()
	{
		System.out.println ("Producer starting up");
		try
		{
			for(;;)
			{
				int n = din.readInt();
				if (n == 0)
					break;
				for (int i=1; i<=n; i++)
				{
					System.out.println ("Adding new "+i);
					delivery.add(i);
					sleep(1000);
				}
			}
		}
		catch (IOException ex) {}
		catch (InterruptedException ex) {}

		// close files and loose references to objects
		System.out.println ("Producer closing down");
		delivery.finish();
		delivery = null;
		if (din != null)
			try {din.close();} catch (IOException ex) {}
		din = null;
	}
}

