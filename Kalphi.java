package Election;

import java.util.Arrays;

public class Kalphi {
	protected int id;
	protected static int idCounter = 1;
	protected String kalphiAddress;
	protected Citizen[] eliglbleCitizens;
	protected double votingPercentage;
	protected int[] votingCount;

	public Kalphi(String kalphiAddress) {
		this.id = idCounter++;
		this.kalphiAddress = kalphiAddress;
		this.eliglbleCitizens = new Citizen[1];
	}

	public Kalphi(Kalphi newKalphi) {
		this.id = newKalphi.id;
		this.kalphiAddress = newKalphi.kalphiAddress;
		this.eliglbleCitizens = new Citizen[1];
	}

	@Override
	public String toString() {
		return "Kalphi ID: " + id + "\n Type: " + this.getClass().getSimpleName() + "\n Kalphi address: "
				+ kalphiAddress + "\n Eliglble citizens: " + Arrays.toString(eliglbleCitizens)
				+ "\n Voting percentage: " + votingPercentage + ",\n Voting count:" + Arrays.toString(votingCount)
				+ "\n";
	}

}
