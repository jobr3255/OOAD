import { Noise } from "./";

export default abstract class Animal {
  private name: String;
  private noise: Noise;

  /**
   *  @param name String
   *  Name of the animal
   *  @param noise Noise
   *  The Noise object that the animal will make
   */
  public constructor(name: String, noise: Noise){
    this.name = name;
    this.noise = noise;
  }

  /**
   *  Abstract methods
   */
  public abstract eat();

  public makeNoise(){
    if(this.noise != null)
      console.log(this.toString() + " " + this.noise.getNoise());
    else // If noise is null, do default behavior
      console.log(this.toString() + " is silent");
  }

  /**
   *  Prints that the animal in now roaming
   */
  public wakeUp(){
    console.log(this.toString() + " is now awake");
  }

  /**
   *  Prints that the animal in now roaming
   */
  public roam(){
    console.log(this.toString() + " is now roaming");
  }

  /**
   *  Prints that the animal in now asleep
   */
  public sleep(){
    console.log(this.toString() + " went to sleep");
  }

  /**
   *  @return String
   *  Name of the animal
   */
  public getName(){
    return this.name;
  }

  /**
   *  @return String
   *  Returns string of the type of species
   */
  public getSpecies(){
    var funcNameRegex = /function (.{1,})\(/;
    var results = (funcNameRegex).exec((<any> this).constructor.toString());
    return (results && results.length > 1) ? results[1] : "";
  }

  /**
   *  @return String
   *  Name and species of animal
   */
  public toString(){
    return this.name + " the " + this.getSpecies();
  }
}
