public class Dog extends Mammal {

	private boolean stupid;

	public Dog(String friendlyName, String latinName, int gestationTime,
			boolean stupid) {
		super(latinName, gestationTime);
		this.stupid = stupid;
		this.friendlyName = friendlyName;
	}

	public boolean isStupid() {
		return stupid;

	}

	public String getInfo() {
		String s = "";
		if (stupid) {
			s = "stupid.";
		} else {
			s = "not stupid.";
		}
		return "The dog " + super.getFriendlyName() + " lat: "
				+ super.getLatinName() + ", nurses for "
				+ super.getGestationTime() + " months and is " + s;
	}

}
