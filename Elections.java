package Election;

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

	public void addKalphi(int type, String address) {
		if (kalphiPhysSize == kalphiLogiSize)
			allocateKalphiLogicSize();
		if (type == 1)
			kalphiList[kalphiPhysSize] = new Kalphi(address);
		if (type == 2)
			kalphiList[kalphiPhysSize] = new CoronaKalphi(address);
		if (type == 3)
			kalphiList[kalphiPhysSize] = new MilitaryKalphi(address);
		kalphiPhysSize++;
	}

	private void allocateKalphiLogicSize() {
		kalphiLogiSize = kalphiLogiSize * 2;
		Kalphi[] temp = Arrays.copyOf(kalphiList, kalphiLogiSize);
		kalphiList = temp;
	}

	public void addCitizen(Citizen newCitizen) {
		if (citiPhysSize == citiLogiSize)
			allocateCitizenLogicSize();
		pinkasBoharim[citiPhysSize] = newCitizen;
		citiPhysSize++;
	}

	private void allocateCitizenLogicSize() {
		citiLogiSize = citiLogiSize * 2;
		Citizen[] temp = Arrays.copyOf(pinkasBoharim, citiLogiSize);
		pinkasBoharim = temp;
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
		String kalphis = "";
		for (int i = 0; i < kalphiList.length; i++) {
			kalphis += kalphiList[i];
		}
		return String.format("Elections round:\n" + "Voters List: %s \n" + "Partys List: %s \n" + "Kalphi List:\n %s \n",
				Arrays.toString(pinkasBoharim), Arrays.toString(partysList) , kalphis);
	}

}
