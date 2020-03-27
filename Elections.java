package election;

import java.util.Arrays;

//27.03.2020 מחלקת סבב בחירות/omer
public class Elections {

	private Civilian[] pinkasBoharim;
	private PoliticalParty[] partysList;
	private Kalphi[] kalphiList;

	public Elections(int numOfCivilians, int numOfPartys, int numOfKalphys) {// 27.03.2020 בנאי שמקבל כמה אזרחים,מפלגות
																				// וקלפיות/omer
		// צריך לראות אם הגדלים האלה זה מימוש נכון
		pinkasBoharim = new Civilian[numOfCivilians];
		partysList = new PoliticalParty[numOfPartys];
		kalphiList = new Kalphi[numOfPartys];
	}

	//// 27.03.2020 הוספתי מתודות שמדפיסות אזרחים מפלגות וקלפיות//
	public void showCitizens() {

		System.out.println(Arrays.toString(pinkasBoharim));

	}

	public void showPartysList() {
		System.out.println(Arrays.toString(partysList));
	}
	
	public void kalphiList() {
		System.out.println(Arrays.toString(kalphiList));
	}

}
