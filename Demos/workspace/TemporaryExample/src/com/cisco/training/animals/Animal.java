package com.cisco.training.animals;

import com.cisco.training.moving.Moveable;

public abstract class Animal implements Moveable{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("animal move");
	}

}
