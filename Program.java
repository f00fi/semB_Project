package Election;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {

	public static void electionRound(Elections elections) {
		Scanner input = new Scanner(System.in);
		int menuChoice = 0;
		int kalphiType = 0;
		while (menuChoice != -1) {
			printMenuChoices();
			menuChoice = input.nextInt();
			switch (menuChoice) {
			case 1:
				printKalphiesTypes();
				chooseKalphiType(elections, input.nextInt(), input);
			case 2:
				break;
			case -1:
				System.out.println("Cya in 3 months (;");
				menuChoice = -1;
				break;
			}
		}
	}

	public static void printMenuChoices() {
		System.out.println("Please choose your action");
		System.out.println(" 1  - New kalphi");
		System.out.println(" 2  - New citizen");
		System.out.println("-1  - Exit");
	}

	public static void printKalphiesTypes() {
		System.out.println("Choose type of Kalphi");
		System.out.println(" 1 - Regular Kalphi");
		System.out.println(" 2 - Corona kalphi");
		System.out.println(" 3 - Military Kalphi");
	}

	public static void chooseKalphiType(Elections elections, int kalphiType, Scanner address) {
		System.out.println("Please enter "
				+ (kalphiType == 1 ? "kalphi " : kalphiType == 2 ? "corona " : kalphiType == 3 ? "millitary " : "")
				+ "kalphi address");
		elections.addKalphi(kalphiType, address.next());
	}

	public static void main(String[] args) {
		// Hard coded - 5 citizens ,3 parties ,2 candidates for each party
		// and 2 kalphies
		// Kalphi kalphiTelAviv = new Kalphi("Tel Aviv 1");
		// Kalphi kalphiKfarYona = new Kalphi("Kfar Yona 1");
		// 5 citizens
//		Citizen eddie = new Citizen("Eddie", 1, 1992, kalphiTelAviv, true);
//		Citizen omer = new Citizen("Omer", 2, 1994, kalphiKfarYona, false);
//		Citizen dor = new Citizen("Dor", 2, 1998, kalphiTelAviv, false);
//		Citizen lior = new Citizen("Lior", 2, 1992, kalphiTelAviv, true);
//		Citizen shahaf = new Citizen("Shahaf", 2, 1994, kalphiKfarYona, false);
		// 3 Parties
		PoliticalParty yemin = new PoliticalParty("Yemin", "Yemin", LocalDate.of(2020, 04, 20));
		PoliticalParty mercas = new PoliticalParty("Mercas", "Mercas", LocalDate.of(2020, 04, 20));
		PoliticalParty small = new PoliticalParty("Small", "Small", LocalDate.of(2020, 04, 20));
		// 6 candidates
//		Candidate bibi = new Candidate("Benyamin", 1, 1960, kalphiTelAviv, false, yemin);
//		Candidate gantz = new Candidate("Gantz", 2, 1994, kalphiKfarYona, false, yemin);
//		Candidate mia = new Candidate("Mia", 2, 1985, kalphiTelAviv, false, small);
//		Candidate ariel = new Candidate("Ariel", 2, 1992, kalphiTelAviv, true, small);
//		Candidate lapid = new Candidate("Lapid", 2, 1985, kalphiTelAviv, false, mercas);
//		Candidate merav = new Candidate("Merav", 2, 1992, kalphiTelAviv, true, mercas);

		Elections elections = new Elections(11, 3, 2);
		elections.addKalphi(1, "Tel Aviv 1");
		elections.addKalphi(2, "Kfar Yona 2");
		elections.addKalphi(3, "Kfar Yona 3");
		System.out.println(elections.toString());
		electionRound(elections);
		elections.showKalphiList();

	}
}
