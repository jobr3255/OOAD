package project3.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project3.rental.Rental;
import project3.Day;
import project3.observer.Observer;
import project3.store.RentalRecord;

/**
 *	Customer class implements the Observer pattern
 */
abstract public class Customer implements Observer {

	private List<Rental> rentals;
	private List<RentalRecord> rentalRecords;
	private String name;

	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<Rental>();
		this.rentalRecords = new ArrayList<RentalRecord>();
	}

	public void rentCars(RentalRecord rr) {
		this.rentalRecords.add(rr);
		this.rentals.addAll(rr.getRentals());
	}

	/**
	 *  @return boolean
	 *		Returns true if the cars were successfully returned, otherwise returns false
	 */
	public boolean returnCars(RentalRecord rr) {
		this.rentalRecords.remove(rr);
		List<Rental> cars = rr.getRentals();
		this.rentals.removeAll(cars);
		this.rentalRecords.remove(rr);
		return rr.complete();
	}

	/**
	 *  @param int day
	 *		The day the simulation has turned to
	 *  Called when a new day starts in the simulation
	 */
  public void update(int day){
		// Adding to separate array prevents the ConcurrentModificationException
		List<RentalRecord> toReturn = new ArrayList<RentalRecord>();
    for(RentalRecord rr : this.rentalRecords){
      if(day == rr.getDayRented() + rr.getNightsRented()){
				toReturn.add(rr);
      }
    }
		for(RentalRecord rr : toReturn){
			returnCars(rr);
		}
  }

	abstract public int chooseNumRentals();
	abstract public int chooseNumNights();

	/**
	 *  @return String
	 *  Returns string of the type of customer
	 */
	public String getType() {
		return this.getClass().getSimpleName();
	}

	public String toString() {
		return this.name + " (" + this.getType() + ")";
	}

	/***************
	 *  Getters
	 **************/

	public List<Rental> getRentals() {
		return this.rentals;
	}

	public String getName() {
		return this.name;
	}
}
