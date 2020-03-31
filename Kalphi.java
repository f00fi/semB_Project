package Election;

import java.util.Arrays;

public class Kalphi {
	protected int id;
	protected static int idCounter = 0;
	protected String kalphiAddress;
	protected Citizen[] eliglbleCitizens;
	protected double votingPercentage;
	protected int[] votingCount;

	public Kalphi(String kalphiAddress) {
		this.id = idCounter++;
		this.kalphiAddress = kalphiAddress;
		this.eliglbleCitizens = new Citizen[10];// need to change to variable)
	}
	 public Kalphi(Kalphi kalphi) {
		 this.id = idCounter++;
			this.kalphiAddress = kalphiAddress;
			this.eliglbleCitizens = new Citizen[10];
	 
	 }
	@Override
	public String toString() {
		return "Kalphi [id=" + id + ", kalphiAddress=" + kalphiAddress + ", eliglbleCitizens="
				+ Arrays.toString(eliglbleCitizens) + ", votingPercentage=" + votingPercentage + ", votingCount="
				+ Arrays.toString(votingCount) + "]\n		";
	}

}
