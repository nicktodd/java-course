package com.conygre.classes;
import java.awt.Button;
import java.io.BufferedReader;


public class TestAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc = new Account();
		acc.setBalance(100);
		acc.setName("Fred");
		
		Account acc1 = acc;
		
		acc1.setBalance(0);
		
		// what happens here?
		System.out.println("The balance is " + acc.getBalance());
		 
		
		Person p = new Person("Fred", 20);
		Person p1 = new Person();
		
		Mammal m = new Person();
		m.maintainTemp();
		Object obj = new Person();
		
		Sleepy sl = new Person();
		sl.sleep();
		
		
		Button b;
		
		BufferedReader reader;
		
		
		System.out.println(p);        
		
		p.maintainTemp();
		
		
	}

}
