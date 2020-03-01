package project3.rental.car;

/**
 *
 */
public class SUV extends Car {

	public int rentalPrice() {
		return 70;
	}

	public SUV(String licensePlate){
    super(licensePlate);
  }

	public Car copy() {
		return new SUV(this.licensePlate);
	}
}
