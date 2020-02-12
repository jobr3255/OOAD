import { Animal } from "../";

export abstract class Feline extends Animal {
  /**
   *  Felines eat tuna
   */
  public eat(){
    console.log(this.toString() + " is now eating tuna");
  }
}
