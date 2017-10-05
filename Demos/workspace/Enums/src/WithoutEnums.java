public class WithoutEnums {

	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	public static final int SUNDAY = 7;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int today = WithoutEnums.MONDAY;
		// could do this, but would be stupid
		today++;
		// and could do this as well
		today  = -1500;
	}
}
