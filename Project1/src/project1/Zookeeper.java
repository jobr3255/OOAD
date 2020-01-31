package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import project1.animals.Animal;

public class Zookeeper {
  /**
   *  Default constructor
   */
  public Zookeeper(){}

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and wakes each one
   */
  public void wakeAnimals(Zoo zoo){
    displayAction("Zookeeper is waking the animals...");
    List<Animal> animals = zoo.getAnimals();
    for (Animal a : animals) {
			a.wakeUp();
		}
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and calls roll for each one
   */
  public void rollCall(Zoo zoo){
    displayAction("Zookeeper is calling roll...");
    List<Animal> animals = zoo.getAnimals();
    for (Animal a : animals) {
			a.makeNoise();
		}
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and feeds each one
   */
  public void feedAnimals(Zoo zoo){
    displayAction("Zookeeper is feeding the animals...");
    List<Animal> animals = zoo.getAnimals();
    for (Animal a : animals) {
			a.eat();
		}
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and exercises each one
   */
  public void exerciseAnimals(Zoo zoo){
    displayAction("Zookeeper is exercising the animals...");
    List<Animal> animals = zoo.getAnimals();
    for (Animal a : animals) {
			a.roam();
		}
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and puts each one to bed
   */
  public void closeZoo(Zoo zoo){
    displayAction("Zookeeper is closing the zoo and puting the animals to bed...");
    List<Animal> animals = zoo.getAnimals();
    for (Animal a : animals) {
			a.sleep();
		}
  }

  /**
   *  @param action String
   *  Helper function to show start of new action
   */
  private void displayAction(String action){
    System.out.println("* * * * * *");
    System.out.println(action);
    System.out.println("* * * * * *");
  }

}
