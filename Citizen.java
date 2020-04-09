package Election;

public class Citizen {

	protected String name;
	protected int identityNumber;
	protected int yearOfBirth;
	protected Kalphi votingKalphi;
	protected boolean isIsolated;

	public Citizen(String name, int identityNumber, int yearOfBirth, boolean isIsolated) {
		this.name = name;
		this.identityNumber = identityNumber;
		this.yearOfBirth = yearOfBirth;
		this.isIsolated = isIsolated;
	}

	public Citizen(String name, int identityNumber, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated) {
		this.name = name;
		this.identityNumber = identityNumber;
		this.yearOfBirth = yearOfBirth;
		this.votingKalphi = votingKalphi;
		this.isIsolated = isIsolated;
	}

	public Citizen(Citizen newCitizen) {
		this(newCitizen.name, newCitizen.identityNumber, newCitizen.yearOfBirth, newCitizen.votingKalphi,
				newCitizen.isIsolated);
	}

	public int getIdentityNumber() {
		return identityNumber;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n Identity number:" + identityNumber + "\n Year of birth: " + yearOfBirth
				+ "\n Is isolated: " + (isIsolated == true ? "Yes\n" : "No\n");
	}

}
