package project3;

import project3.rental.car.*;
import project3.rental.Rental;
import project3.store.*;
import project3.customer.*;
import project3.rental.option.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.security.SecureRandom;

/**
 *	Simulates each day and prints all the information
 *  Implements the singleton pattern
 */
public class Simulator
{
	private static Simulator simulator;
	private int MAX_RENTALS = 3;

	private int daysToSimulate = 1;
	private Day today;
	private CarRentalStore store;
  private List<Customer> customers;

	// Singleton logic
	public static Simulator getSimulator(){
		if(simulator == null)
			simulator = new Simulator();
		return simulator;
	}

	private Simulator() {
		this.today = new Day();
	}

	/**
	 *  Runs the simulator for daysToSimulate
	 */
	public void run(){
			for(int i = 1; i <= this.daysToSimulate; i++){
				System.out.println("*****************");
				System.out.println("    Day " + this.today.getToday());
				System.out.println("*****************");
				runDay();
				printDayInfo();
				// Day has ended, start beginning of day before store opens
				if(i != this.daysToSimulate)
					today.nextDay();
			}
			printEndInfo();
	}

	/**
	 *  Simulates a day
	 */
	private void runDay(){
		List<Customer> todaysCustomers = new ArrayList<Customer>();
		// 2 - 10 customers can visit the store each day
		int maxNumCustomers = (new SecureRandom()).nextInt(8) + 2;
		int availableCars;
		for(int i = 0; i < maxNumCustomers; i++){
			Customer c = this.nextCustomer();
			availableCars = this.store.getInventory().size();
			// Stop sending customers to the store if there are no more cars available
			if(availableCars == 0){
				// Store is out of cars to rent.
				break;
			}
			if(!todaysCustomers.contains(c)){
				if(c instanceof Business && availableCars < MAX_RENTALS){
					// Business customer can't visit the store, don't count this iteration
					i--;
					continue;
				}else{
					int getRentals = c.getRentals().size();
					// Business customers will always have either 0 or 3 rentals active and always rents 3 cars
					if(c instanceof Business && getRentals == MAX_RENTALS){
						// Business customer can't visit the store, don't count this iteration
						i--;
						continue;
					}
					if(getRentals == MAX_RENTALS){
						// Customer can't rent any more cars, don't count this iteration
						i--;
						continue;
					}
					// Add customer to list of customers that came in to the store today
					todaysCustomers.add(c);
					simulateCustomerRental(c);
				}
			}else{
				// If chosen customer has already visited the store, don't count this iteration
				i--;
			}
		}
	}

	/**
	 *  Choose the next customer to visit the store
	 */
	public Customer nextCustomer(){
		int customerIndex = (new SecureRandom()).nextInt(this.customers.size());
		return this.customers.get(customerIndex);
	}

	/**
	 *  @return RentalRecord
	 *  	Return RentalRecord of customer transaction. Returns null if customer can't rent any cars
	 *  Simulate a customer visiting the store
	 */
	public RentalRecord simulateCustomerRental(Customer customer){
		// get cutomer rentals
		int numRentals = customer.getRentals().size();
		// calculate max num cars customer can rent
		int maxCanRent = MAX_RENTALS - numRentals;
		if(maxCanRent <= 0)
			return null;
		// choose num cars to rent
		int willRent = customer.chooseNumRentals();
		if(maxCanRent < willRent)
			willRent = maxCanRent;
		int availableCars = this.store.getInventory().size();
		// make sure customer doesnt try to rent more cars than the store has
		if(availableCars < willRent)
			willRent = availableCars;
		// choose between 1-MAX_NIGHTS num nights
		int numNights = customer.chooseNumNights();
		// create rental record
		RentalRecord rentalRecord = new RentalRecord(this.store, customer, this.today.getToday(), numNights);
		for(int i = 0; i < willRent; i++){
			chooseOptions(this.store.rentCar(rentalRecord));
		}
		customer.rentCars(rentalRecord);
		return rentalRecord;
	}

	/**
	 *  Add options to rental
	 *  @param Rental
	 *  	Rental car to add options to
	 */
	public void chooseOptions(Rental rentalCar){
		// Decide to add GPS option or not
		if((new SecureRandom()).nextInt(100) > 50){
			rentalCar = new GPS(rentalCar);
		}
		// Decide to add radio option or not
		if((new SecureRandom()).nextInt(100) > 50){
			rentalCar = new Radio(rentalCar);
		}
		// Decide to add car seats option or not
		if((new SecureRandom()).nextInt(100) > 50){
			int numCarSeats = (new SecureRandom()).nextInt(4);
			for(int i=0; i < numCarSeats; i++){
				rentalCar = new CarSeat(rentalCar);
			}
		}
	}

	/**
	 *  Sets the stores default inventory
	 */
  public void setDefaultStore(){
	 	this.store = new CarRentalStore(new CarFactory());
    // 2 Luxury cars
    store.addNewCars(CarFactory.Category.LUXURY, 2);
    // 5 economy cars
    store.addNewCars(CarFactory.Category.ECONOMY, 5);
    // 5 minivans
    store.addNewCars(CarFactory.Category.MINIVAN, 5);
    // 5 SUVs
    store.addNewCars(CarFactory.Category.SUV, 5);
    // 7 standard cars
    store.addNewCars(CarFactory.Category.STANDARD, 7);
  }

	/**
	 *  Sets the stores default customers
	 */
	public void setDefaultCustomers(){
		this.customers = new ArrayList<Customer>();
		String[] regularCustomerNames = new String[]{
			"Arline","Cedrick","Humberto","Silvia","Hassan","Ross","Marjory","Katelynn","Janice","Christian","Ann","Alberto"};
		for(int i = 0; i < regularCustomerNames.length; i++){
			this.customers.add(new Regular(regularCustomerNames[i]));
		}
		String[] casualCustomerNames = new String[]{
			"Lavon","Claud","Jong","Willa","Octavio","Meg","Elisabeth","Darren","Bradly","Beulah"};
		for(int i = 0; i < casualCustomerNames.length; i++){
			this.customers.add(new Casual(casualCustomerNames[i]));
		}
		String[] businessCustomerNames = new String[]{
			"Oliva","Greg","Oralee","Jama","Piedad","Vicente","Shirlene","Kristal"};
		for(int i = 0; i < businessCustomerNames.length; i++){
			this.customers.add(new Business(businessCustomerNames[i]));
		}
		for(Customer c : this.customers){
			this.today.addObserver(c);
		}
	}

	/**
	 *  Prints the information from a simulated day
	 */
	private void printDayInfo(){
		int totalMadeToday = 0;
		int numCompleted = 0;
		int numActive = 0;

		List<RentalRecord> rentals = this.store.getLedger();
		List<RentalRecord> completedRentals = new ArrayList<RentalRecord>();
		List<RentalRecord> activeRentals = new ArrayList<RentalRecord>();
		for(RentalRecord rr : rentals){
			if(this.today.getToday() == rr.getDayRented() || this.today.getToday() == (rr.getDayRented() + rr.getNightsRented())){
				totalMadeToday += rr.getTotal();
				if(rr.getStatus() == RentalRecord.RentalStatus.COMPLETE){
					numCompleted += rr.getRentals().size();
					completedRentals.add(rr);
				}else if(rr.getStatus() == RentalRecord.RentalStatus.ACTIVE){
					numActive += rr.getRentals().size();
					activeRentals.add(rr);
				}
			}
		}

		System.out.println("-----------------");
		System.out.println("Day " + today.getToday() + " completed rentals: " + numCompleted);
		System.out.println("-----------------");
		for(RentalRecord rr : completedRentals){
			System.out.println(rr.toString());
			System.out.println("---------------------------------------------------");
		}

		System.out.println("-----------------");
		System.out.println("Day " + today.getToday() + " active rentals: " + numActive);
		System.out.println("-----------------");
		for(RentalRecord rr : activeRentals){
			System.out.println(rr.toString());
			System.out.println("---------------------------------------------------");
		}

		System.out.println("-----------------");
		System.out.println("Cars left in store: " + this.store.getInventory().size());
		System.out.println("Total money store made on day " + this.today.getToday() + ": $" + totalMadeToday);
	}

	/**
	 *  Prints the information for the end of the simulation
	 */
	private void printEndInfo(){
		System.out.println("*****************");
		System.out.println("Simulation completed");
		System.out.println("  Simulated " + this.today.getToday() + " days.");
		System.out.println("*****************");

		List<RentalRecord> rentals = this.store.getLedger();
		int totalMade = 0;
		for(RentalRecord rr : rentals){
			totalMade += rr.getTotal();
		}
		List<RentalRecord> getCompletedRentals = this.store.getCompletedRentals();
		System.out.println("Total completed rentals: " + getCompletedRentals.size());
		int numCasual = 0;
		int numRegular = 0;
		int numBusiness = 0;
		for(RentalRecord rr : getCompletedRentals){
			Customer renter = rr.getRenter();
			if(renter instanceof Casual){
				numCasual++;
			}else if(renter instanceof Regular){
				numRegular++;
			}else if(renter instanceof Business){
				numBusiness++;
			}
		}
		System.out.println("  # rented by Casual customers:  " + numCasual);
		System.out.println("  # rented by Regular customers:  " + numRegular);
		System.out.println("  # rented by Business customers:  " + numBusiness);
		System.out.println("Total money the store made: $" + totalMade);
	}

	public Day getDay(){
		return this.today;
	}

	public void setNumDays(int numDays){
		this.daysToSimulate = numDays;
	}

	public CarRentalStore getStore(){
		return this.store;
	}

	public void setStore(CarRentalStore store){
		this.store = store;
	}

	public List<Customer> getCustomers(){
		return this.customers;
	}

	public void setCustomers(List<Customer> customers){
		this.customers = customers;
	}
}
