package project1.animals.pachyderm;

public class Elephant extends Pachyderm {

	public Elephant(String name) {
		super(name);
	}

	/**
	 *  Make an elephant sound
	 */
	public void makeNoise() {
		System.out.println(toString() + " trumpeted");
	}
}
