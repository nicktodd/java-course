import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;


public class DateTimeTest {
	
	public static void main(String[] args) {
		
		
		LocalDate today = LocalDate.now();
		Month currentMonth = today.getMonth();
		DayOfWeek day = today.getDayOfWeek();
		int currentYear = today.getYear();
		int dayOfMonth = today.getDayOfMonth();
				
		LocalDate christmasDay = LocalDate.of(2015, 12,25);
		
		
		if (today.isBefore(christmasDay)) {
			System.out.println("It's not Christmas yet");
		}
		
		
		LocalDateTime now = LocalDateTime.now();
		
	
		int hourOfDay = now.getHour();
		int minutesOfHour = now.getMinute();
		
		LocalDateTime christmas = LocalDateTime.of(2015,12, 25, 0, 0);
		
		long daysUntilChristmas = ChronoUnit.DAYS.between(now, christmas);
		
		System.out.println(daysUntilChristmas);
		
		
		LocalTime time  = LocalTime.now();
		
		
		
		
		ZonedDateTime todayWithZone = ZonedDateTime.now();
		ZoneOffset offset = ZoneOffset.of("-05:00");
		ZonedDateTime todayInUSEastern = todayWithZone.withZoneSameInstant(offset);
		
		System.out.println("The time in NYC is " + todayInUSEastern.getHour() + ":" + todayInUSEastern.getMinute());

		
		ZoneId id = ZoneId.of("Europe/Paris");
        ZonedDateTime zoned = ZonedDateTime.of(LocalDateTime.now(), id);
        
        OffsetTime time2 = OffsetTime.now();
        
     // changes offset, whilst keeping the same point on the timeline
        OffsetTime sameTimeDifferentOffset = time2.withOffsetSameInstant(offset);
        
        // changes the offset, and updates the point on the timeline
        OffsetTime changeTimeWithNewOffset = time2.withOffsetSameLocal(offset);
        
        
        
		
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        
        
	}

}
