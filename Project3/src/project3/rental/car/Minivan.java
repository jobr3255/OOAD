package project3.rental.car;

/**
 *	Implements Economy car rental logic
 */
public class Minivan extends Car {

	public Minivan(String licensePlate) {
		super(licensePlate);
	}

	/**
	 *  @return
	 *     Returns a copy
	 */
	public Car copy() {
		return new Minivan(this.licensePlate);
	}

	public int rentalPrice() {
		return 60 * nightsRented;
	}

	public String description() {
		return "Minivan[" + licensePlate + "]";
	}
}
