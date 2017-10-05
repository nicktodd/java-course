package com.conygre.concurrent.letters;

public class ProducerConsumerDriver {
	private static Letters letterPool = new LettersImplQueue();

	public static void main(String[] args) {
		// 2 producers and 2 consumers for now�
		new Producer(letterPool, "Producer1").start();
		new Producer(letterPool, "Producer2").start();
		new Consumer(letterPool, "Consumer1").start();
		new Consumer(letterPool, "Consumer2").start();

	}
}
