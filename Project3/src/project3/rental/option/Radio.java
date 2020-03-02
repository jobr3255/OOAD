package project3.rental.option;
import project3.rental.car.Car;
import project3.rental.Rental;

/**
 *
 */
public class Radio extends Option {

	public Radio(Rental rental) {
		this.rental = rental;
	}

	public int rentalPrice() {
		return 20;
	}

	public String description() {
		return this.rental.description() + ", satellite radio";
	}
}
