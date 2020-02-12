"use strict";
exports.__esModule = true;
var Zookeeper = /** @class */ (function () {
    function Zookeeper() {
    }
    /**
     *  Default constructor
     */
    Zookeeper.prototype.Zookeeper = function () { };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and wakes each one
     */
    Zookeeper.prototype.wakeAnimals = function (zoo) {
        this.displayAction("Zookeeper is waking the animals...");
        var animals = zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.wakeUp();
        });
    };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and calls roll for each one
     */
    Zookeeper.prototype.rollCall = function (zoo) {
        this.displayAction("Zookeeper is calling roll...");
        var animals = zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.makeNoise();
        });
    };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and feeds each one
     */
    Zookeeper.prototype.feedAnimals = function (zoo) {
        this.displayAction("Zookeeper is feeding the animals...");
        var animals = zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.eat();
        });
    };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and exercises each one
     */
    Zookeeper.prototype.exerciseAnimals = function (zoo) {
        this.displayAction("Zookeeper is exercising the animals...");
        var animals = zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.roam();
        });
    };
    /**
     *  @param zoo Zoo
     *  Iterate through zoo animals and puts each one to bed
     */
    Zookeeper.prototype.closeZoo = function (zoo) {
        this.displayAction("Zookeeper is closing the zoo and puting the animals to bed...");
        var animals = zoo.getAnimals();
        animals.forEach(function (animal) {
            animal.sleep();
        });
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
