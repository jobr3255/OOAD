package project1.animals.feline;
import project1.animals.Animal;

public abstract class Feline extends Animal {
  public Feline(String name){
    super(name);
  }

  public abstract void makeNoise();

  /**
   *  Felines eat tuna
   */
  public void eat(){
    System.out.println(toString() + " is now eating tuna");
  }
}
