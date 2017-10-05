package com.conygre.classes;

public class Singleton  implements ISingleton{
	
	
	private Singleton() {
		
	}
	
	private static Singleton single;
	
	public static Singleton getInstance() {
		
		if (single==null) {
			single=new Singleton();
		}
			
		return single;
		
	}
	
	

}
