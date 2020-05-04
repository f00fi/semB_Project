package Election;

public class CoronaCitizen extends Citizen {

	private int sickDays;
	
	
	public CoronaCitizen(Citizen newCitizen,int sickDays) throws notNineNumException, notAllNumExcepiton, notValidAgeExceptions {
		super(newCitizen);
		this.sickDays=sickDays;
	}

}
