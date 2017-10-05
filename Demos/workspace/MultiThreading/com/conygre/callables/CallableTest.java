package com.conygre.callables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newSingleThreadExecutor(); 
		Future<String> f = es.submit( new CallableExample() ); 
		try {
		   while ( ! f.isDone() ) {
		     System.out.print(".");
		     Thread.currentThread().sleep(500);
		   }
		   String callableResult = f.get();
		   System.out.println(callableResult);
		} catch (InterruptedException ie) {
		   // we were interrupted while waiting
		} catch (ExecutionException ee) {
		   // the task threw an exception 
		} 
		
		
	}

}
