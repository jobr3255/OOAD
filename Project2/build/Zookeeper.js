"use strict";
exports.__esModule = true;
var ZookeeperActionState;
(function (ZookeeperActionState) {
    ZookeeperActionState[ZookeeperActionState["WakingAnimals"] = 0] = "WakingAnimals";
    ZookeeperActionState[ZookeeperActionState["TakingRoll"] = 1] = "TakingRoll";
    ZookeeperActionState[ZookeeperActionState["FeedingAnimals"] = 2] = "FeedingAnimals";
    ZookeeperActionState[ZookeeperActionState["ExersizingAnimals"] = 3] = "ExersizingAnimals";
    ZookeeperActionState[ZookeeperActionState["ClosingZoo"] = 4] = "ClosingZoo";
})(ZookeeperActionState = exports.ZookeeperActionState || (exports.ZookeeperActionState = {}));
var Zookeeper = /** @class */ (function () {
    /**
     *  Default constructor
     */
    function Zookeeper(zoo) {
        this.observer = null;
        this.zoo = zoo;
    }
    Zookeeper.prototype.getZookeeperActionState = function () {
        return this.state;
    };
    Zookeeper.prototype.setZookeeperActionState = function (newZookeeperActionState) {
        this.state = newZookeeperActionState;
        this.notifyObserver();
    };
    Zookeeper.prototype.notifyObserver = function () {
        if (this.observer != null)
            this.observer.update();
    };
    Zookeeper.prototype.setObserver = function (newObserver) {
        this.observer = newObserver;
    };
    Zookeeper.prototype.removeObserver = function () {
        this.observer = null;
    };
    ;
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and wakes each one
     */
    Zookeeper.prototype.wakeAnimals = function () {
        this.setZookeeperActionState(ZookeeperActionState.WakingAnimals);
        this.displayAction("Zookeeper is waking the animals...");
        var animals = this.zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.wakeUp();
        });
    };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and calls roll for each one
     */
    Zookeeper.prototype.rollCall = function () {
        this.setZookeeperActionState(ZookeeperActionState.TakingRoll);
        this.displayAction("Zookeeper is calling roll...");
        var animals = this.zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.makeNoise();
        });
    };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and feeds each one
     */
    Zookeeper.prototype.feedAnimals = function () {
        this.setZookeeperActionState(ZookeeperActionState.FeedingAnimals);
        this.displayAction("Zookeeper is feeding the animals...");
        var animals = this.zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.eat();
        });
    };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and exercises each one
     */
    Zookeeper.prototype.exerciseAnimals = function () {
        this.setZookeeperActionState(ZookeeperActionState.ExersizingAnimals);
        this.displayAction("Zookeeper is exercising the animals...");
        var animals = this.zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.roam();
        });
    };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and puts each one to bed
     */
    Zookeeper.prototype.closeZoo = function () {
        this.setZookeeperActionState(ZookeeperActionState.ClosingZoo);
        this.displayAction("Zookeeper is closing the zoo and puting the animals to bed...");
        var animals = this.zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.sleep();
        });
        this.removeObserver();
    };
    /**
     *  @param action String
     *  Helper function to show start of new action
     */
    Zookeeper.prototype.displayAction = function (action) {
        console.log("* * * * * *");
        console.log(action);
        console.log("* * * * * *");
    };
    return Zookeeper;
}());
exports.Zookeeper = Zookeeper;
