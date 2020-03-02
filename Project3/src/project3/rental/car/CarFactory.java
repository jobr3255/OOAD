package project3.rental.car;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  Implements the Factory Pattern for the CarRentalStore
 */
public class CarFactory {

  public static enum Category { LUXURY, ECONOMY, MINIVAN, SUV, STANDARD }

  private List<String> licensePlates;

  public CarFactory(){
    this.licensePlates = new ArrayList<String>();
  }

	/**
	 *  @param Category category
	 *     Category new car should be
	 *  @return
	 *     Returns new Car with a unique license plate given a category
	 */
  public Car createCar(Category category){
    String licensePlate = createNewLicensePlate();
    switch (category) {
  		case LUXURY:  return new Luxury(licensePlate);
  		case ECONOMY:  return new Economy(licensePlate);
  		case STANDARD:  return new Standard(licensePlate);
  		case MINIVAN:  return new Minivan(licensePlate);
  		case SUV:  return new SUV(licensePlate);
		}
    return null;
  }

  /**
   *  @param String plate
   *     License plate to check for uniquness
   *  @return
   *     True if plate is unique, false otherwise
   */
  public boolean isUniquePlate(String licensePlate){
    for (String license : this.licensePlates) {
			if(licensePlate.equals(license)){
        return false;
      }
		}
    return true;
  }

  /**
   *  Adds a license plate to the list of license plates
   *
   *  @param String licensePlate
   *     License plate string to add to list
   */
  public void addLicensePlate(String licensePlate){
    this.licensePlates.add(licensePlate);
  }

  /**
   *  Creates a new unique license plate
   *
   *  @return
   *     License plate string
   */
  private String createNewLicensePlate(){
    String licensePlate = "";
    for(int i = 0; i < 3; i++){
      licensePlate += (char) ((new SecureRandom()).nextInt(26) + 'a');
    }
    licensePlate = licensePlate.toUpperCase();
    for(int i = 0; i < 3; i++){
      licensePlate += (new SecureRandom()).nextInt(9);
    }
    if(!isUniquePlate(licensePlate)){
      return createNewLicensePlate();
    }
    return licensePlate;
  }
}
