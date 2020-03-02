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
		this.rentals.addAll(rr.rentals());
	}

	/**
	 *  @return boolean
	 *		Returns true if the cars were successfully returned, otherwise returns false
	 */
	public void returnCars(RentalRecord rr) {
		this.rentalRecords.remove(rr);
		List<Rental> cars = rr.rentals();
		this.rentals.removeAll(cars);
		this.rentalRecords.remove(rr);
		rr.complete();
	}

  public void update(int day){
		// Adding to separate array prevents the ConcurrentModificationException
		List<RentalRecord> toReturn = new ArrayList<RentalRecord>();
    for(RentalRecord rr : this.rentalRecords){
      if(day == rr.dayRented() + rr.nightsRented()){
				toReturn.add(rr);
      }
    }
		for(RentalRecord rr : toReturn){
			// System.out.println(name + " needs to return " + rr.rentals().toString());
			returnCars(rr);
		}
  }

	abstract public int chooseNumRentals();
	abstract public int chooseNumNights();

	/***************
	 *  Getters
	 **************/

	public List<Rental> currentRentals() {
		return this.rentals;
	}

	public String name() {
		return this.name;
	}

	/**
	 *  @return String
	 *  Returns string of the type of customer
	 */
	public String type() {
		return this.getClass().getSimpleName();
	}

	public String toString() {
		return this.name + " (" + this.type() + ")";
	}
}
