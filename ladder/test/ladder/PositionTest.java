package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

import core.NaturalNumber;

public class PositionTest {
	
	@Test
	public void testCreate() throws Exception {
		Position p1 = Position.create(new NaturalNumber(3), new NaturalNumber(4));
		Position p2 = Position.create(3, 4);
		
		assertEquals(p1, p2);
	}
	
	@Test
	public void testCreateFromArrayIndex() throws Exception {
		Position arrayPosition = Position.createFromArrayIndex(2,3);
		Position position = Position.create(3, 4);
		
		assertEquals(arrayPosition, position);
	}
}
