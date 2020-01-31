package project1.animals.feline;

public class Lion extends Feline {

	public Lion(String name) {
		super(name);
	}

	/**
	 *  Make a lion sound
	 */
	public void makeNoise() {
		System.out.println(toString() + " roared");
	}
}
