package project3.rental.car;

/**
 *	Implements Economy car rental logic
 */
public class SUV extends Car {

	public SUV(String licensePlate) {
		super(licensePlate);
	}

	/**
	 *  @return
	 *     Returns a copy
	 */
	public Car copy() {
		return new SUV(this.licensePlate);
	}

	public int rentalPrice() {
		return 70 * nightsRented;
	}

	public String description() {
		return "SUV[" + licensePlate + "]";
	}
}
