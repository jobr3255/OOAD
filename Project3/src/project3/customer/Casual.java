package project3.customer;

import java.security.SecureRandom;

/**
 *
 */
public class Casual extends Customer {

  public Casual(String name){
    super(name);
  }

  // Rent 1 car
  public int chooseNumRentals(){
  		return 1;
  }

  // Rent for 1 - 3 nights
  public int chooseNumNights(){
  		return (new SecureRandom()).nextInt(2) + 1;
  }
}
