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
	
}
