import { Feline } from "./Feline";

// Better at random number generating than java.util.Random
// import java.security.SecureRandom;

export default class Cat extends Feline {

	/**
	 *  Disobey order and do something random
	 */
	public sleep() {
		this.doRandomAction();
	}

	/**
	 *  Make the cat do a random action
	 */
	private doRandomAction() {
		// create random number between 0 and 5
		var choice = Math.floor(Math.random() * 6);
		var action = "";
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
		console.log(this.toString() + " " + action);
	}

}
