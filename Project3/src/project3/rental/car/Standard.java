package project3.rental.car;

/**
 *
 */
public class Standard extends Car {

	public int rentalPrice() {
		return 40;
	}

	public Standard(String licensePlate){
    super(licensePlate);
  }

	public Car copy() {
		return new Standard(this.licensePlate);
	}
}
