package Election;

import java.time.LocalDate;

public class Citizen {

	protected String name;
	protected String identityNumber;
	protected int yearOfBirth;
	protected Kalphi votingKalphi;
	protected boolean isIsolated;

	public Citizen(String name, String identityNumber, int yearOfBirth, boolean isIsolated)
			throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		this.name = name;
		setIdentityNumber(identityNumber);
		setYearOfBirth(yearOfBirth);
		this.isIsolated = isIsolated;
	}

	public Citizen(String name, String identityNumber, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated)
			throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		this.name = name;
		setIdentityNumber(identityNumber);
		setYearOfBirth(yearOfBirth);
		this.votingKalphi = votingKalphi;
		this.isIsolated = isIsolated;
	}

	public Citizen(Citizen newCitizen) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		this(newCitizen.name, newCitizen.identityNumber, newCitizen.yearOfBirth, newCitizen.votingKalphi,
				newCitizen.isIsolated);
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public boolean equals(Citizen newCitizen) {
		if (identityNumber == newCitizen.identityNumber)
			return true;
		return false;
	}

	public void setIdentityNumber(String identityNumber) throws notNineNumException, notAllNumExcepiton {
		if (identityNumber.length() != 9) {
			throw new notNineNumException();
		}
		for (int i = 0; i < identityNumber.length(); i++) {

			if (!Character.isDigit(identityNumber.charAt(i))) {
				throw new notAllNumExcepiton();
			}

		}

		this.identityNumber = identityNumber;

	}

	public void setYearOfBirth(int yearOfBirth) throws notValidAgeExceptions  {
		int thisYear=LocalDate.now().getYear();
		if(!(thisYear-yearOfBirth>=(thisYear- (thisYear-18)))) {
		
			throw new notValidAgeExceptions();	
		}
		
		else
		this.yearOfBirth = yearOfBirth;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\n Identity number:" + identityNumber + "\n Year of birth: " + yearOfBirth
				+ "\n Is isolated: " + (isIsolated == true ? "Yes\n" : "No\n");
	}

}
