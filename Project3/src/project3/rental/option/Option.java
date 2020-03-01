package project3.rental.option;

import project3.rental.Rental;
import project3.store.CarRentalStore;

/**
 * This is the decorator for car to add options to the car
 */
public abstract class Option extends Rental {
	// protected Car car;
	public abstract int rentalPrice();

	// public abstract String description();

	// public int getRentalPrice() {
	// 	return this.car.getRentalPrice() + rentalPrice();
	// }
}
