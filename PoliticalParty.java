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
	int candidatesListLogiSize, candidatesListPhysSize;
	private ePoliticalOrientation politicalOrientation;

	public PoliticalParty(String nameOfParty, ePoliticalOrientation politicalOrientation,
			LocalDate thePartyFoundingDate) {
		this.nameOfParty = nameOfParty;
		this.politicalOrientation = politicalOrientation;
		this.thePartyFoundingDate = thePartyFoundingDate;
		candidatesListPhysSize = 1;
		candidatesList = new Candidate[candidatesListPhysSize];
		
	}

	public PoliticalParty(PoliticalParty newPoliticalParty) {
		this(newPoliticalParty.nameOfParty, newPoliticalParty.politicalOrientation,
				newPoliticalParty.thePartyFoundingDate);
		candidatesListPhysSize = newPoliticalParty.candidatesListPhysSize;
		candidatesListLogiSize = newPoliticalParty.candidatesListLogiSize;
		Candidate[] tempCandidates = Arrays.copyOf(newPoliticalParty.candidatesList, candidatesListPhysSize);
		this.candidatesList = tempCandidates;
	}

	public boolean addCandidate(Candidate newCandidate) {
		if (candidatesListPhysSize == candidatesListLogiSize)
			allocateCandidatesListLogicSize();
		candidatesList[candidatesListLogiSize] = newCandidate;
		candidatesListLogiSize++;
		return true;
	}

	private void allocateCandidatesListLogicSize() {
		candidatesListPhysSize = candidatesListPhysSize * 2;
		Candidate[] temp = Arrays.copyOf(candidatesList, candidatesListPhysSize);
		candidatesList = temp;
	}

	public void primaries() {
		int[] arr = new int[candidatesListLogiSize];
		for (int i = 0; i < candidatesListLogiSize; i++) {
			int rand = ((int) (Math.random() * candidatesListLogiSize));
			arr[rand]++;
		}
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[j + 1]) {
					Candidate temp = candidatesList[j];
					candidatesList[j] = candidatesList[j + 1];
					candidatesList[j + 1] = temp;
				}
			}
		}
	}

	public String getNameOfParty() {
		return nameOfParty;
	}

	public String getCandidateName() {
		return candidatesList[0].name;
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
		for (int i = 0; i < candidatesListLogiSize; i++) {
			candidates += candidatesList[i].toString();
		}
		return "Party name: " + nameOfParty + "\n Orientaion: " + politicalOrientation + "\n Founding Date:"
				+ thePartyFoundingDate + "\n Candidates:\n" + candidates;
	}

}
