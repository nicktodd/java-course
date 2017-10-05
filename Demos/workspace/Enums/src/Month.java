public enum Month {
	// these are like constructor calls
	January(31), February(28), March(31),
	October(31), November(30), December(31);

	private int daysInMonth; // property
	
	private Month ( int d ) { // constructor
		daysInMonth = d;
	}
	public int numDays() { // method
		return daysInMonth;
	}
}