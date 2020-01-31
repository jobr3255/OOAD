package project1.animals.pachyderm;

public class Rhino extends Pachyderm {

	public Rhino(String name) {
		super(name);
	}

	/**
	 *  Make a rhino sound
	 */
	public void makeNoise() {
		System.out.println(toString() + " grunted");
	}
}
