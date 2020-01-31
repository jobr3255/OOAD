package project1.animals.canine;

public class Wolf extends Canine {

	public Wolf(String name) {
		super(name);
	}

	/**
	 *  Make a wolf sound
	 */
	public void makeNoise() {
		System.out.println(toString() + " howeled");
	}
}
