import { Zoo } from "./Zoo";
import { Zookeeper } from "./Zookeeper";
import { ZooAnnouncer } from "./ZooAnnouncer";

class Main {
  constructor() {
  }

  start(){
    var zoo = new Zoo();
		zoo.setDefaultAnimals();

		var zookeeper: Zookeeper = new Zookeeper(zoo);
    var zooAnnouncer: ZooAnnouncer = new ZooAnnouncer(zookeeper);
		zookeeper.wakeAnimals();
		zookeeper.rollCall();
		zookeeper.feedAnimals();
		zookeeper.exerciseAnimals();
		zookeeper.closeZoo();
  }
}

var main = new Main();
main.start();
