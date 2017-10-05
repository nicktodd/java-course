package com.conygre.concurrent.letters;

import java.io.BufferedOutputStream;

public class LettersImplBasic implements Letters {
	private final static int BUFFER_CAPACITY = 2;
	private char[] buffer = new char[BUFFER_CAPACITY];
	private int next = 0;
	private boolean isFull = false;
	private boolean isEmpty = true;

	public synchronized void addLetter(char ch) {
		// wait until pool has room for new letter
		while (isFull) {
			try {
				wait(); // we'll exit this when isFull turns false
			} catch (InterruptedException e) {
			}
		}
		
		
		// add the letter to the next available spot
		buffer[next++] = ch;
		// are we full?
		if (next == BUFFER_CAPACITY) {
			isFull = true;
		}
		isEmpty = false;
		notifyAll();
	}

	public synchronized char takeLetter() {
		// wait until the pool becomes non-empty
		while (isEmpty == true) {
			try {
				wait(); // we'll exit this when isEmpty turns false
			} catch (InterruptedException e) {
				System.out.println("is interrupted");
			}
		}
		// decrement the count, since we're going to remove one letter
		next--;
		// Was this the last letter?
		if (next == 0) {
			isEmpty = true;
		}
		// we know the pool can't be full, because we took a letter
		isFull = false;
		notifyAll();
		
		return (buffer[next]); // return char to Consumer thread
	}
}
