package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

import core.NaturalNumber;

public class LadderGameTest {
	// 디버깅 시 로그에 진행사항이 나오도록 변경
	@Test
	public void testRunWhenMultiRows() throws Exception {
		// 1 -1 0 0
		// 0 1 -1 0
		// 0 0 1 -1
		LadderGame ladder = new LadderGame(new NaturalNumber(3), new NaturalNumber(4));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));
		
		assertEquals(new Marker(4), ladder.run(new Marker(1)));
		assertEquals(new Marker(1), ladder.run(new Marker(2)));
		assertEquals(new Marker(2), ladder.run(new Marker(3)));
		assertEquals(new Marker(3), ladder.run(new Marker(4)));
	}
	
	@Test
	public void testLadderhightWhenMinus() throws Exception {
		try {
			LadderGame ladder = new LadderGame(new NaturalNumber(-1), new NaturalNumber(3));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	
	@Test
	public void testdrawLinehightWhenMinus() throws Exception {
		try {
			LadderGame ladder = new LadderGame(new NaturalNumber(3), new NaturalNumber(4));
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
			LadderGame ladder = new LadderGame(new NaturalNumber(3), new NaturalNumber(4));
			ladder.drawLine(new NaturalNumber(4), new NaturalNumber(4));
			fail("IllegalArgumentException 에러 발생해야함");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
}
