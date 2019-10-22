package edu.uprm.cse.datastructures.cardealer;


import edu.uprm.cse.datastructures.cardealer.model.Car;
import edu.uprm.cse.datastructures.cardealer.util.CircularSortedDoublyLinkedList;

public class MockCarList {
	
	private static final CircularSortedDoublyLinkedList<Car> carList = new CircularSortedDoublyLinkedList<>();
	
	static {
		carList.add(new Car(1, "Toyota", "Echo", "VTI", 5000.0));
		carList.add(new Car(2, "Nissan", "Skyline", "GT-R", 100000.0));
		carList.add(new Car(3, "Tesla", "Model", "X", 50000.0));
		carList.add(new Car(4, "Toyota", "Corolla", "VTI", 7000.0));
		
	}
	
	private MockCarList(){}
	  
	  public static CircularSortedDoublyLinkedList<Car> getInstance(){
	    return carList;
	  }

}
