//Eddie Abramov 307947655 
//Omer Ichay 204308886
package Election;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Program {
	public static void electionRound(Elections elections) throws notAllNumExcepiton, notNineNumException, notValidAgeExceptions {
		Scanner input = new Scanner(System.in);
		int menuChoice = 0;
		boolean isValidInput=false;
		while (menuChoice != 10) {
			printMenuChoices();
			menuChoice = input.nextInt();
			switch (menuChoice) {
			case 1:
				printKalphiesTypes();
				chooseKalphiType(elections, input.nextInt(), input);
				break;
			case 2:
				while(!isValidInput) {
				try {
					addCitizen(elections, input);
					isValidInput=true;
				} catch (notNineNumException e) {
					
					System.out.println(e.getMessage());
				}
				catch (notAllNumExcepiton e) {
					System.out.println(e.getMessage());
				}
				catch(notValidAgeExceptions e) {
					System.out.println(e.getMessage());
				}
				}	
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
			case 8:
				elections.electionsRound();
				System.out.println("*********************************************************************");
				System.out.println("Congradualtions! press 9 to show elections result");
				System.out.println("*********************************************************************");
				break;
			case 9:
				if (elections.getElected()) {
					elections.kalphiResult();

				} else {
					System.out.println("***************************");
					System.out.println("We didnt have elections yet");
					System.out.println("***************************");
				}
				break;
			case 10:
				System.out.println("Cya in 3 months (;");
				menuChoice = 10;
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
		System.out.println(" 8  - Elections");
		System.out.println(" 9  - Show results");
		System.out.println(" 10 - Exit");
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
				+ (kalphiType == 1 ? "kalphi "
						: kalphiType == 2 ? "corona kalphi" : kalphiType == 3 ? "millitary kalphi" : "")
				+ " address (one word no spaces)");
		added = elections.addKalphi(kalphiType, input.next());
		System.out.println(added == true ? "Kalphi added" : "failed to add kalphi");
	}

	private static void addCitizen(Elections elections, Scanner input)throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		boolean added;
		System.out.println("Plese fill citizen details in this order");
		System.out.println("Name, identityNumber ,year of birth, does he in isolation(true,false)");
		added = elections.addCitizen(new Citizen(input.next(), input.next(), input.nextInt(), input.nextBoolean()));
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

	public static void addCandidate(Elections elections, Scanner input) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		System.out.println("plese entar identity number and political Party name ");
		if (elections.addCandidate(input.next(), input.next()))
			System.out.println("candidate added");
		else
			System.out.println("could not add candidate");
	}
//
//	public static void fillRandom(Elections elections) {
//		int type, age, numOfCitizens, numOfKalphies;
//		numOfCitizens = ThreadLocalRandom.current().nextInt(0, 1000);
//		numOfKalphies = ThreadLocalRandom.current().nextInt(1, 40);
//		Boolean isInBidud;
//		for (int i = 4; i < numOfKalphies; i++) {
//			type = ThreadLocalRandom.current().nextInt(1, 4);
//			elections.addKalphi(type, "Random Kalphi_" + i);
//		}
//		for (int i = 12; i < numOfCitizens; i++) {
//			age = ThreadLocalRandom.current().nextInt(1940, 2003);
//			isInBidud = ThreadLocalRandom.current().nextBoolean();
//			elections.addCitizen(new Citizen("Joe_" + i, i, age, isInBidud));
//		}
//	}

	public static Elections hardCoded()throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		// 5 citizens
		Citizen eddie = new Citizen("Eddie", "123456569", 1992, true);
		Citizen omer = new Citizen("Omer", "123356789", 1994, false);
		Citizen dor = new Citizen("Dor", "122256789", 1998, false);
		Citizen lior = new Citizen("Lior","123456119", 1992, true);
		Citizen shahaf = new Citizen("Shahaf", "123456696", 1994, false);
		// 3 Parties
		PoliticalParty yemin = new PoliticalParty("Yemin", PoliticalParty.ePoliticalOrientation.right,
				LocalDate.of(2020, 04, 20));
		PoliticalParty mercas = new PoliticalParty("Mercas", PoliticalParty.ePoliticalOrientation.center,
				LocalDate.of(2020, 04, 20));
		PoliticalParty small = new PoliticalParty("Small", PoliticalParty.ePoliticalOrientation.left,
				LocalDate.of(2020, 04, 20));
		// 6 candidates
		Citizen bibi = new Citizen("Benyamin", "134456789", 1960, false);
		Citizen gantz = new Citizen("Gantz", "123126789", 1994, false);
		Citizen mia = new Citizen("Mia", "122356789", 1985, false);
		Citizen ariel = new Citizen("Ariel", "123456129", 1992, true);
		Citizen lapid = new Citizen("Lapid", "127856789", 1985, false);
		Citizen meirav = new Citizen("Meirav", "123996789", 1992, true);
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
		elections.addCitizen(meirav);
		elections.addPoliticalParty(yemin);
		elections.addPoliticalParty(mercas);
		elections.addPoliticalParty(small);
		elections.addCandidate("123456789", yemin.getNameOfParty());
		elections.addCandidate("123426789", yemin.getNameOfParty());
		elections.addCandidate("123356789", small.getNameOfParty());
		elections.addCandidate("123486789", small.getNameOfParty());
		elections.addCandidate("923456789", mercas.getNameOfParty());
		elections.addCandidate("423456789", mercas.getNameOfParty());
		return elections;
	}

	public static void main(String[] args) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		Elections elections = hardCoded();// fills with hardcoded data
//		fillRandom(elections); //static function which generates random citizens and random kalphis for testing. 
		electionRound(elections);
	}
}
