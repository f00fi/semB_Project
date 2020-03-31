package Election;

public class MilitaryKalphi extends Kalphi {

	
	public MilitaryKalphi(String kalphiAddress) {
		super(kalphiAddress);
		this.id=idCounter++;
	}
	public MilitaryKalphi(MilitaryKalphi militaryKalphi) {
		super(militaryKalphi);
		this.id=idCounter++;

	}

}
