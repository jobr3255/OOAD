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
var Pachyderm_1 = require("./Pachyderm");
var Hippo = /** @class */ (function (_super) {
    __extends(Hippo, _super);
    function Hippo() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return Hippo;
}(Pachyderm_1.Pachyderm));
exports["default"] = Hippo;
