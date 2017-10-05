package com.cisco.training.transport;

import com.cisco.training.moving.Moveable;

public abstract class Vehicle implements Moveable, Comparable<Vehicle>  {
	
	private int speed;

	@Override
	public int compareTo(Vehicle otherVehicle) {
		// TODO Auto-generated method stub
		return this.speed - otherVehicle.speed;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	public Vehicle(int speed) {
		this.speed = speed;
	}

	public Vehicle(){}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed >= 0 && speed <= 3000)
			this.speed = speed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + speed;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (speed != other.speed)
			return false;
		return true;
	}
	
	
	
	
	
	
}
