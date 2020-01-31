package project1.animals.feline;

public class Tiger extends Feline {

	public Tiger(String name) {
		super(name);
	}

	/**
	 *  Make a tiger sound
	 */
	public void makeNoise() {
		System.out.println(toString() + " groweled");
	}
}
