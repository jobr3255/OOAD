package project3.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public abstract class Subject {
  private List<Observer> observers;

  public Subject(){
    this.observers = new ArrayList<Observer>();
  }

  /**
   *  Adds an observer
   *  @param Observer ob
   *  Observer object to add to the list
   */
  public void addObserver(Observer ob){
    this.observers.add(ob);
  }

  /**
   *  Removes an observer
   *  @param Observer toRemove
   *  Observer object to remove from the list
   */
  public void removeObserver(Observer toRemove){
    int i = 0;
    for (Observer ob : this.observers) {
			if(ob == toRemove){
        this.observers.remove(i);
        return;
      }
      i++;
		}
  }

  /**
   *  Notify all the observers
   */
  public void notifyObservers(int data){
    for (Observer ob : this.observers) {
			ob.update(data);
		}
  }
}
