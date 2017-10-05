package com.conygre.classes;
public class PassByValue {
	public static void main(String[] args) {
		int myInt = 10;
		addOne(myInt);
		System.out.println("myInt is now " + myInt);
	}	
	public static void addOne(int someInt) {
		someInt++;
	}
}
