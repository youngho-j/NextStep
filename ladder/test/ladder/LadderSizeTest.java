package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

import core.NaturalNumber;

public class LadderSizeTest {

	@Test
	public void testGetPositionOfPerson() throws Exception {
		LadderSize size = LadderSize.create(3, 4);
		NaturalNumber actual = size.getPositionOfPerson(new NaturalNumber(5));
		assertEquals(new NaturalNumber(1), actual);
		// 1  2  3  4
		// 5  6  7  8 -> 5번 좌표 2번째 줄의 `첫번째 위치` 
		// 9 10 11 12
	}
	
	@Test
	public void testGetPositionOfHeight() throws Exception {
		LadderSize size = LadderSize.create(3, 4);
		NaturalNumber actual = size.getPositionOfHeight(new NaturalNumber(5));
		assertEquals(new NaturalNumber(2), actual);
		// 1  2  3  4
		// 5  6  7  8 -> 5번 좌표 `2번째 줄`의 첫번째 위치 
		// 9 10 11 12
	}
	
	@Test
	public void testConvertTotalPositionsToPosition() throws Exception {
		LadderSize size = LadderSize.create(3, 4);
		Position actual = size.getPosition(new NaturalNumber(5));
		assertEquals(Position.create(2, 1), actual);
		// 1  2  3  4
		// 5  6  7  8 -> 5번 좌표 `2번째 줄`의 `첫번째` 위치 
		// 9 10 11 12
	}
}
