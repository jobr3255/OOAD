import { Zoo } from "./Zoo";
import { Zookeeper } from "./Zookeeper";

class Main {
  constructor() {
  }

  start(){
    var zoo = new Zoo();
		zoo.setDefaultAnimals();

		var zookeeper:Zookeeper = new Zookeeper();
		zookeeper.wakeAnimals(zoo);
		zookeeper.rollCall(zoo);
		zookeeper.feedAnimals(zoo);
		zookeeper.exerciseAnimals(zoo);
		zookeeper.closeZoo(zoo);
  }
}

var main = new Main();
main.start();
