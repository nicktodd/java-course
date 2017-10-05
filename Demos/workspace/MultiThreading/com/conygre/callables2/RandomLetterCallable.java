package com.conygre.callables2;

import java.util.concurrent.Callable;

public class RandomLetterCallable implements Callable<Character>{

	private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	
	@Override
	public Character call()  {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return  ALPHABET.charAt((int) (Math.random() * 26));
		
	}

	
	
}
