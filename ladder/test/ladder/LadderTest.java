package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class LadderTest {
	
	@Test
	public void testRunWhenNoLine()  throws Exception {
		Ladder ladder = new Ladder(1, 3);
		int target = ladder.run(0);
		assertEquals(0, target);
	}
	
	@Test
	public void testRunWhenLineLeft() throws Exception {
		// 1 1 0
		Ladder ladder = new Ladder(1, 3);
		ladder.drawLine(0, 1);
		
		int target = ladder.run(2);
		assertEquals(1, target);
		// 0 1 1
		ladder = new Ladder(1, 3);
		ladder.drawLine(0, 1);
		
		target = ladder.run(2);
		assertEquals(1, target);
		
	}
	@Test
	public void testRunWhenLineRight() throws Exception {
		// 0 1 1
		Ladder ladder = new Ladder(1, 3);
		ladder.drawLine(0, 1);
		
		int target = ladder.run(1);
		assertEquals(2, target);
		// 1 1 0
		ladder = new Ladder(1, 3);
		ladder.drawLine(0, 0);
		
		target = ladder.run(0);
		assertEquals(1, target);
	}
	@Test
	public void testRunWhenMultiRows() throws Exception {
		// 1 1 0 0
		// 0 1 1 0
		// 0 0 1 1
		Ladder ladder = new Ladder(3, 4);
		ladder.drawLine(0, 0);
		ladder.drawLine(1, 1);
		ladder.drawLine(2, 2);
		
		assertEquals(3, ladder.run(0));
		assertEquals(0, ladder.run(1));
		assertEquals(1, ladder.run(2));
		assertEquals(2, ladder.run(3));
	}
	
	@Test
	public void testLadderhightWhenMinus() throws Exception {
		try {
			Ladder ladder = new Ladder(-1, 4);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	
	@Test
	public void testdrawLinehightWhenMinus() throws Exception {
		try {
			Ladder ladder = new Ladder(3, 4);
			ladder.drawLine(-1, 2);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	@Test
	public void testdrawLinehightWhenOver() throws Exception {
		try {
			Ladder ladder = new Ladder(3, 4);
			ladder.drawLine(4, 2);
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	
	
}
