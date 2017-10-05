package com.conygre.generics.collections;
import java.util.*;
public class CollectionsWithGenerics
{

	public static void main(String[] args)
	{
		
		Map<String, Person> peopleMap = new HashMap<>();
		peopleMap.put("Fred", new Person("Fred", 20));
		peopleMap.put("Barnie", new Person("Barnie",23));
		
		
		Person personFromMap = peopleMap.get("Barnie");
		
		
		
		
		
		List<Person> myList = new ArrayList<Person>();
		myList.add(new Person("Alex", 4));
		myList.add(new Person("Abi", 5));
		myList.add(new Person("Zach", 2));
		myList.add(new Person("Emily", 1));

		for (Person current : myList) {
			System.out.println("The name is " + current.getName());
		}
		
		Person p = myList.get(0);
		

		Iterator<Person> iter = myList.iterator();
		while (iter.hasNext()) {
			Person p1 = iter.next();
			System.out.println("The name is " + p1.getName());
		}

		Set<Person> mySet = new TreeSet<Person>();
		mySet.add(new Person("Alex", 11));
		mySet.add(new Person("Abi",10));
		mySet.add(new Person("Zach", 3));
		mySet.add(new Person("Emily",111));

		for (Person current : mySet) {
			System.out.println("The name is " + current.getName()+current.getAge());
		}

		Iterator<Person> iterSet = mySet.iterator();
		while (iterSet.hasNext()) {
			Person p1 = iterSet.next();
			System.out.println("The name is " + p1.getName());
		}
		
		class Shop
		{}
		
		Set<Shop> treeSet = new TreeSet<Shop>();
		treeSet.add(new Shop());
		
		for (Shop s : treeSet)
		{
			System.out.println(s);
		}
		
		
		
		

	}
}