package project3.rental.car;

import project3.rental.Rental;
import project3.rental.option.Option;
import project3.store.CarRentalStore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Car extends Rental {
	protected String licensePlate;
	protected List<Option> options;

	public Car(String licensePlate) {
		this.licensePlate = licensePlate;
		this.options = new ArrayList<Option>();
	}

	abstract public Car copy();

	/**
	 *  @return String
	 *  Returns string of the type of car
	 */
	public String getCategory() {
		return this.getClass().getSimpleName();
	}

	/**
	 *  @return Lis<Option>
	 *  Returns list of the options added to the car
	 */
	public List<Option> options() {
		return this.options;
	}

	public void addOption(Option op) {
		this.options.add(op);
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public void clearOptions() {
		this.options.clear();
	}

	public String toString() {
		return getCategory() + "[" + licensePlate + "]";
	}

	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Car c = (Car)obj;
			return this.licensePlate == c.licensePlate;
		}
		return false;
	}
}
