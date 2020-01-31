package project1.animals.pachyderm;
import project1.animals.Animal;

public abstract class Pachyderm extends Animal{
  public Pachyderm(String name){
    super(name);
  }

  public abstract void makeNoise();


  /**
   *  Pachyderms graze on grass
   */
  public void eat(){
    System.out.println(toString() + " is grazing on grass");
  }
}
