package ch.zhaw.ads.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch.zhaw.ads.services.SearchNumber;

public class SearchNumberTest {

	@Test
	public void testNumberFound() throws Exception {
		SearchNumber e = new SearchNumber();
		String input = "4,8,15,16,23,42,15";
		String result = e.execute(input);
		assertTrue(result.contains("3"));
	}
	
	@Test
	public void testUnderNumberNotFound() throws Exception {
		SearchNumber e = new SearchNumber();
		String input = "4,8,15,16,23,42,1";
		String result = e.execute(input);
		assertTrue(result.contains("Zahl nicht vorhanden!"));
	}
	@Test
	public void testOverNumberNotFound() throws Exception {
		SearchNumber e = new SearchNumber();
		String input = "4,8,15,16,23,42,108";
		String result = e.execute(input);
		assertTrue(result.contains("Zahl nicht vorhanden!"));
	}
	
	@Test (expected = NumberFormatException.class)
	public void testWrongFormat() throws Exception {
		SearchNumber e = new SearchNumber();
		String input = "4,8,15,16,23;42,15";
		e.execute(input);
	}
	
}
