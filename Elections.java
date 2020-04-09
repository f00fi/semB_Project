package Election;

import java.time.LocalDate;
import java.util.Arrays;

public class Elections {

	private Citizen[] pinkasBoharim;
	private int citiLogiSize;
	private int citiPhysSize;
	private PoliticalParty[] partysList;
	private int partyLogiSize;
	private int partyPhysSize;
	private Kalphi[] kalphiList;
	private int kalphiLogiSize;
	private int kalphiPhysSize;

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
		
//		citizen.votingKalphi = 
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

}
