public class RainFall {
	
	private String date;
	private double rainInInches;
	
	public RainFall(String date, double rainInInches) {
		super();
		this.date = date;
		this.rainInInches = rainInInches;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getRainInInches() {
		return rainInInches;
	}

	public void setRainInInches(double rainInInches) {
		this.rainInInches = rainInInches;
	}

	@Override
	public String toString() {
		return "RainFall [date=" + date + ", rainInInches=" + rainInInches
				+ "]";
	}

}
