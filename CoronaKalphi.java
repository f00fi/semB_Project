package Election;

import java.util.Arrays;

public class CoronaKalphi extends Kalphi {

	
	
	public CoronaKalphi(String kalphiAddress) {
		super(kalphiAddress);
		this.id = idCounter++;
	}

	@Override
	public String toString() {
		return "CoronaKalphi [id=" + id + ", kalphiAddress=" + kalphiAddress + ", eliglbleCitizens="
				+ Arrays.toString(eliglbleCitizens) + ", votingPercentage=" + votingPercentage + ", votingCount="
				+ Arrays.toString(votingCount) + "]";
	}

}
