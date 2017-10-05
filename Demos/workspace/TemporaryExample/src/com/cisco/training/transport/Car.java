package com.cisco.training.transport;

public class Car extends Vehicle {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("car move");
	}
	public Car(){}
	
	public Car(int speed) {
		super(speed);
	}
	
	
	
}
