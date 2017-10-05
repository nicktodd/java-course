package com.conygre.completion.service;

import java.util.concurrent.Callable;

public class VideoTranscoderCallable implements Callable<String> {

	private String pathOfVideoFileToBeProcessed = null;
	
	public  VideoTranscoderCallable(String pathOfVideoFileToBeProcessed) {
		this.pathOfVideoFileToBeProcessed = pathOfVideoFileToBeProcessed;
	}
	
	
	@Override
	public String call() throws Exception {
		Thread.sleep(10);
		return "completed/" + pathOfVideoFileToBeProcessed;
	}

}
