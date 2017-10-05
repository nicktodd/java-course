package com.conygre.concurrent.letters;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LettersImplLockobj implements Letters {
	private final static int BUFFER_CAPACITY = 5;
	private char[] buffer = new char[BUFFER_CAPACITY];
	private int next = 0;
	private final Lock bufferLock = new ReentrantLock();
	private final Condition notFull = bufferLock.newCondition();
	private final Condition notEmpty = bufferLock.newCondition();

	public void addLetter(char c) {
		bufferLock.lock();
		try {
			// wait until pool has room for new letter
			while (next == BUFFER_CAPACITY) {
				try {
					// waiting for the pool to have spaces. Signal will come when space
					// available
					notFull.await();
				} catch (InterruptedException ignore) {
				}
			}
			// add the letter to the next available spot
			buffer[next++] = c;
			notEmpty.signalAll();
		} finally {
			bufferLock.unlock();
		}
	}

	public char takeLetter() {
		bufferLock.lock();
		try {
			// wait until the pool has some letters
			while (next == 0) {
				try {
					//notEmpty.await();
					notEmpty.await(20, TimeUnit.SECONDS);
				} catch (InterruptedException ignore) {
				}
			}
			// decrement the count, since we're going to
			// remove one letter
			next--;
			notFull.signalAll();
			return (buffer[next]);
		} finally {
			bufferLock.unlock();
		}
	}
}