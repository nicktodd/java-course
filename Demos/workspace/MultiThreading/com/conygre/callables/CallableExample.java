package com.conygre.callables;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<String> { 
	  public String call() { 
	    String result = "My Result"; 
	    try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // wait 3 seconds  
	    return result; 
	  } 
	}
