import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class TestTimeToText {

	private TimeToText cut;
	
	@Before
	public void setup() {
		 cut = new TimeToText();
	}
	
	@Test
	public void canDoMidnight() {
		String actual = cut.getTimeAsText(LocalTime.MIDNIGHT);
		assertEquals("Midnight should be returned", "midnight", actual);
	}
	
	@Test
	public void canDo1AM() {
		String actual = cut.getTimeAsText(LocalTime.of(1,0,0,0));
		assertEquals("1AM should be returned", "one o'clock in the morning", actual);
	}

}
