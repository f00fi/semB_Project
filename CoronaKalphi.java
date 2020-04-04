package Election;

public class CoronaKalphi extends Kalphi {

	public CoronaKalphi(String kalphiAddress) {
		super(kalphiAddress);
	}

	public CoronaKalphi(CoronaKalphi coronaKalphi) {
		super(coronaKalphi);
	}

	@Override
	public String toString() {
		return super.toString();
//		return "CoronaKalphi [id=" + id + ", kalphiAddress=" + kalphiAddress + ", eliglbleCitizens="
//				+ Arrays.toString(eliglbleCitizens) + ", votingPercentage=" + votingPercentage + ", votingCount="
//				+ Arrays.toString(votingCount) + "]";
	}

}
