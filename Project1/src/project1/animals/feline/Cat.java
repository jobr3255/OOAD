package project1.animals.feline;

// Better at random number generating than java.util.Random
import java.security.SecureRandom;

public class Cat extends Feline {

	public Cat(String name) {
		super(name);
	}

	/**
	 *  Disobey order and do something random
	 */
	public void sleep() {
		doRandomAction();
	}

	/**
	 *  Make a cat sound
	 */
	public void makeNoise() {
		System.out.println(toString() + " meowed");
	}

	/**
	 *  Make the cat do a random action
	 */
	private void doRandomAction() {
		// create random number between 0 and 5
		int choice = (new SecureRandom()).nextInt(5);
		String action = "";
		switch (choice) {
		// Sleep
		case 0:  super.sleep();
			return;
		case 1:  action = "hissed";
			break;
		case 2:  action = "ran around in cicles";
			break;
		case 3:  action = "climbed a tree";
			break;
		case 4:  action = "is now grooming themselves";
			break;
		case 5:  action = "is now scratching a tree";
			break;
		}
		System.out.println(toString() + " " + action);
	}

}
