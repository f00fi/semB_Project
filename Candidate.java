package Election;

public class Candidate extends Citizen {

	private PoliticalParty politicalParty;

	public Candidate(String name, int id, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated,
			PoliticalParty politicalParty) {
		super(name, id, yearOfBirth, votingKalphi, isIsolated);
		this.politicalParty = politicalParty;
	}
	public Candidate(Citizen civilian,PoliticalParty politicalParty) {
		this(civilian.name,civilian.id,civilian.yearOfBirth,civilian.votingKalphi,civilian.isIsolated,politicalParty);
		
	}

	 public Candidate(Candidate candidate) {
		super(candidate);
		this.politicalParty = politicalParty;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() + "Candidate [politicalParty=" + politicalParty + "]";
	}

}