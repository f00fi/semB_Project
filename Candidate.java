package election;

public class Candidate extends Civilian {

	private PoliticalParty politicalParty;

	public Candidate(String name, int id, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated,
			PoliticalParty politicalParty) {
		super(name, id, yearOfBirth, votingKalphi, isIsolated);
		this.politicalParty = politicalParty;
	}
	public Candidate(Civilian civilian,PoliticalParty politicalParty) {//27.3.2020 בנאי שמקבל אזרח ומפלגה ומייצר מועמד/ omer
		this(civilian.name,civilian.id,civilian.yearOfBirth,civilian.votingKalphi,civilian.isIsolated,politicalParty);
		
	}

	@Override
	public String toString() {
		return super.toString() + "Candidate [politicalParty=" + politicalParty + "]";
	}

}