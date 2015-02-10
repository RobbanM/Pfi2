public class Snake extends Animal {

	private boolean poisonous;

	public Snake(String latinName, boolean poisonous) {
		super(latinName);
		this.poisonous = poisonous;
	}

	public boolean isPoisonous() {
		return poisonous;
	}

	public String getInfo() {
		String s;
		if (poisonous) {
			s = "poisonous";
		} else {
			s = "not poisonous";
		}
		return "The snake " + super.getLatinName() + " is " + s;
	}
}
