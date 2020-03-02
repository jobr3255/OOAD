package project3;

import project3.observer.Subject;

/**
 *	Implements the Subject part of the Observer Pattern
 */
public class Day extends Subject {

	private int currentDay;

	public Day() {
		super();
		this.currentDay = 1;
	}

  /**
   *  Increments current day by 1 and notifies observers that the day has changed
   */
	public void nextDay(){
		this.currentDay++;
		this.notifyObservers(this.currentDay);
	}

  /**
   *  @return
   *  The current day
   */
	public int today(){
		return this.currentDay;
	}
}
