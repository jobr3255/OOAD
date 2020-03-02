package project3.rental.car;

/**
 *	Implements Luxury car rental logic
 */
public class Luxury extends Car {

	public Luxury(String licensePlate) {
		super(licensePlate);
	}

	/**
	 *  @return
	 *     Returns a copy
	 */
	public Car copy() {
		return new Luxury(this.licensePlate);
	}

	public int rentalPrice() {
		return 100 * nightsRented;
	}

	public String description() {
		return "Luxury[" + licensePlate + "]";
	}
}
