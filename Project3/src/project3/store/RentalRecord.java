package project3.store;

import java.util.ArrayList;
import java.util.List;
import project3.rental.car.*;
import project3.rental.option.*;
import project3.customer.Customer;

/**
 *
 */
public class RentalRecord {

	public static enum RentalStatus { ACTIVE, COMPLETE }

	private List<Car> carsRented;
	private int dayRented;
	private int nightsRented;
	private Customer customer;
	private RentalStatus status;
	private CarRentalStore store;


	public RentalRecord(CarRentalStore store, Customer customer, int day, int nights) {
		this.carsRented = new ArrayList<Car>();
		this.status = RentalStatus.ACTIVE;
    this.customer = customer;
    this.dayRented = day;
    this.nightsRented = nights;
		this.store = store;
	}

	/**
	 *  @return boolean
	 *		Returns true if the rental record was successfully completed, otherwise returns false
	 *	Adds car to list of rented cars if the list does not already contain that car
	 */
  public boolean complete(){
		if(this.store.ledger().contains(this)){
			this.status = RentalStatus.COMPLETE;
			// Copy rented cars so the rental record still has the cars with options
			List<Car> returnCars = new ArrayList<Car>();
			for(Car car : this.carsRented){
				returnCars.add(car.copy());
			}
			this.store.addCars(returnCars);
			return true;
		}
		return false;
  }

	/**
	 *  @return boolean
	 *		Returns true if the car was added and false otherwise
	 *	Adds car to list of rented cars if the list does not already contain that car
	 */
  public boolean addCar(Car rentalCar){
		if(!this.carsRented.contains(rentalCar)){
			this.carsRented.add(rentalCar);
			return true;
		}
		return false;
  }

	/***************
	*  Getters
	***************/

	/**
	 *  @return int
	 *  Calculates and returns total cost of the rentals and options
	 */
	public int total() {
		int total = 0;
		for(Car c : carsRented) {
			total += c.rentalPrice() * nightsRented;
			for(Option op : c.options()){
				total += op.rentalPrice();
			}
		}
		return total;
	}

	public RentalStatus status() {
		return this.status;
	}

	public Customer rentedBy() {
		return this.customer;
	}

	public int dayRented() {
		return this.dayRented;
	}

	public int nightsRented() {
		return this.nightsRented;
	}

	public List<Car> rentals() {
		return this.carsRented;
	}

	/***********************
	*  String formatting
	***********************/

	public String toString() {
		if(this.status == RentalStatus.ACTIVE)
      return this.activeRentalString();
		else if(this.status == RentalStatus.COMPLETE)
      return this.completedRentalString();
    return "";
	}

	private String activeRentalString() {
    String formatted = "Renter: " + this.customer.toString();
    // formatted += ", Nights rented: " + this.nightsRented;
    if(this.status == RentalStatus.ACTIVE)
      formatted += ", Status: ACTIVE";
    else if(this.status == RentalStatus.COMPLETE)
      formatted += ", Status: COMPLETE";
    formatted += "\nRented: (" + this.nightsRented + " nights)";
    for(Car c : carsRented) {
      formatted += "\n  " + c.toString();
			if(c.options().size() > 0)
      	formatted += " - Options: " + c.options().toString();
			else
      	formatted += " - No options";
		}
		return formatted;
	}

	private String completedRentalString() {
    String formatted = activeRentalString();
    formatted += "\nTotal: $" + this.total();
		return formatted;
	}

	// public boolean equals(Object obj) {
	// 	if (obj != null && getClass() == obj.getClass()) {
	// 		RentalRecord rr = (RentalRecord)obj;
	// 		return this.carsRented == rr.carsRented &&
	// 					 this.dayRented == rr.dayRented &&
	// 					 this.nightsRented == rr.nightsRented &&
	// 					 this.cucustomer == rr.cucustomer;
	// 	}
	// 	return false;
	// }
}
