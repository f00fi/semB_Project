package Election;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {

	public static void electionRound(Elections elections) {
		Scanner input = new Scanner(System.in);
		int menuChoice = 0;
		while (menuChoice != -1) {
			printMenuChoices();
			menuChoice = input.nextInt();
			switch (menuChoice) {
			case 1:
				printKalphiesTypes();
				chooseKalphiType(elections, input.nextInt(), input);
				break;
			case 2:
				addCitizen(elections, input);
				break;
			case 5:
				elections.showKalphiList();
				break;
			case 6:
				elections.showCitizens();
				break;
			case 7:
				elections.showPartysList();
				break;
			case -1:
				System.out.println("Cya in 3 months (;");
				menuChoice = -1;
				break;
			}
		}
	}

	private static void printMenuChoices() {
		System.out.println("Please choose your action");
		System.out.println(" 1  - New kalphi");
		System.out.println(" 2  - New citizen");
		System.out.println(" 5  - Show kalphies");
		System.out.println(" 6  - Show citizens");
		System.out.println(" 7  - Show parties");
		System.out.println("-1  - Exit");
	}

	private static void printKalphiesTypes() {
		System.out.println("Choose type of Kalphi");
		System.out.println(" 1 - Regular Kalphi");
		System.out.println(" 2 - Corona kalphi");
		System.out.println(" 3 - Military Kalphi");
	}

	private static void chooseKalphiType(Elections elections, int kalphiType, Scanner input) {
		System.out.println("Please enter "
				+ (kalphiType == 1 ? "kalphi " : kalphiType == 2 ? "corona " : kalphiType == 3 ? "millitary " : "")
				+ "kalphi address");
		elections.addKalphi(kalphiType, input.next());
	}

	private static void addCitizen(Elections elections, Scanner input) {
		System.out.println("Plese fill citizen details in this order");
		System.out.println("Name, year of birth, does he in isolation(true,false)");
		elections.addCitizen(new Citizen(input.next(), input.nextInt(), input.nextBoolean()));
	}

	public static void main(String[] args) {
		// Hard coded - 5 citizens ,3 parties ,2 candidates for each party
		// and 2 kalphies
		// 5 citizens
		Citizen eddie = new Citizen("Eddie", 1992, true);
		Citizen omer = new Citizen("Omer", 1994, false);
		Citizen dor = new Citizen("Dor", 1998, false);
		Citizen lior = new Citizen("Lior", 1992, true);
		Citizen shahaf = new Citizen("Shahaf", 1994, false);
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

		Elections elections = new Elections();
		elections.addKalphi(1, "Tel Aviv 1");
		elections.addKalphi(2, "Kfar Yona 2");
		elections.addKalphi(3, "Hell 3");
		System.out.println(elections.toString());
		electionRound(elections);
	}
}
