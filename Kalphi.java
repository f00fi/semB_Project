package Election;

import java.util.Arrays;

public class Kalphi {
	protected int id;
	protected static int idCounter = 1;
	protected String kalphiAddress;
	protected Citizen[] eliglbleCitizens;
	protected int kalphiPhysSize, kalphiLogiSize;
	protected double votingPercentage;
	protected int[] votingCount;

	public Kalphi(String kalphiAddress) {
		this.id = idCounter++;
		this.kalphiAddress = kalphiAddress;
		kalphiLogiSize = 1;
		this.eliglbleCitizens = new Citizen[kalphiLogiSize];
	}

	public Kalphi(Kalphi newKalphi) {
		this.id = newKalphi.id;
		this.kalphiAddress = newKalphi.kalphiAddress;
		this.eliglbleCitizens = new Citizen[newKalphi.kalphiLogiSize];
	}

	public void addToKalphi(Citizen newCitizen) {
		if (kalphiPhysSize == kalphiLogiSize)
			allocateCitizenLogicSize();
		eliglbleCitizens[kalphiPhysSize++] = newCitizen;
	}

	private void allocateCitizenLogicSize() {
		kalphiLogiSize = kalphiLogiSize * 2;
		Citizen[] temp = Arrays.copyOf(eliglbleCitizens, kalphiLogiSize);
		eliglbleCitizens = temp;
	}

	@Override
	public String toString() {
		String eligString = "";
		for (int i = 0; i < kalphiPhysSize; i++) {
			eligString += eliglbleCitizens[i];
		}
		return "Kalphi ID: " + id + "\n Type: " + this.getClass().getSimpleName() + "\n Kalphi address: "
				+ kalphiAddress + "\n Eliglble citizens: " + eligString + "\n Voting percentage: " + votingPercentage
				+ ",\n Voting count:" + Arrays.toString(votingCount) + "\n";
	}

}
