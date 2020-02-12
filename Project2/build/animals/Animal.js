"use strict";
exports.__esModule = true;
var Animal = /** @class */ (function () {
    /**
     *  @param name String
     *  Name of the animal
     */
    function Animal(name, noise) {
        this.name = name;
        this.noise = noise;
    }
    Animal.prototype.makeNoise = function () {
        if (this.noise != null)
            console.log(this.toString() + " " + this.noise.getNoise());
    };
    /**
     *  Prints that the animal in now roaming
     */
    Animal.prototype.wakeUp = function () {
        console.log(this.toString() + " is now awake");
    };
    /**
     *  Prints that the animal in now roaming
     */
    Animal.prototype.roam = function () {
        console.log(this.toString() + " is now roaming");
    };
    /**
     *  Prints that the animal in now asleep
     */
    Animal.prototype.sleep = function () {
        console.log(this.toString() + " went to sleep");
    };
    /**
     *  @return String
     *  Name of the animal
     */
    Animal.prototype.getName = function () {
        return this.name;
    };
    /**
     *  @return String
     *  Returns string of the type of species
     */
    Animal.prototype.getSpecies = function () {
        var funcNameRegex = /function (.{1,})\(/;
        var results = (funcNameRegex).exec(this.constructor.toString());
        return (results && results.length > 1) ? results[1] : "";
    };
    /**
     *  @return String
     *  Name and species of animal
     */
    Animal.prototype.toString = function () {
        return this.name + " the " + this.getSpecies();
    };
    return Animal;
}());
exports["default"] = Animal;
