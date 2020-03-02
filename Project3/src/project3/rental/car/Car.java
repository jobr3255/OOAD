package project3.rental.car;

import project3.rental.Rental;
import project3.rental.option.Option;
import project3.store.CarRentalStore;
import java.util.ArrayList;
import java.util.List;

/**
 *	Abstract Car class
 */
public abstract class Car extends Rental {
	protected String licensePlate;

	public Car(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	abstract public Car copy();

	/**
	 *  @return String
	 *  Returns string of the type of car
	 */
	public String getCategory() {
		return this.getClass().getSimpleName();
	}

	public String toString() {
		return this.getCategory() + "[" + licensePlate + "]";
	}

	/**
	 *  Defines that equal Car objects have the same subclass and same licensePlate
	 */
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Car c = (Car)obj;
			return this.licensePlate == c.licensePlate;
		}
		return false;
	}
}
