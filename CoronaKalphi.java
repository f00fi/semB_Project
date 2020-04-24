package Election;

import java.util.concurrent.ThreadLocalRandom;

public class CoronaKalphi extends Kalphi {

	public CoronaKalphi(String kalphiAddress) {
		super(kalphiAddress);
	}

	public CoronaKalphi(CoronaKalphi coronaKalphi) {
		super(coronaKalphi);
	}

	public void Vote() {
		numOfVoters = 0;
		boolean IsVoting, isWithSuite;
		int partyChoice;
		for (int i = 0; i < kalphiPhysSize; i++) {
			IsVoting = ThreadLocalRandom.current().nextBoolean();
			isWithSuite = ThreadLocalRandom.current().nextBoolean();
			if (IsVoting && isWithSuite) {
				partyChoice = ThreadLocalRandom.current().nextInt(0, votingCount.length);
				votingCount[partyChoice]++;
				numOfVoters++;
			}
		}
		votingPercentage = calcNumOfVoters(numOfVoters);
	}

	@Override
	public boolean equals(Kalphi newKalphi) {

		return super.equals(newKalphi);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
