package com.conygre.generics.types;

import java.util.Collection;

public class GenericDAO<E> {
	
	
	
	public E getById(int id) {
		System.out.println("got by id");
		return null; 
	}
	
	public void remove(E e) {
		// remove object
		System.out.println("removed");
	}
	
	public Collection<E> getAll() {
		return null;
		
	}

}
