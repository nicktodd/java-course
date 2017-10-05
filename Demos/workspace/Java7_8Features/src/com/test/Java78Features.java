package com.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Java78Features {

	public static void main(String[] args) throws ScriptException, FileNotFoundException {

		ForkJoinPool p = new ForkJoinPool(3);
		Fibonacci f = new Fibonacci(20);
		p.execute(f);
		System.out.println(f.join());
		
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval("print('Hello World!');");
		
		engine.eval(new FileReader("script.js"));


	}

}

@SuppressWarnings("serial")
class Fibonacci extends RecursiveTask<Integer> {

	private final int n;

	public Fibonacci(int n) {
		this.n = n;
	}

	protected Integer compute() {
		System.out.println(Thread.currentThread().getName());
		if (n <= 1)
			return n;
		Fibonacci f1 = new Fibonacci(n - 1);
		f1.fork();
		Fibonacci f2 = new Fibonacci(n - 2);
		return f2.compute() + f1.join();
	}

}
