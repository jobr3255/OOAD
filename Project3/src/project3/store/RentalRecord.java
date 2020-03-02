package project3.store;

import java.util.ArrayList;
import java.util.List;
import project3.rental.car.*;
import project3.rental.Rental;
import project3.rental.option.*;
import project3.customer.Customer;

/**
 *	RentalRecord is a helper for the customer to rent and return cars from the store
 */
public class RentalRecord {

	public static enum RentalStatus { ACTIVE, COMPLETE }

	private List<Rental> carsRented;
	private int dayRented;
	private int nightsRented;
	private Customer customer;
	private RentalStatus status;
	private CarRentalStore store;


	public RentalRecord(CarRentalStore store, Customer customer, int day, int nights) {
		this.carsRented = new ArrayList<Rental>();
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
		if(this.store.getLedger().contains(this)){
			this.status = RentalStatus.COMPLETE;
			// Copy rented cars so the rental record still has the cars with options
			List<Car> returnCars = new ArrayList<Car>();
			for(Rental rental : this.carsRented){
				if(rental instanceof Option){
					Option op = (Option)rental;
					rental = op.rootRental();
				}
				Car car = (Car)rental;
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
  public boolean addCar(Rental rentalCar){
		if(!this.carsRented.contains(rentalCar)){
			rentalCar.setNightsRented(this.nightsRented);
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
	public int getTotal() {
		int total = 0;
		for(Rental c : carsRented) {
			total += c.rentalPrice();
		}
		return total;
	}

	public RentalStatus getStatus() {
		return this.status;
	}

	public Customer getRenter() {
		return this.customer;
	}

	public int getDayRented() {
		return this.dayRented;
	}

	public int getNightsRented() {
		return this.nightsRented;
	}

	public List<Rental> getRentals() {
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
    if(this.status == RentalStatus.ACTIVE)
      formatted += ", Status: ACTIVE";
    else if(this.status == RentalStatus.COMPLETE)
      formatted += ", Status: COMPLETE";
    formatted += "\nRented: (" + this.nightsRented + " nights)";
    for(Rental c : carsRented) {
      formatted += "\n  " + c.description();
		}
		return formatted;
	}

	private String completedRentalString() {
    String formatted = activeRentalString();
    formatted += "\nTotal: $" + this.getTotal();
		return formatted;
	}
}
