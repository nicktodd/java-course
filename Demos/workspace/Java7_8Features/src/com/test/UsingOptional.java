package com.test;

import java.util.Optional;

public class UsingOptional {

	public static void main(String[] args) {

		Person p = new Person();
		p.setAge(20);
		
		p.getName().ifPresent(n -> System.out.println(n));
		
		
	}

}

class Person {

	private int age;
	private Optional<String> name ;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(Optional<String> name) {
		this.name = name;
	}

}