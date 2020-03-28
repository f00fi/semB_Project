package Election;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Kalphi k1 = new Kalphi("tel aviv 1");
		Civilian c1 = new Civilian("pini", 123, 1992, k1, false);
		LocalDate releaseDate = LocalDate.of(2020, 04, 20);
		PoliticalParty theWorldIsOurs = new PoliticalParty("omerIsOurKing", "motherEarth", releaseDate);
		System.out.println(k1);
		System.out.println(c1);
		c1 = new Candidate(c1, theWorldIsOurs);
		System.out.println(c1);

		Scanner input = new Scanner(System.in);

		int choice = 0;
		while (choice != -1) {
			System.out.println(("Enter your choice of exe \n " + "for new kalphi enter 1 \n " + "for exit enter -1 "));
			choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your choice of exe \n " + "for new kalphi enter 1 \n "
						+ "for new Corona kalphi  enter 2 \n"+"for Military Kalphi enter 3 \n" );
				switch (choice) {
				case 1:
					Kalphi newKalphi = new Kalphi("pini1");
					break;
				}
			case 2:

				CoronaKalphi newKalphi = new CoronaKalphi("pini2");
				break;

			case 3:
				MilitaryKalphi newKalphi1 =new MilitaryKalphi("pini3");
			
			
			case -1:
				System.out.println("have a great day");
				choice = -1;

				break;

			
				
				
			}

		}
	}
}
