package com.conygre.spring;

public class Person implements IPerson{

	String name;
	int age;
	Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person()
	{
		
	}
	
}
