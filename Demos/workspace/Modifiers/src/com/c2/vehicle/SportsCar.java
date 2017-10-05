package com.c2.vehicle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

 class SportsCar extends Car {
	 
	
	 
	 @Override
	 public  Double accelerate(Number num)
	 {
		
		 return new Double(1.6);
	 }
	 
	 public static int getAge()
	 {
		 System.out.println("in get age");
		 return 1;
	 }
	 
	 public void slowDown()
	 {
		 
	 }
	
	 
	
	 

	 
	 public static final int AGE = getAge();
		static
		{
			System.out.println("in sportscar static initialiser");		
		}

		
		

}
