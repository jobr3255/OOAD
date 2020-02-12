import { Animal } from "../";

export abstract class Pachyderm extends Animal{

  /**
   *  Pachyderms graze on grass
   */
  public eat(){
    console.log(this.toString() + " is grazing on grass");
  }
}
