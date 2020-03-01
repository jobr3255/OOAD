"use strict";
exports.__esModule = true;
var Zookeeper_1 = require("./Zookeeper");
var ZooAnnouncer = /** @class */ (function () {
    /**
     *  Default constructor
     */
    function ZooAnnouncer(zookeeper) {
        this.zookeeper = zookeeper;
        this.zookeeper.setObserver(this);
    }
    ZooAnnouncer.prototype.announce = function (message) {
        console.log("###################################");
        console.log("Hi, this is the Zoo Announcer. " + message);
        console.log("###################################");
    };
    ZooAnnouncer.prototype.update = function () {
        var newZookeeperActionState = this.zookeeper.getZookeeperActionState();
        switch (newZookeeperActionState) {
            case Zookeeper_1.ZookeeperActionState.WakingAnimals: {
                this.announce("The Zookeeper is about to wake the animals!");
                break;
            }
            case Zookeeper_1.ZookeeperActionState.TakingRoll: {
                this.announce("The Zookeeper is about to take rollcall!");
                break;
            }
            case Zookeeper_1.ZookeeperActionState.FeedingAnimals: {
                this.announce("The Zookeeper is about to feed the animals!");
                break;
            }
            case Zookeeper_1.ZookeeperActionState.ExersizingAnimals: {
                this.announce("The Zookeeper is about to exercise the animals!");
                break;
            }
            case Zookeeper_1.ZookeeperActionState.ClosingZoo: {
                this.announce("The Zookeeper is about to put the animals to bed and close the zoo!");
                break;
            }
        }
    };
    return ZooAnnouncer;
}());
exports.ZooAnnouncer = ZooAnnouncer;
