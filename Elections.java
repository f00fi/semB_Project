package Election;

import java.time.LocalDate;
import java.util.Arrays;

public class Elections {

	private Citizen[] pinkasBoharim;
	private int citiLogiSize;
	private int citiPhysSize;
	private PoliticalParty[] partysList;
	private int[] electionsResults;
	private int partyLogiSize;
	private int partyPhysSize;
	private Kalphi[] kalphiList;
	private int kalphiLogiSize;
	private int kalphiPhysSize;
	private boolean elected;
	private LocalDate electionsDate;

	public Elections() {
		citiLogiSize = 1;
		citiPhysSize = 0;
		partyLogiSize = 1;
		partyPhysSize = 0;
		kalphiLogiSize = 1;
		kalphiPhysSize = 0;
		pinkasBoharim = new Citizen[citiLogiSize];
		partysList = new PoliticalParty[partyLogiSize];
		kalphiList = new Kalphi[kalphiLogiSize];
		elected = false;
		electionsResults = new int[1];
	}

	public boolean addKalphi(int type, String address) {
		if (kalphiPhysSize == kalphiLogiSize)
			allocateKalphiLogicSize();
		if (type == 1) {
			kalphiList[kalphiPhysSize] = new Kalphi(address);
			kalphiPhysSize++;
			return true;
		} else if (type == 2) {
			kalphiList[kalphiPhysSize] = new CoronaKalphi(address);
			kalphiPhysSize++;
			return true;
		} else if (type == 3) {
			kalphiList[kalphiPhysSize] = new MilitaryKalphi(address);
			kalphiPhysSize++;
			return true;
		}
		return false;
	}

	private void allocateKalphiLogicSize() {
		kalphiLogiSize = kalphiLogiSize * 2;
		Kalphi[] temp = Arrays.copyOf(kalphiList, kalphiLogiSize);
		kalphiList = temp;
	}

	public boolean addCitizen(Citizen newCitizen) {
		if (citiPhysSize == citiLogiSize)
			allocateCitizenLogicSize();
		pinkasBoharim[citiPhysSize] = newCitizen;
		citiPhysSize++;
		assignKalphi(newCitizen);
		return true;
	}

	private void allocateCitizenLogicSize() {
		citiLogiSize = citiLogiSize * 2;
		Citizen[] temp = Arrays.copyOf(pinkasBoharim, citiLogiSize);
		pinkasBoharim = temp;
	}

	public boolean addPoliticalParty(PoliticalParty newPoliticalParty) {
		if (partyPhysSize == partyLogiSize)
			allocatePoliticalPartyLogicSize();
		partysList[partyPhysSize] = newPoliticalParty;
		partyPhysSize++;
		return true;
	}

	private void allocatePoliticalPartyLogicSize() {
		partyLogiSize = partyLogiSize * 2;
		PoliticalParty[] temp = Arrays.copyOf(partysList, partyLogiSize);
		partysList = temp;
	}

	public boolean addCandidate(int identityNumber, String nameOfParty) {
		for (int i = 0; i < citiPhysSize; i++) {
			if (pinkasBoharim[i].getIdentityNumber() == identityNumber) {
				for (int j = 0; j < partyPhysSize; j++) {
					if (partysList[j].getNameOfParty().equals(nameOfParty)) {
						pinkasBoharim[i] = new Candidate(pinkasBoharim[i], partysList[j]);
						partysList[j].addCandidate((Candidate) pinkasBoharim[i]);
						return true;
					}
				}
			}
		}
		System.out.println("couldnt add candidate");
		return false;
	}

	private void assignKalphi(Citizen citizen) {
		int age = LocalDate.now().getYear() - citizen.getYearOfBirth();
		int type;
		if (citizen.isIsolated)
			type = 2;
		else if (age > 17 && age < 22)
			type = 3;
		else
			type = 1;
		citizen.votingKalphi = kalphiList[getRightKalphi(type)];
		citizen.votingKalphi.addToKalphi(citizen);
	}

	private int getRightKalphi(int type) {
		int rand = ((int) (Math.random() * 10) + 1);
		int i = 0;
		while (true) {
			if (type == 3 && kalphiList[i] instanceof MilitaryKalphi) {
				if (((int) (Math.random() * 10) + 1) == rand)
					return i;
			}
			if (type == 2 && kalphiList[i] instanceof CoronaKalphi) {
				if (((int) (Math.random() * 10) + 1) == rand)
					return i;
			}
			if (type == 1 && !(kalphiList[i] instanceof CoronaKalphi) && !(kalphiList[i] instanceof MilitaryKalphi)) {
				if (((int) (Math.random() * 10) + 1) == rand)
					return i;
			}
			i++;
			if (i == kalphiPhysSize)
				i = 0;
		}
	}

	public void electionsRound() {
		electionsResults = new int[partyPhysSize];
		for (int i = 0; i < kalphiPhysSize; i++) {
			kalphiList[i].setVotingCount(partyPhysSize);// sync parties list with kalphies
			kalphiList[i].Vote();
			for (int j = 0; j < partyPhysSize; j++) {
				electionsResults[j] += kalphiList[i].getVotingCount(j);
			}
		}
		electionsDate = LocalDate.now();
		elected = true;
	}

	public void kalphiResult() {
		for (int i = 0; i < kalphiPhysSize; i++) {
			System.out.println("***********************************************************************");
			System.out.println("In " + kalphiList[i].getClass().getSimpleName() + " on "
					+ kalphiList[i].getKalphiAddress() + " The results are:");
			System.out.println("Total voters: " + kalphiList[i].getNumOfVoters());
			System.out.printf("Votes percetanage: %.2f%% \n", kalphiList[i].getVotingPercentage());
//			System.out.printf("Votes percetanage: " + kalphiList[i].getVotingPercentage() + "%");
			for (int j = 0; j < partyPhysSize; j++) {
				System.out.println(partysList[j].getNameOfParty() + ": " + kalphiList[i].getVotingCount(j));
			}
		}
		System.out.println("*****************");
		System.out.println("Total Votes:");
		for (int j = 0; j < partyPhysSize; j++) {
			System.out.println(partysList[j].getNameOfParty() + ": " + electionsResults[j]);
		}
		System.out.println("*****************");

	}

	public void showCitizens() {
		for (int i = 0; i < citiPhysSize; i++)
			System.out.println(pinkasBoharim[i]);
	}

	public void showPartysList() {
		for (int i = 0; i < partyPhysSize; i++)
			System.out.println(partysList[i]);
	}

	public void showKalphiList() {
		for (int i = 0; i < kalphiPhysSize; i++)
			System.out.println(kalphiList[i]);
	}

	public Kalphi GetKalphi(int kalphiID) {
		if (kalphiList[kalphiID] instanceof CoronaKalphi)
			return (CoronaKalphi) kalphiList[kalphiID];
		if (kalphiList[kalphiID] instanceof MilitaryKalphi)
			return (MilitaryKalphi) kalphiList[kalphiID];

		return kalphiList[kalphiID];
	}

	public boolean equals() {

		return true;
	}

	@Override
	public String toString() {
		String boharim = "";
		for (int i = 0; i < citiPhysSize; i++) {
			boharim += pinkasBoharim[i];
		}
		String kalphis = "";
		for (int i = 0; i < kalphiPhysSize; i++) {
			kalphis += kalphiList[i];
		}
		String parties = "";
		for (int i = 0; i < partyPhysSize; i++) {
			parties += partysList[i];
		}
		return String.format(
				"Elections round:\n" + "Voters List:\n %s " + "\nPartys List:\n %s \n" + "\nKalphi List:\n %s \n",
				boharim, parties, kalphis);
	}

	public boolean getElected() {
		return elected;
	}

}
