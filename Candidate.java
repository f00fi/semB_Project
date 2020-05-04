package Election;

public class Candidate extends Citizen {

	private PoliticalParty politicalParty;

	public Candidate(String name, String identityNumber, int yearOfBirth, boolean isIsolated, // with no kalphi assigned
			PoliticalParty politicalParty) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		super(name, identityNumber, yearOfBirth, isIsolated);
		this.politicalParty = new PoliticalParty(politicalParty);
	}

	public Candidate(String name, String identityNumber, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated,
			PoliticalParty politicalParty) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		super(name, identityNumber, yearOfBirth, votingKalphi, isIsolated);
		this.politicalParty = new PoliticalParty(politicalParty);
	}

	public Candidate(Citizen newCitizen, PoliticalParty politicalParty) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		super(newCitizen);
		this.politicalParty = politicalParty;
	}

	public Candidate(Candidate newCandidate) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
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