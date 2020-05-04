package Election;

import java.time.LocalDate;
import java.util.Arrays;

public class Elections {

	private Citizen[] pinkasBoharim;
	private int citiPhysSize;
	private int citiLogiSize;
	private PoliticalParty[] partysList;
	private int[] electionsResults;
	private int partyPhysSize;
	private int partyLogiSize;
	private Kalphi[] kalphiList;
	private int kalphiPhysSize;
	private int kalphiLogiSize;
	private boolean elected;
	private LocalDate electionsDate;

	public Elections() {
		citiPhysSize = 1;
		partyPhysSize = 1;
		kalphiPhysSize = 1;
		pinkasBoharim = new Citizen[citiPhysSize];
		partysList = new PoliticalParty[partyPhysSize];
		kalphiList = new Kalphi[kalphiPhysSize];
		elected = false;
		electionsResults = new int[1];
	}

	public boolean addKalphi(int type, String address) {
		if (kalphiLogiSize == kalphiPhysSize)
			allocateKalphiPhysSize();
		if (type == 1) {
			kalphiList[kalphiLogiSize] = new Kalphi(address);
			kalphiLogiSize++;
			return true;
		} else if (type == 2) {
			kalphiList[kalphiLogiSize] = new CoronaKalphi(address);
			kalphiLogiSize++;
			return true;
		} else if (type == 3) {
			kalphiList[kalphiLogiSize] = new MilitaryKalphi(address);
			kalphiLogiSize++;
			return true;
		}
		return false;
	}

	private void allocateKalphiPhysSize() {
		kalphiPhysSize = kalphiPhysSize * 2;
		Kalphi[] temp = Arrays.copyOf(kalphiList, kalphiPhysSize);
		kalphiList = temp;
	}

	public boolean addCitizen(Citizen newCitizen) {
		if (isAlreadyCitizen(newCitizen))
			return false;
		if (citiLogiSize == citiPhysSize)
			allocateCitizenPhysSize();
		pinkasBoharim[citiLogiSize] = newCitizen;
		citiLogiSize++;
		assignKalphi(newCitizen);
		return true;
	}

	private boolean isAlreadyCitizen(Citizen newCitizen) {
		for (int i = 0; i < citiLogiSize; i++) {
			if (newCitizen.equals(pinkasBoharim[i]))
				return true;
		}
		return false;
	}

	private void allocateCitizenPhysSize() {
		citiPhysSize = citiPhysSize * 2;
		Citizen[] temp = Arrays.copyOf(pinkasBoharim, citiPhysSize);
		pinkasBoharim = temp;
	}

	public boolean addPoliticalParty(PoliticalParty newPoliticalParty) {
		for (int i = 0; i < partyLogiSize; i++) {// checks if party already exist on elections
			if (partysList[i].equals(newPoliticalParty))
				return false;
		}
		if (partyLogiSize == partyPhysSize)
			allocatePoliticalPartyPhysSize();
		partysList[partyLogiSize] = newPoliticalParty;
		partyLogiSize++;
		return true;
	}

	private void allocatePoliticalPartyPhysSize() {
		partyPhysSize = partyPhysSize * 2;
		PoliticalParty[] temp = Arrays.copyOf(partysList, partyPhysSize);
		partysList = temp;
	}

	public boolean addCandidate(String identityNumber, String nameOfParty) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		for (int i = 0; i < citiLogiSize; i++) {
			if (pinkasBoharim[i].getIdentityNumber() == identityNumber) {
				if (!(pinkasBoharim[i] instanceof Candidate))// cant be already candidate
					for (int j = 0; j < partyLogiSize; j++) {
						if (partysList[j].getNameOfParty().equalsIgnoreCase(nameOfParty)) {
							pinkasBoharim[i] = new Candidate(pinkasBoharim[i], partysList[j]);
							partysList[j].addCandidate((Candidate) pinkasBoharim[i]);
							return true;
						}
					}
			}
		}
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
			if (i == kalphiLogiSize)
				i = 0;
		}
	}

	private void primaries() {
		for (int i = 0; i < partyLogiSize; i++) {
			partysList[i].primaries();
		}
	}

	public void electionsRound() {
		electionsResults = new int[partyLogiSize];
		primaries();
		for (int i = 0; i < kalphiLogiSize; i++) {
			kalphiList[i].setVotingCount(partyLogiSize);// sync parties list with kalphies
			kalphiList[i].Vote();
			for (int j = 0; j < partyLogiSize; j++) {
				electionsResults[j] += kalphiList[i].getVotingCount(j);
			}
		}
		for (int i = electionsResults.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (electionsResults[j] < electionsResults[j + 1]) {
					PoliticalParty temp = partysList[j];
					int tempInt = electionsResults[j];
					partysList[j] = partysList[j + 1];
					electionsResults[j] = electionsResults[j + 1];
					partysList[j + 1] = temp;
					electionsResults[j + 1] = tempInt;

				}
			}
		}
		electionsDate = LocalDate.now();
		elected = true;
	}

	public void kalphiResult() {
		System.out.println("On the elections that run on " + this.electionsDate + "the results  are:");
		for (int i = 0; i < kalphiLogiSize; i++) {
			System.out.println("***********************************************************************");
			System.out.println("In " + kalphiList[i].getClass().getSimpleName() + " on "
					+ kalphiList[i].getKalphiAddress() + " The results are:");
			System.out.println("Total voters: " + kalphiList[i].getNumOfVoters());
			System.out.printf("Votes percetanage: %.2f%% \n", kalphiList[i].getVotingPercentage());
			for (int j = 0; j < partyLogiSize; j++) {
				System.out.println(partysList[j].getNameOfParty() + ": " + kalphiList[i].getVotingCount(j));
			}
		}
		System.out.println("*****************");
		System.out.println("Total Votes:");
		for (int j = 0; j < partyLogiSize; j++) {
			System.out.println(partysList[j].getNameOfParty() + ": " + electionsResults[j]);
		}
		System.out
				.println(partysList[0].getNameOfParty() + " party won, running by " + partysList[0].getCandidateName());
		System.out.println("*****************");

	}

	public void showCitizens() {
		for (int i = 0; i < citiLogiSize; i++)
			System.out.println(pinkasBoharim[i]);
	}

	public void showPartysList() {
		for (int i = 0; i < partyLogiSize; i++)
			System.out.println(partysList[i]);
	}

	public void showKalphiList() {
		for (int i = 0; i < kalphiLogiSize; i++)
			System.out.println(kalphiList[i]);
	}

	public Kalphi GetKalphi(int kalphiID) {
		if (kalphiList[kalphiID] instanceof CoronaKalphi)
			return (CoronaKalphi) kalphiList[kalphiID];
		if (kalphiList[kalphiID] instanceof MilitaryKalphi)
			return (MilitaryKalphi) kalphiList[kalphiID];

		return kalphiList[kalphiID];
	}

	public boolean getElected() {
		return elected;
	}

	public boolean equals(Elections elections) {
		if (!(elections.electionsDate.equals(this.electionsDate)))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String boharim = "";
		for (int i = 0; i < citiLogiSize; i++) {
			boharim += pinkasBoharim[i];
		}
		String kalphis = "";
		for (int i = 0; i < kalphiLogiSize; i++) {
			kalphis += kalphiList[i];
		}
		String parties = "";
		for (int i = 0; i < partyLogiSize; i++) {
			parties += partysList[i];
		}
		return String.format(
				"Elections round:\n" + "Voters List:\n %s " + "\nPartys List:\n %s \n" + "\nKalphi List:\n %s \n",
				boharim, parties, kalphis);
	}

}
