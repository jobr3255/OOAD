import { Animal } from "./animals";
import { Zoo } from "./Zoo";

export class Zookeeper {
  /**
   *  Default constructor
   */
  public Zookeeper(){}

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and wakes each one
   */
  public wakeAnimals(zoo: Zoo){
    this.displayAction("Zookeeper is waking the animals...");
    var animals = zoo.getAnimals();
    animals.forEach(function(animal){
      animal.wakeUp();
    });
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and calls roll for each one
   */
  public rollCall(zoo: Zoo){
    this.displayAction("Zookeeper is calling roll...");
    var animals: Array<Animal> = zoo.getAnimals();
    animals.forEach(function(animal){
      animal.makeNoise();
    });
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and feeds each one
   */
  public feedAnimals(zoo: Zoo){
    this.displayAction("Zookeeper is feeding the animals...");
    var animals: Array<Animal> = zoo.getAnimals();
    animals.forEach(function(animal){
      animal.eat();
    });
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and exercises each one
   */
  public exerciseAnimals(zoo: Zoo){
    this.displayAction("Zookeeper is exercising the animals...");
    var animals: Array<Animal> = zoo.getAnimals();
    animals.forEach(function(animal){
      animal.roam();
    });
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and puts each one to bed
   */
  public closeZoo(zoo: Zoo){
    this.displayAction("Zookeeper is closing the zoo and puting the animals to bed...");
    var animals: Array<Animal> = zoo.getAnimals();
    animals.forEach(function(animal){
      animal.sleep();
    });
  }

  /**
   *  @param action String
   *  Helper function to show start of new action
   */
  private displayAction(action){
    console.log("* * * * * *");
    console.log(action);
    console.log("* * * * * *");
  }

}
