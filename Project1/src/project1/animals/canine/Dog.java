package project1.animals.canine;

public class Dog extends Canine {

	public Dog(String name) {
		super(name);
	}

	/**
	 *  Make a dog sound
	 */
	public void makeNoise() {
		System.out.println(toString() + " barked");
	}
}
