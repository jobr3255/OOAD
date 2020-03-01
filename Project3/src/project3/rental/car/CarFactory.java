package project3.rental.car;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class CarFactory {

  public static enum Category { LUXURY, ECONOMY, MINIVAN, SUV, STANDARD }

  private List<String> licensePlates;

  public CarFactory(){
    this.licensePlates = new ArrayList<String>();
  }

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

  public boolean isUniquePlate(String plate){
    for (String license : this.licensePlates) {
			if(plate.equals(license)){
        return false;
      }
		}
    return true;
  }

  public void addLicensePlate(String licensePlate){
    this.licensePlates.add(licensePlate);
  }

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
