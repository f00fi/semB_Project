package election;

import java.time.LocalDate;

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

	}

}
