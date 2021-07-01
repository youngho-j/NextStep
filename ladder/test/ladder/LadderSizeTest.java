package ladder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.NaturalNumber;

public class LadderSizeTest {
	
	private LadderSize size;
	
	@Before
	public void setUp() throws Exception {
		size = LadderSize.create(3, 4);
	}
	
	@Test
	public void testIsMultipleOfPerson() throws Exception {
		assertTrue(size.isMultipleOfPerson(new NaturalNumber(8)));
		assertFalse(size.isMultipleOfPerson(new NaturalNumber(7)));
	}
}
