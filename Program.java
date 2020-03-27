package election;

public class Program {

	public static void main(String[] args) {
		Kalphi k1 = new Kalphi("tel aviv 1");
		Civilian c1 = new Civilian("pini", 123, 1992,k1,false);
		System.out.println(k1);
		System.out.println(c1);
		

	}

}
