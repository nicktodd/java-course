package com.conygre.concurrent.letters;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class LettersImplSema4 implements Letters {
	private static final int BUFFER_CAPACITY = 5;
	private char[] buffer = new char[BUFFER_CAPACITY];
	private int next = 0;
	private final Semaphore letters = new Semaphore(0);
	
	private final Semaphore spaces = new Semaphore(BUFFER_CAPACITY);

	public void addLetter(char c) {

		
		try {
			spaces.acquire(); // takes 1 from spaces
										// unless it is 0 in which case it will block
			//spaces.tryAcquire(20, TimeUnit.MINUTES);
		} catch (InterruptedException ignore) {
		}
		synchronized (this) {
			buffer[next++] = c;
		}
		letters.release(); // adds 1 to letters
	}

	public char takeLetter() {
		char charToReturn;
		try {
			letters.acquire(); // takes 1 from letters unless it is 0 in
										// which case it will block
		} catch (InterruptedException ignore) {
		}
		synchronized (this) {
			charToReturn = buffer[--next];
			buffer[next] = ' ';
		}
		spaces.release(); // adds 1 to spaces
		return charToReturn;
	}
}