import { Zookeeper, ZookeeperActionState } from "./Zookeeper";
import Observer from "./Observer"

export class ZooAnnouncer implements Observer {
  zookeeper: Zookeeper;
  /**
   *  Default constructor
   */
  constructor(zookeeper: Zookeeper) {
    this.zookeeper = zookeeper;
    this.zookeeper.setObserver(this);
  }

  private announce(message){
    console.log("###################################");
    console.log("Hi, this is the Zoo Announcer. " + message);
    console.log("###################################");
  }

  update() {
    var newZookeeperActionState = this.zookeeper.getZookeeperActionState();
    switch (newZookeeperActionState) {
      case ZookeeperActionState.WakingAnimals: {
        this.announce("The Zookeeper is about to wake the animals!");
        break;
      }
      case ZookeeperActionState.TakingRoll: {
        this.announce("The Zookeeper is about to take rollcall!");
        break;
      }
      case ZookeeperActionState.FeedingAnimals: {
        this.announce("The Zookeeper is about to feed the animals!");
        break;
      }
      case ZookeeperActionState.ExersizingAnimals: {
        this.announce("The Zookeeper is about to exercise the animals!");
        break;
      }
      case ZookeeperActionState.ClosingZoo: {
        this.announce("The Zookeeper is about to put the animals to bed and close the zoo!");
        break;
      }
    }
  }

}
