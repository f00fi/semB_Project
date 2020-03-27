package election;

import java.util.Arrays;

public class Kalphi {
	protected int id;
	private static int idCounter = 0;
	protected String kalphiAddress;
	protected Civilian[] eliglbleCitizens;
	protected double votingPercentage;
	protected int[] votingCount;

	public Kalphi(String kalphiAddress) {
		this.id = idCounter++;
		this.kalphiAddress = kalphiAddress;
		this.eliglbleCitizens = new Civilian[10];// לבדוק מה עושים עם זה (משתנה)
	}

	@Override
	public String toString() {
		return "Kalphi [id=" + id + ", kalphiAddress=" + kalphiAddress + ", eliglbleCitizens="
				+ Arrays.toString(eliglbleCitizens) + ", votingPercentage=" + votingPercentage + ", votingCount="
				+ Arrays.toString(votingCount) + "]";
	}

}
