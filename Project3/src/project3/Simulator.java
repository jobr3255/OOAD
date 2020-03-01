package project3;

import project3.rental.car.*;
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

	public static Simulator getSimulator(){
		if(simulator == null)
			simulator = new Simulator();
		return simulator;
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

	public CarRentalStore getCustomers(){
		return this.store;
	}

	public void setCustomers(List<Customer> customers){
		this.customers = customers;
	}

	public void run(){
			for(int i = 1; i <= this.daysToSimulate; i++){
				System.out.println("*****************");
				System.out.println("    Day " + this.today.today());
				System.out.println("*****************");
				runDay();
				printDayInfo();
				// Day has ended, start beginning of day before store opens
				if(i != this.daysToSimulate)
					today.nextDay();
			}
			printEndInfo();
	}

	public void runDay(){
		List<Customer> todaysCustomers = new ArrayList<Customer>();
		// 2 - 10 customers can visit the store each day
		int maxNumCustomers = (new SecureRandom()).nextInt(8) + 2;
		int availableCars;
		for(int i = 0; i < maxNumCustomers; i++){
			Customer c = this.nextCustomer();
			availableCars = this.store.inventory().size();
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
					int currentRentals = c.currentRentals().size();
					// Business customers will always have either 0 or 3 rentals active and always rents 3 cars
					if(c instanceof Business && currentRentals == MAX_RENTALS){
						// Business customer can't visit the store, don't count this iteration
						i--;
						continue;
					}
					if(currentRentals == MAX_RENTALS){
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
		int numRentals = customer.currentRentals().size();
		// calculate max num cars customer can rent
		int maxCanRent = MAX_RENTALS - numRentals;
		if(maxCanRent <= 0)
			return null;
		// choose num cars to rent
		int willRent = customer.chooseNumRentals();
		if(maxCanRent < willRent)
			willRent = maxCanRent;
		int availableCars = this.store.inventory().size();
		// make sure customer doesnt try to rent more cars than the store has
		if(availableCars < willRent)
			willRent = availableCars;
		// choose between 1-MAX_NIGHTS num nights
		int numNights = customer.chooseNumNights();
		// create rental record
		RentalRecord rentalRecord = new RentalRecord(this.store, customer, this.today.today(), numNights);
		for(int i = 0; i < willRent; i++){
			this.store.rentCar(rentalRecord, chooseOptions());
		}
		customer.rentCars(rentalRecord);
		return rentalRecord;
	}

	public List<Option> chooseOptions(){
		List<Option> options = new ArrayList<Option>();
		// Decide to add GPS option or not
		if((new SecureRandom()).nextInt(100) > 50){
			options.add(new GPS());
		}
		// Decide to add radio option or not
		if((new SecureRandom()).nextInt(100) > 50){
			options.add(new Radio());
		}
		// Decide to add car seats option or not
		if((new SecureRandom()).nextInt(100) > 50){
			int numCarSeats = (new SecureRandom()).nextInt(4);
			for(int i=0; i < numCarSeats; i++){
				options.add(new CarSeat());
			}
		}
		return options;
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

	private Simulator() {
		this.today = new Day();
	}

	private void printDayInfo(){
		int totalMadeToday = 0;
		int numCompleted = 0;
		int numActive = 0;

		List<RentalRecord> rentals = this.store.ledger();
		List<RentalRecord> completedRentals = new ArrayList<RentalRecord>();
		List<RentalRecord> activeRentals = new ArrayList<RentalRecord>();
		for(RentalRecord rr : rentals){
			if(this.today.today() == rr.dayRented() || this.today.today() == (rr.dayRented() + rr.nightsRented())){
				totalMadeToday += rr.total();
				if(rr.status() == RentalRecord.RentalStatus.COMPLETE){
					numCompleted += rr.rentals().size();
					completedRentals.add(rr);
				}else if(rr.status() == RentalRecord.RentalStatus.ACTIVE){
					numActive += rr.rentals().size();
					activeRentals.add(rr);
				}
			}
		}

		System.out.println("-----------------");
		System.out.println("Completed rentals: " + numCompleted);
		System.out.println("-----------------");
		for(RentalRecord rr : completedRentals){
			System.out.println(rr.toString());
			System.out.println("---------------------------------------------------");
		}

		System.out.println("-----------------");
		System.out.println("Active rentals: " + numActive);
		System.out.println("-----------------");
		for(RentalRecord rr : activeRentals){
			System.out.println(rr.toString());
			System.out.println("---------------------------------------------------");
		}

		System.out.println("-----------------");
		System.out.println("Cars left in store: " + this.store.inventory().size());
		System.out.println("Total money store made on day " + this.today.today() + ": $" + totalMadeToday);
	}

	private void printEndInfo(){
		System.out.println("*****************");
		System.out.println("Simulation completed");
		System.out.println("  Simulated " + this.today.today() + " days.");
		System.out.println("*****************");

		List<RentalRecord> rentals = this.store.ledger();
		int totalMade = 0;
		for(RentalRecord rr : rentals){
			totalMade += rr.total();
		}
		List<RentalRecord> completedRentals = this.store.completedRentals();
		System.out.println("Total completed rentals: " + completedRentals.size());
		int numCasual = 0;
		int numRegular = 0;
		int numBusiness = 0;
		for(RentalRecord rr : completedRentals){
			Customer renter = rr.rentedBy();
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
}
