package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class NaturalNumberTest {

	@Test
	public void testCreate() throws Exception {
		NaturalNumber number = new NaturalNumber(1);
		assertEquals(1, number.getNumber());
	}
	
	@Test
	public void testCreateWhenUnderZero() throws Exception {
		try {
			new NaturalNumber(0);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testToArrayIndex() throws Exception {
		NaturalNumber number = new NaturalNumber(3);
		assertEquals(2, number.toArrayIndex());
	}
}