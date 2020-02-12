"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
var Feline_1 = require("./Feline");
// Better at random number generating than java.util.Random
// import java.security.SecureRandom;
var Cat = /** @class */ (function (_super) {
    __extends(Cat, _super);
    function Cat() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    /**
     *  Disobey order and do something random
     */
    Cat.prototype.sleep = function () {
        this.doRandomAction();
    };
    /**
     *  Make the cat do a random action
     */
    Cat.prototype.doRandomAction = function () {
        // create random number between 0 and 5
        var choice = Math.floor(Math.random() * 6);
        var action = "";
        switch (choice) {
            // Sleep
            case 0:
                _super.prototype.sleep.call(this);
                return;
            case 1:
                action = "hissed";
                break;
            case 2:
                action = "ran around in cicles";
                break;
            case 3:
                action = "climbed a tree";
                break;
            case 4:
                action = "is now grooming themselves";
                break;
            case 5:
                action = "is now scratching a tree";
                break;
        }
        console.log(this.toString() + " " + action);
    };
    return Cat;
}(Feline_1.Feline));
exports["default"] = Cat;
