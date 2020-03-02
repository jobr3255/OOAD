package project3.store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.security.SecureRandom;

import project3.rental.car.*;
import project3.rental.option.Option;

/**
 *  Keeps track of inventory and a ledger of all rental transactions
 */
public class CarRentalStore {

  private List<Car> inventory;
  private List<RentalRecord> ledger;
  private CarFactory carFactory;

  public CarRentalStore(CarFactory carFactory){
    this.carFactory = carFactory;
    this.inventory = new ArrayList<Car>();
    this.ledger = new ArrayList<RentalRecord>();
  }


  /**
   *  @return
   *  The stores inventory
   */
  public List<Car> getInventory(){
    return this.inventory;
  }

  public void setInventory(List<Car> inventory){
    this.inventory = inventory;
  }

	/**
	 *  Add multiple cars of a specific category to the stores inventory
	 */
  public void addNewCars(CarFactory.Category category, int num){
    for(int i=0; i<num; i++){
      this.inventory.add(this.carFactory.createCar(category));
    }
  }

	/**
	 *  Add cars to the stores inventory
	 */
  public void addCars(List<Car> cars){
    this.inventory.addAll(cars);
  }

	/**
	 *  Removes a random car in the inventory, adds it to the rental record, and returns the car
	 */
  public Car rentCar(RentalRecord rr){
    int carIndex = (new SecureRandom()).nextInt(this.inventory.size());
    Car rentalCar = this.inventory.get(carIndex);
    this.inventory.remove(carIndex);
    // If ledger already contains this rental record, update it
    if(this.ledger.contains(rr)){
      for(RentalRecord update : this.ledger){
        if(update == rr){
          update.addCar(rentalCar);
        }
      }
    }else{
      rr.addCar(rentalCar);
      this.ledger.add(rr);
    }
    return rentalCar;
  }

  /**
   *  @return
   *    List of all RentalRecords
   */
  public List<RentalRecord> getLedger(){
    return this.ledger;
  }

  /**
   *  @return
   *    List of all active RentalRecords
   */
  public List<RentalRecord> getActiveRentals(){
    return filterRecords(RentalRecord.RentalStatus.ACTIVE);
  }

  /**
   *  @return
   *    List of all completed RentalRecords
   */
  public List<RentalRecord> getCompletedRentals(){
    return filterRecords(RentalRecord.RentalStatus.COMPLETE);
  }

  /**
   *  @param RentalRecord.RentalStatus
   *    Status to filter
   *  @return
   *    Filters the ledger based on rental status
   */
  private List<RentalRecord> filterRecords(RentalRecord.RentalStatus status){
    List<RentalRecord> rentals = new ArrayList<RentalRecord>();
    for(RentalRecord rr : this.ledger){
      if(rr.getStatus() == status){
        rentals.add(rr);
      }
    }
    return rentals;
  }
}
