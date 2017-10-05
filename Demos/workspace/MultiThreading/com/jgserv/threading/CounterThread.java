package com.jgserv.threading;

import java.io.*;

public class CounterThread extends Thread
{
	public static void main (String[] args)
	{
		CounterThread c = new CounterThread();
		c.start();
		String line;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.print ("Running...");
			while ((line=in.readLine()) != null)
			{
				synchronized(c)
				{
					System.out.println ("Counter has been running for "+c.count+" seconds");
				}
			}
		}
		catch (IOException ex) {}
		c.interrupt();
	}

	private int count;
		
	public void run()
	{
		try
		{
			for(;;)
			{
				sleep(1000);
				synchronized(this)
				{
					count++;
				}
			}
		}
		catch (InterruptedException ex) {}		
	}
}
