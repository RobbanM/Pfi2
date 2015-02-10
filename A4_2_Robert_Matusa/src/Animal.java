public abstract class Animal {
	private String latinName;
	private String friendlyName;

	public Animal(String latinName) {
		this.latinName = latinName;
	}

	public abstract String getInfo();

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getFriendlyName() {
		return friendlyName;

	}

	public void setLatinName(String latinName) {
		this.latinName = latinName;

	}

	public String getLatinName() {
		return latinName;
	}
}
