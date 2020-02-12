"use strict";
exports.__esModule = true;
var animals_1 = require("./animals");
var feline_1 = require("./animals/feline");
var canine_1 = require("./animals/canine");
var pachyderm_1 = require("./animals/pachyderm");
/**
 *  Holds a list of animals in the zoo that can be added to
 */
var Zoo = /** @class */ (function () {
    function Zoo() {
        this.animals = null;
        this.animals = new Array();
    }
    /**
     *  Initially populates the zoo with default animals
     */
    Zoo.prototype.setDefaultAnimals = function () {
        // Add felines to zoo
        this.addAnimal(new feline_1.Cat("Chloe", new animals_1.Meow()));
        this.addAnimal(new feline_1.Cat("Charles", new animals_1.Meow()));
        this.addAnimal(new feline_1.Lion("Liam", new animals_1.Roar()));
        this.addAnimal(new feline_1.Lion("Leon", new animals_1.Roar()));
        this.addAnimal(new feline_1.Tiger("Tim", new animals_1.Growl()));
        this.addAnimal(new feline_1.Tiger("Trent", new animals_1.Growl()));
        // Add canines to zoo
        this.addAnimal(new canine_1.Dog("Dexter", new animals_1.Bark()));
        this.addAnimal(new canine_1.Dog("David", new animals_1.Bark()));
        this.addAnimal(new canine_1.Wolf("Walter", new animals_1.Howel()));
        this.addAnimal(new canine_1.Wolf("Wade", new animals_1.Howel()));
        // Add paychyderms
        this.addAnimal(new pachyderm_1.Elephant("Ellie", new animals_1.Trumpet()));
        this.addAnimal(new pachyderm_1.Elephant("Egon", new animals_1.Trumpet()));
        this.addAnimal(new pachyderm_1.Hippo("Harry", new animals_1.Grunt()));
        this.addAnimal(new pachyderm_1.Hippo("Henrietta", new animals_1.Grunt()));
        this.addAnimal(new pachyderm_1.Rhino("Ronda", new animals_1.Grunt()));
        this.addAnimal(new pachyderm_1.Rhino("Ryan", new animals_1.Grunt()));
    };
    /**
     *  @param newAnimal Animal
     *  New animal object to add to the zoo
     */
    Zoo.prototype.addAnimal = function (newAnimal) {
        this.animals.push(newAnimal);
    };
    /**
     *  @return List<Animal>
     *  Returns list of Animal objects in the zoo
     */
    Zoo.prototype.getAnimals = function () {
        return this.animals;
    };
    /**
     *  @return String
     *  List of name and species of each animal in the zoo
     */
    Zoo.prototype.toString = function () {
        var formattedZoo = "";
        for (var i = 0; i < this.animals.length; i++) {
            formattedZoo += this.animals[i].toString();
            // Only add new line if not the last element in ArrayList
            if (i != this.animals.length - 1) {
                formattedZoo += "\n";
            }
        }
        return formattedZoo;
    };
    return Zoo;
}());
exports.Zoo = Zoo;
