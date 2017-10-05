package com.conygre.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args)
	{




		List<Animal> list1 = new ArrayList<Animal>();
		list1.add(new Animal());
		list1.add(new Cat());

		//Can't do this because a list of Dogs is not a type of a list of animals
		//List<Animal> list2= new ArrayList<Dog>();

		// this is OK because now, the list reference can point to any subtyped list
		List<? extends Animal> list2 = new ArrayList<Dog>();

		// this also works as it can point to any kind of list at all
		List<?> list3 = new ArrayList<Cat>();


		// must be Cat or a superclass of Cat
		List<? super Cat> myList;
		//myList = new ArrayList<Cat>(); OR
		myList = new ArrayList<Animal>();


		addToCollectionsOfAnimalsOrSubtypes(list1, new Dog());


	}
	// method to process collections of Cats, Dogs, or Animals
	public static <T extends Animal> void addToCollectionsOfAnimalsOrSubtypes(List<T> list, T animal )
	{
		list.add(animal);

	}







}
