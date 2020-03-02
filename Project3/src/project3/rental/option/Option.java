package project3.rental.option;

import project3.rental.Rental;
import project3.store.CarRentalStore;

/**
 * This is the decorator for car to add options to the car
 */
public abstract class Option extends Rental {
	protected Rental rental;
	public abstract int rentalPrice();
	public abstract String description();
	public Rental rootRental(){
		if(rental instanceof Option)
			return ((Option)rental).rootRental();
		return rental;
	}
}
