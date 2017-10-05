package com.examples;

import static java.lang.Math.*;


public class VarArgExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		variableList("hello", "world" , 1,2,3,4,5);
		variableList("h", "y", 3,4);
		
		addDoubles(10.0,10.0);
		
		double d = PI * tan(43) * random();
		
		System.out.printf("my name is %s and my age is %d", "nick", 27);
		
	
	}
	
	private static void variableList(String a, String b, Integer... numbers  )
	{
		System.out.println("the average is ...");
		int sum = 0;
		for (int current : numbers)
		{
			sum+=current;
		}
		double average = sum/numbers.length;
		System.out.println(average);
		

	}
	
	public static void variableList(String s, String s1, Integer a, Integer b)
	{
		System.out.println("in overloaded");
	}
	
	
	public static double addDoubles(Double ...d)
	{
		
		double total = 0;
		for (double current : d)
		{
			total+=current;
		}
		return total;
	}
	
	public static double random() {
		return 0.6;
	}

}
