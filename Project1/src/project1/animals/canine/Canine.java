package project1.animals.canine;

import project1.animals.Animal;

public abstract class Canine extends Animal {

  public Canine(String name){
    super(name);
  }

  public abstract void makeNoise();

  /**
   *  Canines eat kibble
   */
  public void eat(){
    System.out.println(toString() + " is eating kibble");
  }
}
