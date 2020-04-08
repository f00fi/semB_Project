package Election;

public class Citizen {

	protected String name;
	protected int identityNumber;
	protected static int idCounter = 1;
	protected int id;
	protected int yearOfBirth;
	protected Kalphi votingKalphi;
	protected boolean isIsolated;

	public Citizen(String name,int identityNumber, int yearOfBirth, boolean isIsolated) {
		this.name = name;
		this.identityNumber=identityNumber;
		this.id = idCounter++;
		this.yearOfBirth = yearOfBirth;
		this.isIsolated = isIsolated;
	}

	public Citizen(String name, int id,int identityNumber, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated) {
		this.name = name;
		this.identityNumber=identityNumber;
		this.id = idCounter++;
		this.yearOfBirth = yearOfBirth;
		this.votingKalphi = votingKalphi;
		this.isIsolated = isIsolated;
	}

	

	public Citizen(Citizen newCitizen) {
		this(newCitizen.name,newCitizen.identityNumber ,newCitizen.id, newCitizen.yearOfBirth, newCitizen.votingKalphi, newCitizen.isIsolated);
	}	

	
	public int getIdentityNumber() {
		return identityNumber;
	}

	@Override
	public String toString() {
		return "Citizen Details:  \n Name: " + name +"\n IdentityNumber:"+identityNumber+ "\n ID: " + id + "\n Year of birth: " + yearOfBirth
				+ "\n Is isolated: " + (isIsolated == true ? "Yes" : "No");
	}

}
