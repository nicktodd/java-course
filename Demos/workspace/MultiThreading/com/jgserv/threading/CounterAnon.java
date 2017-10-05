package com.jgserv.threading;

import java.io.*;

public class CounterAnon
{
	public static void main (String[] args)
	{
		new CounterAnon();
	}
	
	private int count;
	public CounterAnon()
	{
		Thread c = new Thread() {
			
			public void run()
			{
				try
				{
					for(;;)
					{
						sleep(1000);
						synchronized(CounterAnon.this)
						{
							count++;
						}
					}
				}
				catch (InterruptedException ex) {}		
			}
		};
		
		c.start();
		String line;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.print ("Running...");
			while ((line=in.readLine()) != null)
			{
				synchronized(CounterAnon.this)
				{
					System.out.println ("Counter has been running for "+count+" seconds");
				}
			}
		}
		catch (IOException ex) {}
		c.interrupt();
	}

}
