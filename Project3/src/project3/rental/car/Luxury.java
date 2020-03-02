package project3.rental.car;

/**
 *
 */
public class Luxury extends Car {

	public int rentalPrice() {
		return 100 * nightsRented;
	}

	public Luxury(String licensePlate){
    super(licensePlate);
  }

	public Car copy() {
		return new Luxury(this.licensePlate);
	}

	public String description() {
		return "Luxury[" + licensePlate + "]";
	}
}
