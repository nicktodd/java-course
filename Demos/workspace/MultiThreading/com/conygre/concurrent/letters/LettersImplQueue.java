package com.conygre.concurrent.letters;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LettersImplQueue implements Letters {
	private static final int BUFFER_CAPACITY = 6;
	private BlockingQueue<Character> pool = new ArrayBlockingQueue<Character>(BUFFER_CAPACITY);

	public void addLetter(char c) {
		try {
			pool.put(c); // Blocks if Queue is full, ie. no space
		} catch (InterruptedException e) {

		}
	}

	public char takeLetter() {
		Character c = null;
		try {
			c = pool.take(); // Blocks if queue is empty
		} catch (InterruptedException e) {

		}
		return c;
	}
}
