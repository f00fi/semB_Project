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
			case 3:
				addPoliticalParty(elections, input);
				break;
			case 4:
				addCandidate(elections, input);
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
		System.out.println(" 3  - New Political Party");
		System.out.println(" 4 -  New candidate");
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
		boolean added;
		System.out.println("Please enter "
				+ (kalphiType == 1 ? "kalphi " : kalphiType == 2 ? "corona " : kalphiType == 3 ? "millitary " : "")
				+ "kalphi address");
		added = elections.addKalphi(kalphiType, input.next());
		System.out.println(added == true ? "Kalphi added" : "failed to add kalphi");
	}

	private static void addCitizen(Elections elections, Scanner input) {
		boolean added;
		System.out.println("Plese fill citizen details in this order");
		System.out.println("Name, identityNumber ,year of birth, does he in isolation(true,false)");
		added = elections.addCitizen(new Citizen(input.next(), input.nextInt(), input.nextInt(), input.nextBoolean()));
		System.out.println(added == true ? "Citzen added" : "failed to add citizen");

	}

	public static void addPoliticalParty(Elections elections, Scanner input) {
		boolean added;
		System.out.println("plese fill PoliticalParty details in this order");
		System.out.println("name, political Orientation (left,center,right), the PartyFounding Date (year,month,day)");
		added = elections.addPoliticalParty(
				new PoliticalParty(input.next(), PoliticalParty.ePoliticalOrientation.valueOf(input.next()),
						LocalDate.of(input.nextInt(), input.nextInt(), input.nextInt())));
		System.out.println(added == true ? "Party added" : "failed to add party");
	}

	public static void addCandidate(Elections elections, Scanner input) {
		System.out.println("plese entar identity number and political Party name ");
		elections.addCandidate(input.nextInt(), input.next());
	}

	public static Elections hardCoded() {
		// 5 citizens
		Citizen eddie = new Citizen("Eddie", 3835693, 1992, true);
		Citizen omer = new Citizen("Omer", 45425, 1994, false);
		Citizen dor = new Citizen("Dor", 24545, 1998, false);
		Citizen lior = new Citizen("Lior", 454545, 1992, true);
		Citizen shahaf = new Citizen("Shahaf", 425542, 1994, false);
		// 3 Parties
		PoliticalParty yemin = new PoliticalParty("Yemin", PoliticalParty.ePoliticalOrientation.right,
				LocalDate.of(2020, 04, 20));
		PoliticalParty mercas = new PoliticalParty("Mercas", PoliticalParty.ePoliticalOrientation.center,
				LocalDate.of(2020, 04, 20));
		PoliticalParty small = new PoliticalParty("Small", PoliticalParty.ePoliticalOrientation.left,
				LocalDate.of(2020, 04, 20));
		// 6 candidates
		Candidate bibi = new Candidate("Benyamin", 1, 1960, false, yemin);
		Candidate gantz = new Candidate("Gantz", 2, 1994, false, yemin);
		Candidate mia = new Candidate("Mia", 3, 1985, false, small);
		Candidate ariel = new Candidate("Ariel", 4, 1992, true, small);
		Candidate lapid = new Candidate("Lapid", 5, 1985, false, mercas);
		Candidate merav = new Candidate("Merav", 6, 1992, true, mercas);

		Elections elections = new Elections();
		elections.addKalphi(1, "Tel Aviv 1");
		elections.addKalphi(2, "Kfar Yona 2");
		elections.addKalphi(3, "Hell 3");
		elections.addCitizen(shahaf);
		elections.addCitizen(eddie);
		elections.addCitizen(lior);
		elections.addCitizen(omer);
		elections.addCitizen(dor);
		elections.addCitizen(bibi);
		elections.addCitizen(gantz);
		elections.addCitizen(mia);
		elections.addCitizen(ariel);
		elections.addCitizen(lapid);
		elections.addCitizen(merav);
		elections.addPoliticalParty(yemin);
		elections.addPoliticalParty(mercas);
		elections.addPoliticalParty(small);
		elections.addCandidate(1, yemin.getNameOfParty());
		elections.addCandidate(2, yemin.getNameOfParty());
		elections.addCandidate(3, small.getNameOfParty());
		elections.addCandidate(4, small.getNameOfParty());
		elections.addCandidate(5, mercas.getNameOfParty());
		elections.addCandidate(6, mercas.getNameOfParty());


		return elections;
	}

	public static void main(String[] args) {
		Elections elections = hardCoded();
		System.out.println(elections.toString());

//		electionRound(elections);
	}
}
