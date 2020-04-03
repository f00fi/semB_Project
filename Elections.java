package Election;

import java.util.Arrays;

public class Elections {

	private Citizen[] pinkasBoharim;
	private int numOfCitizens;
	private int citiLogiSize;
	private int citiPhysSize;
	private PoliticalParty[] partysList;
	private int partyLogiSize;
	private int partyPhysSize;
	private Kalphi[] kalphiList;
	private int kalphiLogiSize;
	private int kalphiPhysSize;

	public Elections(int numOfCitizens, int numOfPartys, int numOfKalphys) {
		citiLogiSize = 15;
		citiPhysSize = 0;
		partyLogiSize = 3;
		partyPhysSize = 0;
		kalphiLogiSize = 3;
		kalphiPhysSize = 0;
		pinkasBoharim = new Citizen[citiLogiSize];
		partysList = new PoliticalParty[partyLogiSize];
		kalphiList = new Kalphi[kalphiLogiSize];
	}

	public void addKalphi(Object newKalphi) {
		if (kalphiPhysSize == kalphiLogiSize) {
			allocateKalphiLogicSize();
		}
		if (newKalphi instanceof Kalphi)
			kalphiList[kalphiPhysSize] = new Kalphi((Kalphi) newKalphi);
		if (newKalphi instanceof CoronaKalphi)
			kalphiList[kalphiPhysSize] = new CoronaKalphi((CoronaKalphi) newKalphi);
		if (newKalphi instanceof MilitaryKalphi)
			kalphiList[kalphiPhysSize] = new MilitaryKalphi((MilitaryKalphi) newKalphi);
		kalphiPhysSize++;
	}

	private void allocateKalphiLogicSize() {
		kalphiLogiSize = kalphiLogiSize * 2;
		Kalphi[] temp = Arrays.copyOf(kalphiList, kalphiLogiSize);
		kalphiList = temp;
	}

	public void addCitizen(Citizen newcitizen) {// need to add size allocate for array like in kalphi
		pinkasBoharim[numOfCitizens] = newcitizen;
		numOfCitizens++;
	}

	public void showCitizens() {
		System.out.println(Arrays.toString(pinkasBoharim));
	}

	public void showPartysList() {
		System.out.println(Arrays.toString(partysList));
	}

	public void showKalphiList() {
		System.out.println(Arrays.toString(kalphiList));
	}

	@Override
	public String toString() {
		return String.format("Elections round:\n" + "Voters List: %s \n" + "Partys List: %s \n" + "Kalphi List: %s \n",
				Arrays.toString(pinkasBoharim), Arrays.toString(partysList), Arrays.toString(kalphiList));
	}

}
