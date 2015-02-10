public class Cat extends Mammal {
	private int numberOfLives;

	public Cat(String latinName, int gestationTime, int numberOfLives) {
		super(latinName, gestationTime);
		this.numberOfLives = numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

	public int getNumberOfLives() {
		return numberOfLives;
	}

	public String getInfo() {

		return "The cat " + super.getLatinName() + " nurses for "
				+ super.getGestationTime() + " months and has " + numberOfLives
				+ " lives.";

	}

}
