"use strict";
exports.__esModule = true;
var Zoo_1 = require("./Zoo");
var Zookeeper_1 = require("./Zookeeper");
var Main = /** @class */ (function () {
    function Main() {
    }
    Main.prototype.start = function () {
        var zoo = new Zoo_1.Zoo();
        zoo.setDefaultAnimals();
        var zookeeper = new Zookeeper_1.Zookeeper();
        // zookeeper.wakeAnimals(zoo);
        zookeeper.rollCall(zoo);
        // zookeeper.feedAnimals(zoo);
        // zookeeper.exerciseAnimals(zoo);
        // zookeeper.closeZoo(zoo);
    };
    return Main;
}());
var main = new Main();
main.start();
