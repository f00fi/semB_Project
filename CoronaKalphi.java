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
		boolean IsVoting, isWithSuite;
		int partyChoice;
		for (int i = 0; i < kalphiPhysSize; i++) {
			IsVoting = ThreadLocalRandom.current().nextBoolean();
			if (IsVoting) {
				isWithSuite = ThreadLocalRandom.current().nextBoolean();
				if (eliglbleCitizens[i].isIsolated && isWithSuite) {
					partyChoice = ThreadLocalRandom.current().nextInt(0, votingCount.length);
					votingCount[partyChoice]++;
					
				}
			}
		}
		votingPercentage();
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
