package project1.animals.pachyderm;

public class Hippo extends Pachyderm {

	public Hippo(String name) {
		super(name);
	}

	/**
	 *  Make a hippo sound
	 */
	public void makeNoise() {
		System.out.println(toString() + " grunted");
	}
}
