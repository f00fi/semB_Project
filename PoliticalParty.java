package Election;

import java.time.LocalDate;

public class PoliticalParty {

	private String nameOfParty;
	public enum epoliticalOrientation{yemin,mercas,small};
	private LocalDate thePartyFoundingDate;
	private epoliticalOrientation politicalOrientation;
	
	public PoliticalParty(String nameOfParty, epoliticalOrientation politicalOrientation, LocalDate thePartyFoundingDate) {
		this.nameOfParty = nameOfParty;
		this.politicalOrientation = politicalOrientation;
		this.thePartyFoundingDate = thePartyFoundingDate;
	}

		
	
		public PoliticalParty(PoliticalParty newPoliticalParty) {
		this(newPoliticalParty.nameOfParty, newPoliticalParty.politicalOrientation,
				newPoliticalParty.thePartyFoundingDate);
	}

	


	public String getNameOfParty() {
			return nameOfParty;
		}



	@Override
	public String toString() {
		return "PoliticalParty [nameOfParty=" + nameOfParty + ", politicalOrientation=" + politicalOrientation
				+ ", thePartyFoundingDate=" + thePartyFoundingDate + "]";
	}

}
