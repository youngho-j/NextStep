package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class LadderTest {
	
	@Test
	public void testRunWhenNoLine()  throws Exception {
		Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		int target = ladder.run(0);
		assertEquals(0, target);
	}
	
	@Test
	public void testRunWhenLineLeft() throws Exception {
		// 1 1 0
		Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));	
		
		int target = ladder.run(2);
		assertEquals(1, target);
		// 0 1 1
		ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));	
		
		target = ladder.run(2);
		assertEquals(1, target);
		
	}
	@Test
	public void testRunWhenLineRight() throws Exception {
		// 0 1 1
		Ladder ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(2));		
		int target = ladder.run(1);
		assertEquals(2, target);
		// 1 1 0
		ladder = new Ladder(new NaturalNumber(1), new NaturalNumber(3));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		
		target = ladder.run(0);
		assertEquals(1, target);
	}
	@Test
	public void testRunWhenMultiRows() throws Exception {
		// 1 1 0 0
		// 0 1 1 0
		// 0 0 1 1
		Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));
		
		assertEquals(3, ladder.run(0));
		assertEquals(0, ladder.run(1));
		assertEquals(1, ladder.run(2));
		assertEquals(2, ladder.run(3));
	}
	
	@Test
	public void testLadderhightWhenMinus() throws Exception {
		try {
			Ladder ladder = new Ladder(new NaturalNumber(-1), new NaturalNumber(3));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	
	@Test
	public void testdrawLinehightWhenMinus() throws Exception {
		try {
			Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
			ladder.drawLine(new NaturalNumber(0), new NaturalNumber(3));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	@Test
	public void testdrawLinehightWhenOver() throws Exception {
		try {
			Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
			ladder.drawLine(new NaturalNumber(4), new NaturalNumber(4));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	
	
}
