package com.conygre.generics.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShowRoomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowRoom<Car> room = new ShowRoom<Car>();
		
		Car car = room.getOffer();
		
		// don't have to use the generics
		ShowRoom room1 = new ShowRoom();
				
		
		room1.setOffer(new Car());
		// can now only get the offer as an object
		Object obj = room1.getOffer();
		// have to cast in order to use it
		Car obj1 = (Car) room1.getOffer();
		
		ShowRoom room2 = new ShowRoom<Car>();
		// still an object as you don't know what type it is
		// on reference
		Object obj2 = room2.getOffer();
		// could now cast the collection
		ShowRoom<Car> room3 = (ShowRoom<Car>) room2;

		// risky! Don't need to cast it. 
		ShowRoom<Car> room4 = room1;
		room4.setOffer(new Car());
		
		
		// here is some dodgy code
		ShowRoom<ClassicCar> room5 = new ShowRoom<ClassicCar>();
		ShowRoom room6 = room5;
		// this works (although not good), as the compiler doesn't know what room6 is a collection of
		ShowRoom<SportsCar> room7 = room6;
		
		room7.setOffer(new SportsCar());
		
		ClassicCar car1 = room5.getOffer();
		
		
		GenericDAO<Car> myDAO = new GenericDAO<Car>();
	
		List<SportsCar> cars = new ArrayList<SportsCar>();
		doSomethingWithCars(cars);
		
}
	
	public static void combineCollections(Collection<? super Car> cars, Collection<? extends Car> carsToAdd) {
		// does stuff with the cars collection
		cars.addAll(carsToAdd);
	}
}
	
	
