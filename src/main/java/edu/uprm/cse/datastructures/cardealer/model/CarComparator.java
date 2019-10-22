package edu.uprm.cse.datastructures.cardealer.model;

import edu.uprm.cse.datastructures.cardealer.util.AbstractComparator;

public class CarComparator extends AbstractComparator<Car> {

	@Override
	public int compare(Car car, Car car2) {
		if (car.getCarBrand().compareTo(car2.getCarBrand()) != 0) {
			return car.getCarBrand().compareTo(car2.getCarBrand());
		} else if (car.getCarModel().compareTo(car2.getCarModel()) != 0) {
			return car.getCarModel().compareTo(car2.getCarModel());
		} else {
			return car.getCarModelOption().compareTo(car2.getCarModelOption());
		}
	}
}