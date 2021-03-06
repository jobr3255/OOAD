package project3.rental;

import project3.observer.Observer;
import project3.observer.Subject;

/**
 *  Abstract class representing a rental
 */
public abstract class Rental {
  // Defines a price variable that must be implemented in subclasses
  abstract public int rentalPrice();
  // Defines a decription variable that must be implemented in subclasses
  abstract public String description();

  protected int nightsRented;
  // Only need a setter
  public void setNightsRented(int nights){
    this.nightsRented = nights;
  }
}
