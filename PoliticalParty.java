package Election;

import java.time.LocalDate;
import java.util.Arrays;

public class PoliticalParty {
	public enum ePoliticalOrientation {
		left, center, right
	};

	private String nameOfParty;
	private LocalDate thePartyFoundingDate;
	private Candidate[] candidatesList;
	int candidatesListPhysSize, candidatesListLogiSize;
	private ePoliticalOrientation politicalOrientation;

	public PoliticalParty(String nameOfParty, ePoliticalOrientation politicalOrientation,
			LocalDate thePartyFoundingDate) {
		this.nameOfParty = nameOfParty;
		this.politicalOrientation = politicalOrientation;
		this.thePartyFoundingDate = thePartyFoundingDate;
		candidatesListLogiSize = 1;
		candidatesListPhysSize = 0;
		candidatesList = new Candidate[candidatesListLogiSize];
	}

	public PoliticalParty(PoliticalParty newPoliticalParty) {
		this(newPoliticalParty.nameOfParty, newPoliticalParty.politicalOrientation,
				newPoliticalParty.thePartyFoundingDate);
		candidatesListLogiSize = newPoliticalParty.candidatesListLogiSize;
		candidatesListPhysSize = newPoliticalParty.candidatesListPhysSize;
		Candidate[] tempCandidates = Arrays.copyOf(newPoliticalParty.candidatesList, candidatesListLogiSize);
		this.candidatesList = tempCandidates;
	}

	public boolean addCandidate(Candidate newCandidate) {
		if (candidatesListLogiSize == candidatesListPhysSize)
			allocateCandidatesListLogicSize();
		candidatesList[candidatesListPhysSize] = newCandidate;
		candidatesListPhysSize++;
		return true;
	}

	private void allocateCandidatesListLogicSize() {
		candidatesListLogiSize = candidatesListLogiSize * 2;
		Candidate[] temp = Arrays.copyOf(candidatesList, candidatesListLogiSize);
		candidatesList = temp;
	}

	public String getNameOfParty() {
		return nameOfParty;
	}

	public boolean equals(PoliticalParty newPoliticalParty) {
		if (nameOfParty.equalsIgnoreCase(newPoliticalParty.nameOfParty)) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		String candidates = "";
		for (int i = 0; i < candidatesListPhysSize; i++) {
			candidates += candidatesList[i].toString();
		}
		return "Party name: " + nameOfParty + "\n Orientaion: " + politicalOrientation + "\n Founding Date:"
				+ thePartyFoundingDate + "\n Candidates:\n" + candidates + "\n";
	}

}
