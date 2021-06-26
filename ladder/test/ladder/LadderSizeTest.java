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
	public void testGetPositionOfPerson() throws Exception {
		NaturalNumber actual = size.getPositionOfPerson(new NaturalNumber(5));
		assertEquals(new NaturalNumber(1), actual);
		// 1  2  3  4
		// 5  6  7  8 -> 5번 좌표 2번째 줄의 `첫번째 위치` 
		// 9 10 11 12
	}
	
	@Test
	public void testGetPositionOfHeight() throws Exception {
		NaturalNumber actual = size.getPositionOfHeight(new NaturalNumber(5));
		assertEquals(new NaturalNumber(2), actual);
		// 1  2  3  4
		// 5  6  7  8 -> 5번 좌표 `2번째 줄`의 첫번째 위치 
		// 9 10 11 12
	}
	
	@Test
	public void testConvertTotalPositionsToPosition() throws Exception {
		Position actual = size.getPosition(new NaturalNumber(5));
		assertEquals(Position.create(2, 1), actual);
		// 1  2  3  4
		// 5  6  7  8 -> 5번 좌표 `2번째 줄`의 `첫번째` 위치 
		// 9 10 11 12
	}
	
	@Test
	public void testIsMultipleOfPerson() throws Exception {
		assertTrue(size.isMultipleOfPerson(new NaturalNumber(8)));
		assertFalse(size.isMultipleOfPerson(new NaturalNumber(7)));
	}
}
