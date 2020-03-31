package Election;

import java.time.LocalDate;

public class PoliticalParty {

	private String nameOfParty;
	private String politicalOrientation;
	private LocalDate thePartyFoundingDate;

	public PoliticalParty(String nameOfParty, String politicalOrientation, LocalDate thePartyFoundingDate) {

		this.nameOfParty = nameOfParty;
		this.politicalOrientation = politicalOrientation;
		this.thePartyFoundingDate = thePartyFoundingDate;
	}
	public PoliticalParty(PoliticalParty politicalParty) {

		this.nameOfParty = nameOfParty;
		this.politicalOrientation = politicalOrientation;
		this.thePartyFoundingDate = thePartyFoundingDate;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "PoliticalParty [nameOfParty=" + nameOfParty + ", politicalOrientation=" + politicalOrientation
				+ ", thePartyFoundingDate=" + thePartyFoundingDate + "]";
	}

}
