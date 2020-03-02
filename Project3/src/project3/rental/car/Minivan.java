package project3.rental.car;

/**
 *
 */
public class Minivan extends Car {

	public int rentalPrice() {
		return 60 * nightsRented;
	}

	public Minivan(String licensePlate){
    super(licensePlate);
  }

	public Car copy() {
		return new Minivan(this.licensePlate);
	}

	public String description() {
		return "Minivan[" + licensePlate + "]";
	}
}
