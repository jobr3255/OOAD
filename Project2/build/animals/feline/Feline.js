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
var __1 = require("../");
var Feline = /** @class */ (function (_super) {
    __extends(Feline, _super);
    function Feline() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    /**
     *  Felines eat tuna
     */
    Feline.prototype.eat = function () {
        console.log(this.toString() + " is now eating tuna");
    };
    return Feline;
}(__1.Animal));
exports.Feline = Feline;
