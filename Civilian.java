package election;

public class Civilian {

	protected String name;
	protected int id;
	protected int yearOfBirth;
	protected Kalphi votingKalphi;
	protected boolean isIsolated;

	public Civilian(String name, int id, int yearOfBirth, Kalphi votingKalphi, boolean isIsolated) {
		this.name = name;
		this.id = id;
		this.yearOfBirth = yearOfBirth;
		this.votingKalphi = votingKalphi;
		this.isIsolated = isIsolated;
	}

	@Override
	public String toString() {
		return "Civilian [name=" + name + ", id=" + id + ", yearOfBirth=" + yearOfBirth + ", isIsolated=" + isIsolated
				+ "]";
	}

}
