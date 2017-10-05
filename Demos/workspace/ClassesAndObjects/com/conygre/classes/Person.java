package com.conygre.classes;

public class Person extends Mammal implements Sleepy, Comparable<Person>{
	
	private String name;
	private int age;
	
	
	public Person(String n, int a) {
		name = n;
		age = a;
	}
	
	public Person() {
		
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + " " + age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void maintainTemp() {
		// TODO Auto-generated method stub
		System.out.println("person maintain temp");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("person sleep");
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if (this.age > o.age)
			return 1;
		else return -1;
	}

	
}
