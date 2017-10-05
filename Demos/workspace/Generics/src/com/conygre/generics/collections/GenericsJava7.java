package com.conygre.generics.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GenericsJava7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long cCard = 1234_5678_1234_5678L;
		int someBinaryValue = 0b1110_1100;
		
		Map<String, Integer> anagrams = new HashMap<>();

		List<String> list = new ArrayList<>();
	
		Set<Person> people = new TreeSet<>((p1, p2) -> { return p1.getAge() - p2.getAge(); }) ;
		
		
		
		

	}

}
class MyException extends Exception {
	public MyException(String message, Throwable cause) {
		super(message, cause);

}
}