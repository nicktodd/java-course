package com.conygre.generics.collections;

public class GenericPersonComparator 
		implements java.util.Comparator<Person>{
	
	public int compare(Person person1, Person person2)
	{
		
		return ( person2.getAge() - person1.getAge() );
	}

}
