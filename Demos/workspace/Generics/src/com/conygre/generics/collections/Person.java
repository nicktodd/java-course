package com.conygre.generics.collections;
// Person class that implements Comparable and has a
// compareTo method
public class Person implements Comparable<Person>{

	private String name;
	private String gender;
	private int age;

	public Person(String name, int age)
	{
		this.name=name;
		this.age=age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Person() {}

	public String getName(){
		return name;
	}

	public String getGender(){
		return gender;
	}

	public int getAge(){
		return age;
	}

	public void setName(String s){
		name = s;
	}

	public void setGender(String s){
		if((s.equals("male"))||(s.equals("female"))){
			gender = s;
		}
	}

	public void setAge(int i){
		age = i;
	}


	// get them into ascending age order
	public int compareTo(Person otherPerson)
	{
		return  otherPerson.age - this.age ;
	}
}
