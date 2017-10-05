package com.conygre.classes;

public class PassByReference {
	public static void main(String[] args) {
		Person myPerson = new Person("Fred");
		changeName(myPerson);	
	}
	public static void changeName(Person p) {
		p.setName("Barnie");
	}
}
