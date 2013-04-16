package ch.zhaw.ads.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.zhaw.ads.services.EchoService;

public class EchoServiceTest {
	@Test
	public void test() {
		EchoService e = new EchoService();
		String input = "dies ist ein Test";
		String result = e.execute(input);
		assertTrue(result.contains(input));
	}
}
