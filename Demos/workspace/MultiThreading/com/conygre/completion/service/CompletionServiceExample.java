package com.conygre.completion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.conygre.callables2.RandomLetterCallable;

public class CompletionServiceExample {
	
	public static void main(String[] args) {
		// set up the executor to manage the threads
		Executor engine = Executors.newCachedThreadPool();
//		ThreadPoolExecutor tpExecutor = (ThreadPoolExecutor) engine;
//		tpExecutor.setThreadFactory((runnable) -> {
//			Thread t = new Thread(runnable);
//			t.setDaemon(true);
//			return t;
//		});
		// set up the completion service for task submission
		CompletionService<String> service = 
				new ExecutorCompletionService<String>(engine);
		// create some work to do
		for(int i=0; i<100; i++) {
			service.submit(new VideoTranscoderCallable("file" + i));
		}
		// take the first future to complete
		// and get the letter
		
		
		
		try {
			Future<String> firstToComplete = service.take();
			String firstProcessedVideoLocation = firstToComplete.get();
			System.out.println(firstProcessedVideoLocation);
			for (int i=0; i<99;i++) {
				service.take(); // get the other futures but ignore them for now
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
