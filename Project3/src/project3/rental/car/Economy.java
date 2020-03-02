package project3.rental.car;

/**
 *	Implements Economy car rental logic
 */
public class Economy extends Car {

	public Economy(String licensePlate){
    super(licensePlate);
  }

/**
 *  @return
 *     Returns a copy
 */
	public Car copy() {
		return new Economy(this.licensePlate);
	}

	public int rentalPrice() {
		return 50 * nightsRented;
	}

	public String description() {
		return "Economy[" + licensePlate + "]";
	}
}
