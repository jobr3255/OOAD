package project3.rental.car;

/**
 *	Implements Economy car rental logic
 */
public class Standard extends Car {

	public Standard(String licensePlate) {
		super(licensePlate);
	}

	/**
	 *  @return
	 *     Returns a copy
	 */
	public Car copy() {
		return new Standard(this.licensePlate);
	}

	public int rentalPrice() {
		return 40 * nightsRented;
	}

	public String description() {
		return "Standard[" + licensePlate + "]";
	}
}
