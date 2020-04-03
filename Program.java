package Election;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {

	public static void electionRound(Elections elections) {
		Scanner input = new Scanner(System.in);
		int menuChoice = 0;
		int inMenuChoice = 0;
		while (menuChoice != -1) {
			System.out.println(("Please choose your action \n " + " 1 - New kalphi  \n -1 - exit enter"));
			menuChoice = input.nextInt();
			switch (menuChoice) {
			case 1:
				System.out.println("Choose type of Kalphi \n " + "1 - Regular Kalphi  \n " + "2 - Corona kalphi  \n"
						+ " 3 - Military Kalphi  \n " + "-1  return to menu");
				inMenuChoice = input.nextInt();
				switch (inMenuChoice) {
				case 1:
					System.out.println("Please enter Kalphi address");
					elections.addKalphi(new Kalphi(input.next()));
					break;
				case 2:
					System.out.println("Please enter Corona Kalphi address");
					elections.addKalphi(new CoronaKalphi(input.next()));
					break;
				case 3:
					System.out.println("Please enter Military Kalphi address");
					elections.addKalphi(new MilitaryKalphi(input.next()));
				case -1:
					break;
				}
			case 2:
				break;
			}
//			case -1:
//				System.out.println("have a great day");
//				menuChoice = -1;
//				break;

		}

	}

	public static void main(String[] args) {
		// Hard coded - 5 citizens ,3 parties ,2 candidates for each party
		// and 2 kalphies
		Kalphi kalphiTelAviv = new Kalphi("Tel Aviv 1");
		Kalphi kalphiKfarYona = new Kalphi("Kfar Yona 1");
		Kalphi[] kalphi = new Kalphi[2];
		kalphi[0] = kalphiTelAviv;
		kalphi[1] = kalphiKfarYona;
		// 5 citizens
		Citizen eddie = new Citizen("Eddie", 1, 1992, kalphiTelAviv, true);
		Citizen omer = new Citizen("Omer", 2, 1994, kalphiKfarYona, false);
		Citizen dor = new Citizen("Dor", 2, 1998, kalphiTelAviv, false);
		Citizen lior = new Citizen("Lior", 2, 1992, kalphiTelAviv, true);
		Citizen shahaf = new Citizen("Shahaf", 2, 1994, kalphiKfarYona, false);
		// 3 Parties
		PoliticalParty yemin = new PoliticalParty("Yemin", "Yemin", LocalDate.of(2020, 04, 20));
		PoliticalParty mercas = new PoliticalParty("Mercas", "Mercas", LocalDate.of(2020, 04, 20));
		PoliticalParty small = new PoliticalParty("Small", "Small", LocalDate.of(2020, 04, 20));
		// 6 candidates
		Candidate bibi = new Candidate("Benyamin", 1, 1960, kalphiTelAviv, false, yemin);
		Candidate gantz = new Candidate("Gantz", 2, 1994, kalphiKfarYona, false, yemin);
		Candidate mia = new Candidate("Mia", 2, 1985, kalphiTelAviv, false, small);
		Candidate ariel = new Candidate("Ariel", 2, 1992, kalphiTelAviv, true, small);
		Candidate lapid = new Candidate("Lapid", 2, 1985, kalphiTelAviv, false, mercas);
		Candidate merav = new Candidate("Merav", 2, 1992, kalphiTelAviv, true, mercas);

		Elections elections = new Elections(11, 3, 2);
		for (int i = 0; i < 2; i++) {
			elections.addKalphi(kalphi[i]);
		}
		System.out.println(elections.toString());
		electionRound(elections);
		elections.showKalphiList();
		System.out.println(omer);
	}
}
