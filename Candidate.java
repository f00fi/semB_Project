package Election;

public class Candidate extends Citizen {

	private PoliticalParty politicalParty;

	public Candidate(String name, int identityNumber, int yearOfBirth, boolean isIsolated, // with no kalphi assigned
			PoliticalParty politicalParty) {
		super(name, identityNumber, yearOfBirth, isIsolated);
		this.politicalParty = new PoliticalParty(politicalParty);
	}

	public Candidate(String name, int identityNumber, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated,
			PoliticalParty politicalParty) {
		super(name, identityNumber, yearOfBirth, votingKalphi, isIsolated);
		this.politicalParty = new PoliticalParty(politicalParty);
	}

	public Candidate(Citizen newCitizen, PoliticalParty politicalParty) {
		super(newCitizen);
		this.politicalParty = politicalParty;
	}

	public Candidate(Candidate newCandidate) {
		super(newCandidate);
		this.politicalParty = newCandidate.politicalParty;
	}

	
	
	
	@Override
	public boolean equals(Citizen newCitizen) {
		
		return super.equals(newCitizen);
	}

	@Override
	public String toString() {
		return super.toString() + " Candidate for: " + politicalParty.getNameOfParty() + "\n";
	}

}