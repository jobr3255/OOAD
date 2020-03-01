"use strict";
exports.__esModule = true;
var Zoo_1 = require("./Zoo");
var Zookeeper_1 = require("./Zookeeper");
var ZooAnnouncer_1 = require("./ZooAnnouncer");
var Main = /** @class */ (function () {
    function Main() {
    }
    Main.prototype.start = function () {
        var zoo = new Zoo_1.Zoo();
        zoo.setDefaultAnimals();
        var zookeeper = new Zookeeper_1.Zookeeper(zoo);
        var zooAnnouncer = new ZooAnnouncer_1.ZooAnnouncer(zookeeper);
        zookeeper.wakeAnimals();
        zookeeper.rollCall();
        zookeeper.feedAnimals();
        zookeeper.exerciseAnimals();
        zookeeper.closeZoo();
    };
    return Main;
}());
var main = new Main();
main.start();
