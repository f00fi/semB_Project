package Election;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

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
		this.votingCount = new int[1];
	}

	public Kalphi(Kalphi newKalphi) {
		this.id = newKalphi.id;
		this.kalphiAddress = newKalphi.kalphiAddress;
		this.eliglbleCitizens = new Citizen[newKalphi.kalphiLogiSize];
		this.votingCount = new int[1];
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

	public String getKalphiAddress() {
		return this.kalphiAddress;
	}

	public int getVotingCount(int partyIndex) {
		return votingCount[partyIndex];
	}

	protected void setVotingCount(int numOfParties) {
		this.votingCount = new int[numOfParties];
	}

	public void Vote() {
		boolean IsVoting;
		int partyChoice;
		for (int i = 0; i < kalphiPhysSize; i++) {
			IsVoting = ThreadLocalRandom.current().nextBoolean();
			if (IsVoting) {
				partyChoice = ThreadLocalRandom.current().nextInt(0, votingCount.length);
				votingCount[partyChoice]++;
				
			}
		}
		votingPercentage();
	}

	public boolean equals(Kalphi newKalphi) {
		if (id == newKalphi.id) {
			return true;
		}
		return false;
	}

	protected void votingPercentage() {

		double numOfVoters = 0;
		for (int i = 0; i < votingCount.length; i++) {
			numOfVoters += votingCount[i];
		}

		votingPercentage = (numOfVoters / kalphiPhysSize) * 100;

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
