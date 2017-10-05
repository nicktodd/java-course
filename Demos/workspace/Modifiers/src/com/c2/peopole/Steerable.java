package com.c2.peopole;

import java.io.Serializable;

public interface Steerable extends Runnable, Serializable{

	public static final int MY_INT = 3;
	
	public abstract void turnLeft();
	void turnRight();
	
}
