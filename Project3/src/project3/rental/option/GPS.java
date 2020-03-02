package project3.rental.option;
import project3.rental.car.Car;
import project3.rental.Rental;

/**
 *
 */
public class GPS extends Option {

	public GPS(Rental rental) {
		this.rental = rental;
	}

	public int rentalPrice() {
		return 40;
	}

	public String description() {
		return this.rental.description() + ", GPS";
	}
}
