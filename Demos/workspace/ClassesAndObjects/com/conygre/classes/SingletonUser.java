package com.conygre.classes;

public class SingletonUser {
	
	private ISingleton single;
	
	
	public void doSomethingWithASingleton() {
		
		single = Singleton.getInstance();
		
		
	}
	

}
