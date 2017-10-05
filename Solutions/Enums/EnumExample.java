import java.util.EnumSet;


public class EnumExample {
	
	enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY }
	
	
	public static void main(String[] args)
	{
		Day today  = Day.SUNDAY;
		
		System.out.println(Day.MONDAY);
		
		
		for (Day current: EnumSet.range(Day.MONDAY, Day.FRIDAY))
		{
			System.out.println(current);
		}	
	}
	

}
