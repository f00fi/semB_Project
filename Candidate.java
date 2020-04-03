package Election;

public class Candidate extends Citizen {

	private PoliticalParty politicalParty;

	public Candidate(String name, int id, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated,
			PoliticalParty politicalParty) {
		super(name, id, yearOfBirth, votingKalphi, isIsolated);
		this.politicalParty = politicalParty;
	}

	public Candidate(Citizen newCitizen, PoliticalParty politicalParty) {
		this(newCitizen.name, newCitizen.id, newCitizen.yearOfBirth, newCitizen.votingKalphi, newCitizen.isIsolated,
				politicalParty);
	}

	public Candidate(Candidate newCandidate) {
		super(newCandidate);
		this.politicalParty = newCandidate.politicalParty;
	}

	@Override
	public String toString() {
		return super.toString() + "Candidate [politicalParty=" + politicalParty + "]";
	}

}