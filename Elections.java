package Election;

import java.util.Arrays;

public class Elections {

	private Citizen[] pinkasBoharim;
	private int numOfCitizens;
	private PoliticalParty[] partysList;
	private int numOfPartys;
	private Kalphi[] kalphiList;
	private int numOfKalphys;

	public Elections(int numOfCitizens, int numOfPartys, int numOfKalphys) {

		pinkasBoharim = new Citizen[numOfCitizens];
		partysList = new PoliticalParty[numOfPartys];
		kalphiList = new Kalphi[numOfPartys];
	}

	// 29.03 - addkalphi method
	public void addKalphi(Kalphi newKalphi) {
		kalphiList[numOfKalphys] = newKalphi;
		numOfKalphys++;
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
