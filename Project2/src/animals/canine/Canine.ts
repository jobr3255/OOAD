import { Animal } from "../";

export abstract class Canine extends Animal {

  /**
   *  Canines eat kibble
   */
  public eat(){
    console.log(this.toString() + " is eating kibble");
  }
}
