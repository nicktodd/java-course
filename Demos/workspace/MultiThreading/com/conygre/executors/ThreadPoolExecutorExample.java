package com.conygre.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorExample {

	static Executor  engine = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		    ( (ThreadPoolExecutor)engine ).setThreadFactory(new DaemonThreadFactory() );
		    
		    String s = "hello";
		    String s1 = new String("hello");
		    
		    System.out.println(s == s1);
		    
	}
}

class DaemonThreadFactory implements ThreadFactory {
	public Thread newThread(Runnable r) {
		Thread thr = new Thread(r);
		thr.setDaemon(true);
		return thr;
	}
}