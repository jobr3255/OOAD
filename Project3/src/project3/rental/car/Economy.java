package project3.rental.car;

/**
 *
 */
public class Economy extends Car {

	public int rentalPrice() {
		return 50 * nightsRented;
	}

	public Economy(String licensePlate){
    super(licensePlate);
  }

	public Car copy() {
		return new Economy(this.licensePlate);
	}

	public String description() {
		return "Economy[" + licensePlate + "]";
	}
}
