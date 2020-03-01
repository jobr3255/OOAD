import { Animal, Bark, Howl, Meow, Roar, Growl, Trumpet, Grunt } from "./animals";
import { Cat, Lion, Tiger } from "./animals/feline";
import { Dog, Wolf } from "./animals/canine";
import { Elephant, Hippo, Rhino } from "./animals/pachyderm";

/**
 *  Holds a list of animals in the zoo that can be added to
 */
export class Zoo {

  private animals: Array<Animal> = null;

  constructor(){
    this.animals = new Array();
  }

  /**
   *  Initially populates the zoo with default animals
   */
  public setDefaultAnimals(){
    // Add felines to zoo
		this.addAnimal(new Cat("Chloe", new Meow()));
		this.addAnimal(new Cat("Charles", new Meow()));
		this.addAnimal(new Lion("Liam", new Roar()));
		this.addAnimal(new Lion("Leon", new Roar()));
		this.addAnimal(new Tiger("Tim", new Growl()));
		this.addAnimal(new Tiger("Trent", new Growl()));
		// Add canines to zoo
		this.addAnimal(new Dog("Dexter", new Bark()));
		this.addAnimal(new Dog("David", new Bark()));
		this.addAnimal(new Wolf("Walter", new Howl()));
		this.addAnimal(new Wolf("Wade", new Howl()));
		// Add paychyderms
		this.addAnimal(new Elephant("Ellie", new Trumpet()));
		this.addAnimal(new Elephant("Egon", new Trumpet()));
		this.addAnimal(new Hippo("Harry", new Grunt()));
		this.addAnimal(new Hippo("Henrietta", new Grunt()));
		this.addAnimal(new Rhino("Ronda", new Grunt()));
		this.addAnimal(new Rhino("Ryan", new Grunt()));
  }

  /**
   *  @param newAnimal Animal
   *  New animal object to add to the zoo
   */
  public addAnimal(newAnimal: Animal){
    this.animals.push(newAnimal);
  }

  /**
   *  @return List<Animal>
   *  Returns list of Animal objects in the zoo
   */
  public getAnimals(): Array<Animal>{
    return this.animals;
  }

  /**
   *  @return String
   *  List of name and species of each animal in the zoo
   */
  public toString(): String {
    var formattedZoo = "";
    for(var i = 0; i < this.animals.length; i++){
      formattedZoo += this.animals[i].toString();
      // Only add new line if not the last element in ArrayList
      if(i != this.animals.length-1){
        formattedZoo += "\n";
      }
    }
    return formattedZoo;
  }
}
