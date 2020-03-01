import { Animal } from "./animals";
import { Zoo } from "./Zoo";
import Subject from "./Subject"
import Observer from "./Observer"

export enum ZookeeperActionState {
  WakingAnimals,
  TakingRoll,
  FeedingAnimals,
  ExersizingAnimals,
  ClosingZoo
}

export class Zookeeper implements Subject {

  // Define observer variables
  private state: ZookeeperActionState;

  getZookeeperActionState(): ZookeeperActionState {
    return this.state;
  }
  setZookeeperActionState(newZookeeperActionState: ZookeeperActionState) {
    this.state = newZookeeperActionState;
    this.notifyObserver();
  }
  observer: Observer = null;
  notifyObserver() {
    if(this.observer != null)
      this.observer.update();
  }
  setObserver(newObserver: Observer) {
    this.observer = newObserver;
  }
  removeObserver() {
    this.observer = null;
  };

  private zoo: Zoo;


  /**
   *  Default constructor
   */
  constructor(zoo: Zoo) {
    this.zoo = zoo;
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and wakes each one
   */
  public wakeAnimals() {
    this.setZookeeperActionState(ZookeeperActionState.WakingAnimals);
    this.displayAction("Zookeeper is waking the animals...");
    var animals = this.zoo.getAnimals();
    animals.forEach(function(animal) {
      animal.wakeUp();
    });
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and calls roll for each one
   */
  public rollCall() {
    this.setZookeeperActionState(ZookeeperActionState.TakingRoll);
    this.displayAction("Zookeeper is calling roll...");
    var animals: Array<Animal> = this.zoo.getAnimals();
    animals.forEach(function(animal) {
      animal.makeNoise();
    });
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and feeds each one
   */
  public feedAnimals() {
    this.setZookeeperActionState(ZookeeperActionState.FeedingAnimals);
    this.displayAction("Zookeeper is feeding the animals...");
    var animals: Array<Animal> = this.zoo.getAnimals();
    animals.forEach(function(animal) {
      animal.eat();
    });
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and exercises each one
   */
  public exerciseAnimals() {
    this.setZookeeperActionState(ZookeeperActionState.ExersizingAnimals);
    this.displayAction("Zookeeper is exercising the animals...");
    var animals: Array<Animal> = this.zoo.getAnimals();
    animals.forEach(function(animal) {
      animal.roam();
    });
  }

  /**
   *  @param zoo Zoo
   *  Iterate through zoo animals and puts each one to bed
   */
  public closeZoo() {
    this.setZookeeperActionState(ZookeeperActionState.ClosingZoo);
    this.displayAction("Zookeeper is closing the zoo and puting the animals to bed...");
    var animals: Array<Animal> = this.zoo.getAnimals();
    animals.forEach(function(animal) {
      animal.sleep();
    });
    this.removeObserver();
  }

  /**
   *  @param action String
   *  Helper function to show start of new action
   */
  private displayAction(action: String) {
    console.log("* * * * * *");
    console.log(action);
    console.log("* * * * * *");
  }

}
