"use strict";
/**
 *  This file holds the Noise classes and use the strategy patter
 */
exports.__esModule = true;
/**
 *  These are all the specific opperations for each animal
 */
// Dogs
var Bark = /** @class */ (function () {
    function Bark() {
    }
    Bark.prototype.getNoise = function () {
        return "barked";
    };
    return Bark;
}());
exports.Bark = Bark;
// Wolfs
var Howl = /** @class */ (function () {
    function Howl() {
    }
    Howl.prototype.getNoise = function () {
        return "howled";
    };
    return Howl;
}());
exports.Howl = Howl;
// Cats
var Meow = /** @class */ (function () {
    function Meow() {
    }
    Meow.prototype.getNoise = function () {
        return "meowed";
    };
    return Meow;
}());
exports.Meow = Meow;
// Lions
var Roar = /** @class */ (function () {
    function Roar() {
    }
    Roar.prototype.getNoise = function () {
        return "roared";
    };
    return Roar;
}());
exports.Roar = Roar;
// Tigers
var Growl = /** @class */ (function () {
    function Growl() {
    }
    Growl.prototype.getNoise = function () {
        return "growled";
    };
    return Growl;
}());
exports.Growl = Growl;
// Elephants
var Trumpet = /** @class */ (function () {
    function Trumpet() {
    }
    Trumpet.prototype.getNoise = function () {
        return "trumpeted";
    };
    return Trumpet;
}());
exports.Trumpet = Trumpet;
// Hippos and rhinos
var Grunt = /** @class */ (function () {
    function Grunt() {
    }
    Grunt.prototype.getNoise = function () {
        return "grunted";
    };
    return Grunt;
}());
exports.Grunt = Grunt;
