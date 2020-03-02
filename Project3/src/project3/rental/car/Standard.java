package project3.rental.car;

/**
 *
 */
public class Standard extends Car {

	public int rentalPrice() {
		return 40 * nightsRented;
	}

	public Standard(String licensePlate){
    super(licensePlate);
  }

	public Car copy() {
		return new Standard(this.licensePlate);
	}

	public String description() {
		return "Standard[" + licensePlate + "]";
	}
}
