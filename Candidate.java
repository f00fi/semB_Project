package election;

public class Candidate extends Civilian {

	private PoliticalParty politicalParty;

	public Candidate(String name, int id, int yearOfBirth, Kalphi votingKalphi, boolean isolation,
			PoliticalParty politicalParty) {
		super(name, id, yearOfBirth, votingKalphi, isolation);
		this.politicalParty = politicalParty;
	}

	@Override
	public String toString() {
		return super.toString() + "Candidate [politicalParty=" + politicalParty + "]";
	}

}