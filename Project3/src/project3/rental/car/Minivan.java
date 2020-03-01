package project3.rental.car;

/**
 *
 */
public class Minivan extends Car {

	public int rentalPrice() {
		return 60;
	}

	public Minivan(String licensePlate){
    super(licensePlate);
  }

	public Car copy() {
		return new Minivan(this.licensePlate);
	}
}
