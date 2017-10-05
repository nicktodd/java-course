package com.c2.vehicle;

import java.io.IOException;
import java.sql.SQLException;

import com.c2.peopole.Person;

public class Car {
	
	 public  Number accelerate(Number n) 
	 {
		 return 2;
	 }
	 public void slowDown()
	 {
		 
	 }
	
	private String name;
	
	
	static
	{
		System.out.println("in car static initialiser");		
	}
	
	
}
