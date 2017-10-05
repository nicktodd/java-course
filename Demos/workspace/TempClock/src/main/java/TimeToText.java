import java.time.LocalTime;

public class TimeToText {

	public String getTimeAsText(LocalTime time) {
		if (time.getHour() ==0 && time.getMinute() == 0) {
			return "midnight";
		}
		else return null;
	}

}
