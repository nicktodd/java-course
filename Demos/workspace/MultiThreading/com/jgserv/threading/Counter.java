package com.jgserv.threading;

import java.io.*;

public class Counter implements Runnable
{
	public static void main (String[] args)
	{
		Counter c = new Counter();
	}

	private Thread t;
	private int count;
		
	public Counter()
	{
		t = new Thread(this);
		t.start();
		String line;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try
		{	
			System.out.print ("Running...");
			while ((line=in.readLine()) != null)
			{
				synchronized(this)
				{
					System.out.println ("Counter has been running for "+count+" seconds");
				}
			}
		}
		catch (IOException ex) {}
		t.interrupt();
	}

	public void run()
	{
		try
		{
			for(;;)
			{
				t.sleep(1000);
				synchronized(this)
				{
					count++;
				}
			}
		}
		catch (InterruptedException ex) {}		
	}
}
