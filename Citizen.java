package Election;

public class Citizen {

	protected String name;
	protected static int idCounter = 1;
	protected int id;
	protected int yearOfBirth;
	protected Kalphi votingKalphi;
	protected boolean isIsolated;

	public Citizen(String name, int yearOfBirth, boolean isIsolated) {
		this.name = name;
		this.id = idCounter++;
		this.yearOfBirth = yearOfBirth;
		this.isIsolated = isIsolated;
	}

	public Citizen(String name, int id, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated) {
		this.name = name;
		this.id = id;
		this.yearOfBirth = yearOfBirth;
		this.votingKalphi = votingKalphi;
		this.isIsolated = isIsolated;
	}

	public Citizen(Citizen newCitizen) {
		this(newCitizen.name, newCitizen.id, newCitizen.yearOfBirth, newCitizen.votingKalphi, newCitizen.isIsolated);
	}	

	@Override
	public String toString() {
		return "Citizen Details:  \n Name: " + name + "\n ID: " + id + "\n Year of birth: " + yearOfBirth
				+ "\n Is isolated: " + (isIsolated == true ? "Yes" : "No");
	}

}
