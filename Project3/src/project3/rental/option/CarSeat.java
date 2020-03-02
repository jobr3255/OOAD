package project3.rental.option;
import project3.rental.car.Car;
import project3.rental.Rental;

/**
 *	Implements CarSeat option logic
 */
public class CarSeat extends Option {

	public CarSeat(Rental rental) {
		this.rental = rental;
	}

	public int rentalPrice() {
		return 10;
	}

	public String description() {
		return this.rental.description() + ", child car seat";
	}
}
