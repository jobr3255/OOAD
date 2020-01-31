package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import project1.animals.Animal;
import project1.animals.feline.*;
import project1.animals.canine.*;
import project1.animals.pachyderm.*;

/**
 *  Holds a list of animals in the zoo that can be added to
 */
public class Zoo {

  private List<Animal> animals;

  public Zoo(){
    this.animals = new ArrayList<Animal>();
  }

  /**
   *  Initially populates the zoo with default animals
   */
  public void setDefaultAnimals(){
    // Add felines to zoo
		this.addAnimal(new Cat("Chloe"));
		this.addAnimal(new Cat("Charles"));
		this.addAnimal(new Lion("Liam"));
		this.addAnimal(new Lion("Leon"));
		this.addAnimal(new Tiger("Tim"));
		this.addAnimal(new Tiger("Trent"));
		// Add canines to zoo
		this.addAnimal(new Dog("Dexter"));
		this.addAnimal(new Dog("David"));
		this.addAnimal(new Wolf("Walter"));
		this.addAnimal(new Wolf("Wade"));
		// Add paychyderms
		this.addAnimal(new Elephant("Ellie"));
		this.addAnimal(new Elephant("Egon"));
		this.addAnimal(new Hippo("Harry"));
		this.addAnimal(new Hippo("Henrietta"));
		this.addAnimal(new Rhino("Ronda"));
		this.addAnimal(new Rhino("Ryan"));
  }

  /**
   *  @param newAnimal Animal
   *  New animal object to add to the zoo
   */
  public void addAnimal(Animal newAnimal){
    this.animals.add(newAnimal);
  }

  /**
   *  @return List<Animal>
   *  Returns list of Animal objects in the zoo
   */
  public List<Animal> getAnimals(){
    return this.animals;
  }

  /**
   *  @return String
   *  List of name and species of each animal in the zoo
   */
  public String toString() {
    String formattedZoo = "";
    for(int i = 0; i < this.animals.size(); i++){
      formattedZoo += this.animals.get(i).toString();
      // Only add new line if not the last element in ArrayList
      if(i != this.animals.size()-1){
        formattedZoo += "\n";
      }
    }
    return formattedZoo;
  }
}
