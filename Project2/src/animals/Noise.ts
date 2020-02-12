/**
 *  This file holds the Noise classes and use the strategy patter
 */

 /**
  *  This is the main strategy
  */
export default interface Noise {
    getNoise: () => void;
}

/**
 *  These are all the specific opperations for each animal
 */


 // Dogs
export class Bark implements Noise{
  getNoise(){
    return "barked";
  }
}

// Wolfs
export class Howel implements Noise{
  getNoise(){
    return "howeled";
  }
}

// Cats
export class Meow implements Noise{
  getNoise(){
    return "meowed";
  }
}

// Lions
export class Roar implements Noise{
  getNoise(){
    return "roared";
  }
}

// Tigers
export class Growl implements Noise{
  getNoise(){
    return "growled";
  }
}

// Elephants
export class Trumpet implements Noise{
  getNoise(){
    return "trumpeted";
  }
}

// Hippos and rhinos
export class Grunt implements Noise{
  getNoise(){
    return "grunted";
  }
}
