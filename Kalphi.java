package Election;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Kalphi<T extends Citizen>   {
	
	
	protected int id;
	protected static int idCounter = 1;
	protected String kalphiAddress;
	protected Citizen[] eliglbleCitizens;
	protected int kalphiLogiSize, kalphiPhysSize;
	protected int numOfVoters;
	protected double votingPercentage;
	protected int[] votingCount;

	public Kalphi(String kalphiAddress) {
		this.id = idCounter++;
		this.kalphiAddress = kalphiAddress;
		kalphiPhysSize = 1;
		this.eliglbleCitizens = new Citizen[kalphiPhysSize];
		this.votingCount = new int[1];
		numOfVoters = 0;
	}

	public Kalphi(Kalphi newKalphi<>) {
		this.id = newKalphi.id;
		this.kalphiAddress = newKalphi.kalphiAddress;
		this.eliglbleCitizens = (T[])new Object[newKalphi.kalphiPhysSize];
		this.votingCount = new int[1];
		numOfVoters = 0;
	}

	public void addToKalphi(Citizen newCitizen) {
		if (kalphiLogiSize == kalphiPhysSize)
			allocateCitizenPhysSize();
		eliglbleCitizens[kalphiLogiSize++] = newCitizen;
	}

	private void allocateCitizenPhysSize() {
		kalphiPhysSize = kalphiPhysSize * 2;
		Citizen[] temp = Arrays.copyOf(eliglbleCitizens, kalphiPhysSize);
		eliglbleCitizens = temp;
	}

	public void Vote() {
		numOfVoters = 0;
		if (kalphiLogiSize != 0) {
			boolean IsVoting;
			int partyChoice;
			for (int i = 0; i < kalphiLogiSize; i++) {
				IsVoting = ThreadLocalRandom.current().nextBoolean();
				if (IsVoting) {
					partyChoice = ThreadLocalRandom.current().nextInt(0, votingCount.length);
					votingCount[partyChoice]++;
					numOfVoters++;
				}
			}
			votingPercentage = calcNumOfVoters(numOfVoters);
		}
	}

	public String getKalphiAddress() {
		return this.kalphiAddress;
	}

	public int getVotingCount(int partyIndex) {
		return votingCount[partyIndex];
	}

	protected double calcNumOfVoters(int numOfVoters) {
		double scale = Math.pow(10, 2);
		if (numOfVoters != 0)
			return (Math.round((numOfVoters / (double) kalphiLogiSize * 100) * scale) / scale);
		return 0;
	}

	protected void setVotingCount(int numOfParties) {
		this.votingCount = new int[numOfParties];
	}

	public int getNumOfVoters() {
		return numOfVoters;
	}

	public double getVotingPercentage() {
		return votingPercentage;
	}

	public boolean equals(Kalphi newKalphi) {
		if (id == newKalphi.id)
			return true;
		return false;
	}

	@Override
	public String toString() {

		return "Kalphi ID: " + id + "\n Type: " + this.getClass().getSimpleName() + "\n Kalphi address: "
				+ kalphiAddress + "\n Voting percentage: " + votingPercentage + "% \n Voting count:"
				+ Arrays.toString(votingCount) + "\n";
	}

}
