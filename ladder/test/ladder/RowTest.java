package ladder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RowTest {
	private Row row;
	
	@Before
	public void setUp() throws Exception {
		row = new Row(new NaturalNumber(3));
	}
	
	@Test
	public void testMoveWhenNoLine() throws Exception{
		NaturalNumber target = row.move(new Marker(1));
		assertEquals(1, target.getNumber());
		target = row.move(new Marker(2));
		assertEquals(2, target.getNumber());
	}
	
	@Test
	public void testMoveWhenLineLeft() throws Exception {
		row.drawLine(new NaturalNumber(2));
		assertEquals(2, row.move(new Marker(3)).getNumber());	
	}
	
	@Test
	public void testMoveWhenLineRight() throws Exception {
		row.drawLine(new NaturalNumber(2));
		assertEquals(3, row.move(new Marker(2)).getNumber());
	}
	
	// 테스트시 가능하면 경계 값을 테스트 하는게 좋음
	@Test
	public void testStartPositionWhenMinus() throws Exception {
		try {
			row.drawLine(new NaturalNumber(0));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	@Test
	public void testStartPositionWhenOverNumOfPerson() throws Exception {
		try {
			row.drawLine(new NaturalNumber(3));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	@Test
	public void testDrawLineWhenAlreadyDrawingPoint() throws Exception {
		try {
			row.drawLine(new NaturalNumber(1));
			row.drawLine(new NaturalNumber(2));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	@Test
	public void testMoveWhenStartNumMinus() throws Exception {
		try {
			row.drawLine(new NaturalNumber(1));
			row.move(new Marker(0));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
}
