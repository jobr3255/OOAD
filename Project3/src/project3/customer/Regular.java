package project3.customer;

import java.security.SecureRandom;

/**
 *
 */
public class Regular extends Customer {

  public Regular(String name){
    super(name);
  }

  // Rent 1 - 3 cars
  public int chooseNumRentals(){
  		return (new SecureRandom()).nextInt(2) + 1;
  }

  // Rent for 3 - nights
  public int chooseNumNights(){
  		return (new SecureRandom()).nextInt(2) + 3;
  }
}
