package project3.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import junit.framework.AssertionFailedError;
import junit.framework.TestResult;
import junit.framework.TestCase;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project3.rental.car.*;
import project3.rental.Rental;
import project3.rental.option.*;
import project3.store.*;
import project3.*;
import project3.customer.*;
/**
 * Unit test class for project 3
 * Test cases must have the @Test tag and the method name must start with "test"
 */
public class MyUnitTest extends TestCase {
  // Flag to mark if the test passed or failed
  private boolean testPassed;

	public MyUnitTest(String fname) {
		super(fname);
	}

  /**
   *  Tests if car factory successfully makes unique license plates
   */
	@Test
	public void testUniqueLicensePlates() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing license plate uniqueness");
		System.out.println("*********************************");
		CarFactory cf = new CarFactory();
		String lp = "ABC123";
		System.out.println("Adding new license plate '" + lp + "'");
		cf.addLicensePlate(lp);

		System.out.println("Testing plate uniqueness...");
		assertFalse("License plate should not be unique.", cf.isUniquePlate(lp));

		String unique = "123ABC";
		assertTrue("License plate should be unique.", cf.isUniquePlate(unique));
    passed();
	}

  /**
   *  Tests if the default store meets the requirements of 24 cars and at least 2 of each car
   */
	@Test
	public void testCarCatalog() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing rental store car catalog");
		System.out.println("*********************************");
    Simulator sim = Simulator.getSimulator();
    sim.setDefaultStore();

    CarRentalStore store = sim.getStore();
    List<Car> inventory = store.getInventory();
    int numCars = inventory.size();
		System.out.println("Verifying store has 24 cars...");
		assertEquals("The number of cars in the store's inventory is incorrect.", 24, numCars);
		System.out.println("Success.");

    System.out.println("Verifying store has at least 2 of each type of car...");
    int count;
    String type = "";
    String message;
    for (CarFactory.Category category : CarFactory.Category.values()) {
        count = 0;
        for(Car c : inventory){
          type = c.getCategory();
          if(type.equalsIgnoreCase(category.name())){
            count++;
          }
        }
        assertTrue("There should be at least of each car category but found " + count + " for " + category, count >= 2);
    }
		System.out.println("Success.");
    passed();
	}

  /**
   *  Tests if the store inventory correctly changes when a cutomer rental transaction is simulated
   */
	@Test
	public void testInventoryChange() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing renting inventory change");
		System.out.println("*********************************");
		Simulator simulator = Simulator.getSimulator();
    simulator.setDefaultStore();
    Customer cust = new Casual("Cool Guy");
    int initialCount = simulator.getStore().getInventory().size();
    simulator.simulateCustomerRental(cust);
    int newCount = simulator.getStore().getInventory().size();
		System.out.println("Verifying store has 1 less car...");
    assertTrue("One car should have been removed from the stores inventory", initialCount == newCount + 1);
		System.out.println("Success. Inventory changed from " +  initialCount + " to " + newCount);
    passed();
	}

  /**
   *  Tests if the customer now has the car after renting it
   */
	@Test
	public void testCustomerRental() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing customer has car after renting");
		System.out.println("*********************************");
		Simulator simulator = Simulator.getSimulator();
    simulator.setDefaultStore();
    Customer cust = new Casual("Cool Guy");
    RentalRecord rr = simulator.simulateCustomerRental(cust);
    List<Rental> rented = rr.getRentals();
    List<Rental> customerCars = cust.getRentals();
		System.out.println("Verifying customer has rented car...");
    assertEquals("Customer car does not have a rented car.", rented, customerCars);
		System.out.println("Success.");
    passed();
	}

  /**
   *  Tests if the store ledger was updated upon a customer renting cars
   */
	@Test
	public void testStoreLedger() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing store updates ledger on rentals");
		System.out.println("*********************************");
		Simulator simulator = Simulator.getSimulator();
    simulator.setDefaultStore();
    Customer cust = new Casual("Cool Guy");
    int initialCount = simulator.getStore().getLedger().size();
    RentalRecord rr = simulator.simulateCustomerRental(cust);
    int newCount = simulator.getStore().getLedger().size();
		System.out.println("Verifying ledger was updated...");
    assertEquals("Ledger was not updated.", initialCount + 1, newCount);
		System.out.println("Success.");
    passed();
	}

  /**
   *  Tests if cars are returned to the store when a RentalRecord is completed
   */
	@Test
	public void testRentalRecordComplete() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing rental record complete");
		System.out.println("*********************************");
	 	CarRentalStore store = new CarRentalStore(new CarFactory());
    store.addNewCars(CarFactory.Category.STANDARD, 2);
		Simulator simulator = Simulator.getSimulator();
    simulator.setStore(store);

    List<Car> initialInventory = new ArrayList<Car>();
    initialInventory.addAll(simulator.getStore().getInventory());
    Customer cust = new Casual("Cool Guy");
    RentalRecord rr = simulator.simulateCustomerRental(cust);
    rr.complete();
    List<Car> storeInventory = simulator.getStore().getInventory();
		System.out.println("Verifying cars were returned...");
    String inventories = initialInventory.toString() + " After: " + storeInventory.toString();
    boolean inventoriesMatch = initialInventory.containsAll(storeInventory) && storeInventory.containsAll(initialInventory);
    assertTrue("Cars were not returned to the stores inventory. Initial: " + inventories, inventoriesMatch);
		System.out.println("Success.");
    passed();
	}

  /**
   *  Tests if the customer correctly observes the Day object and returns their rentals on time
   */
	@Test
	public void testCustomerReturn() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing customer returns");
		System.out.println("*********************************");
	 	CarRentalStore store = new CarRentalStore(new CarFactory());
    store.addNewCars(CarFactory.Category.STANDARD, 2);
		Simulator simulator = Simulator.getSimulator();
    simulator.setStore(store);

    List<Car> initialInventory = new ArrayList<Car>();
    initialInventory.addAll(simulator.getStore().getInventory());
    Customer cust = new Casual("Cool Guy");
    simulator.getDay().addObserver(cust);
    RentalRecord rr = simulator.simulateCustomerRental(cust);
    int nightsRented = rr.getNightsRented();
		System.out.println("Customer needs to return cars on day " + (1 + nightsRented));
		System.out.println("Advancing days...");
    for(int i=0; i < nightsRented; i++){
      simulator.getDay().nextDay();
  		System.out.println("Day is now " + simulator.getDay().getToday());
    }
		System.out.println("Verifying customer returned car...");
    List<Car> storeInventory = simulator.getStore().getInventory();
    String inventories = initialInventory.toString() + " After: " + storeInventory.toString();
    boolean inventoriesMatch = initialInventory.containsAll(storeInventory) && storeInventory.containsAll(initialInventory);
    assertTrue("Cars were not returned to the stores inventory. Initial: " + inventories, inventoriesMatch);
    // assertEquals("Customer did not return their cars.", initialInventory, storeInventory);
		System.out.println("Success.");
    passed();
	}

  /**
   *  Tests if the simulator restricts customers to 3 rentals at one time
   */
	@Test
	public void testCustomerRentalLimit() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing customer rental restriction of 3");
		System.out.println("*********************************");
	 	CarRentalStore store = new CarRentalStore(new CarFactory());
    store.addNewCars(CarFactory.Category.STANDARD, 4);
		Simulator simulator = Simulator.getSimulator();
    simulator.setStore(store);

    Customer cust = new Casual("Cool Guy");
    RentalRecord rr;
		System.out.println("Simulating 4 purchases...");
    for(int i=0; i < 3; i++){
      rr = simulator.simulateCustomerRental(cust);
    }
    rr = simulator.simulateCustomerRental(cust);
		System.out.println("Verifying 4th transaction failed...");
    assertEquals("Customer rented a 4th car.", null, rr);
		System.out.println("Success.");
    passed();
	}

  /**
   *  Tests that Business customers rent 3 cars for 7 nights
   */
	@Test
	public void testBusinessCustomerBehavior() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing business customer behavior");
		System.out.println("*********************************");
		Simulator simulator = Simulator.getSimulator();
    simulator.setDefaultStore();

    Customer cust = new Business("Cool Business Guy");
    RentalRecord rr = simulator.simulateCustomerRental(cust);
		System.out.println("Verifying business customer rented 3 cars...");
    assertEquals("Business customer did not rent 3 cars.", 3, rr.getRentals().size());
		System.out.println("Success.");

		System.out.println("Verifying business customer rented for 7 nights...");
    assertEquals("Business customer did not rent for 7 nights.", 7, rr.getNightsRented());
		System.out.println("Success.");
    passed();
	}

  /**
   *  Tests if the integrity of the RentalRecord remains intact when cars are returned to the store
   *  This test is needed because the options were getting reset when the car was returned to the store
   */
	@Test
	public void testRentalRecordIntegrity() {
    before();
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("Testing rental records integrity after a return");
		System.out.println("*********************************");
	 	CarRentalStore store = new CarRentalStore(new CarFactory());
    store.addNewCars(CarFactory.Category.STANDARD, 1);
    store.addNewCars(CarFactory.Category.LUXURY, 1);
		Simulator simulator = Simulator.getSimulator();
    simulator.setStore(store);

    Customer cust = new Casual("Cool Guy");
    // Rent car for 3 nights
    RentalRecord rentalRecord = new RentalRecord(simulator.getStore(), cust, 1, 3);
    Rental rental1 = simulator.getStore().rentCar(rentalRecord);
    rental1 = new GPS(rental1);
    rental1 = new CarSeat(rental1);
    rental1 = new CarSeat(rental1);
    rental1 = new CarSeat(rental1);
    Rental rental2 = simulator.getStore().rentCar(rentalRecord);
    rental2 = new Radio(rental1);
    int initialTotal = rentalRecord.getTotal();
    cust.rentCars(rentalRecord);
		System.out.println(rentalRecord);
    cust.returnCars(rentalRecord);
		System.out.println(rentalRecord);
    int afterReturnTotal = rentalRecord.getTotal();
		System.out.println("Verifying total...");
    assertEquals("Total is incorrect.", initialTotal, afterReturnTotal);
		System.out.println("Success.");
    passed();
	}

  /**
   * Called after each test has been run
   */
  @After
  public void tearDown() {
     if(testPassed) {
        printSuccess();
     }else{
       printTestFailure();
     }
  }

  private void before(){
    testPassed = false;
  }

  private void passed(){
    testPassed = true;
  }

	private void printSuccess() {
		System.out.println("********** TEST PASSED **********");
	}

	private void printTestFailure(){
		System.out.println("!!!!!!!!!! TEST FAILED !!!!!!!!!!");
	}
}
