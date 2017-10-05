package com.conygre.callables2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallables {

	public static void main(String[] args) {

		// create an executor to handle our tasks
		ExecutorService engine = Executors.newCachedThreadPool();

		Future<Character> ticket = engine.submit(new RandomLetterCallable());

		
		
		try {
			while (!ticket.isDone()) {
				System.out.println(".");
				Thread.sleep(10);
				ticket.cancel(true);
			}

			if (!ticket.isCancelled()) {
				char result = ticket.get();
				System.out.println(result);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
