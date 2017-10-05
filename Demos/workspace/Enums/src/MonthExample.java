public class MonthExample {
		
	public static void main(String[] args) {
		
		Month currentMonth = Month.February; 
		System.out.println("This month has " + currentMonth.numDays());

		
		switch (currentMonth) {
			case December:
				System.out.println("Christmas soon!");
				break;
			case January:
				System.out.println("Sales begin this month");
				break;
			case February:
				System.out.println("Romance in the air for valentines");
				break;
			default:
				System.out.println("Not much going on this month");
				break;
		}
		// use the values() method that all enums have
		for ( Month m : Month.values() ) {
			System.out.println(m + ": "
			+ m.numDays() );
			}		
	}
}
