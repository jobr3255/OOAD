package project1.animals;

public abstract class Animal {
  protected String name;
  /**
   *  Abstract methods
   */
  public abstract void eat();
  public abstract void makeNoise();

  /**
   *  Prints that the animal in now roaming
   */
  public void wakeUp(){
    System.out.println(this.toString() + " is now awake");
  }

  /**
   *  Prints that the animal in now roaming
   */
  public void roam(){
    System.out.println(this.toString() + " is now roaming");
  }

  /**
   *  Prints that the animal in now asleep
   */
  public void sleep(){
    System.out.println(this.toString() + " went to sleep");
  }

  /**
   *  @param name String
   *  Name of the animal
   */
  public Animal(String name){
    this.name = name;
  }

  /**
   *  @return String
   *  Name of the animal
   */
  public String getName(){
    return this.name;
  }

  /**
   *  @return String
   *  Returns string of the type of species
   */
  public String getSpecies(){
    return this.getClass().getSimpleName();
  }

  /**
   *  @return String
   *  Name and species of animal
   */
  public String toString(){
    return this.name + " the " + this.getClass().getSimpleName();
  }
}
