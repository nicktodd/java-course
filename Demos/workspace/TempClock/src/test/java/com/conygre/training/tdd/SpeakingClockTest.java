package com.conygre.training.tdd;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class SpeakingClockTest {

	// fixture
	private SpeakingClock clock;
	
	@Before
	public void setup() {
		clock = new SpeakingClock();
	}
	
	@Test
	public void testCanDoMidnight() {
		String actual  = clock.toText(LocalTime.MIDNIGHT);
		assertEquals("Midnight", actual);
	}
	
	@Test
	public void testCanDoMidday() {
		String actual  = clock.toText(LocalTime.NOON);
		assertEquals("Midday", actual);
	}
	
	
}
