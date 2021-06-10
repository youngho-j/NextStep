package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class RowTest {

	@Test
	public void testMoveWhenNoLine() throws Exception{
		Row row = new Row(3);
		assertEquals(0, row.move(0));
		assertEquals(2, row.move(2));
	}
	
	@Test
	public void testMoveWhenLineLeft() throws Exception {
		Row row = new Row(3);
		row.drawLine(1);
		assertEquals(1, row.move(2));	
	}
	
	@Test
	public void testMoveWhenLineRight() throws Exception {
		Row row = new Row(3);
		row.drawLine(1);
		assertEquals(2, row.move(1));
	}
	
	@Test
	public void testNoNumOfPerson() throws Exception {
		try {
			new Row(0);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch(IllegalArgumentException ie) {
			assertTrue(true);
		}
		
	}
	// 테스트시 가능하면 경계 값을 테스트 하는게 좋음
	@Test
	public void testStartPositionWhenMinus() throws Exception {
		try {
			Row row = new Row(3);
			row.drawLine(-1);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	@Test
	public void testStartPositionWhenOverNumOfPerson() throws Exception {
		try {
			Row row = new Row(3);
			row.drawLine(2);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	@Test
	public void testDrawLineWhenAlreadyDrawingPoint() throws Exception {
		try {
			Row row = new Row(3);
			row.drawLine(0);
			row.drawLine(1);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	@Test
	public void testMoveWhenStartNumMinus() throws Exception {
		try {
			Row row = new Row(3);
			row.drawLine(0);
			row.move(-1);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
}
