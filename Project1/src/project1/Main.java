package project1;

import project1.animals.feline.Cat;

/**
 *  Main driver class for the application
 */
public class Main {
	public static void main(String [] args) {
		Zoo zoo = new Zoo();
		zoo.setDefaultAnimals();

		// System.out.println(zoo);
		Zookeeper zookeeper = new Zookeeper();
		zookeeper.wakeAnimals(zoo);
		zookeeper.rollCall(zoo);
		zookeeper.feedAnimals(zoo);
		zookeeper.exerciseAnimals(zoo);
		zookeeper.closeZoo(zoo);
	}
}
