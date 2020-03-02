package project3.customer;

/**
 *  Implements the business customer choises
 */
public class Business extends Customer {

  public Business(String name){
    super(name);
  }

  // Rent 3 cars
  public int chooseNumRentals(){
  		return 3;
  }

  // Rent for 7 nights
  public int chooseNumNights(){
  		return 7;
  }
}
