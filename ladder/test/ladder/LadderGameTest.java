package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

import core.NaturalNumber;

public class LadderGameTest {

	@Test
	public void testRunBigLadderAndDIP() throws Exception {
		LadderGame ladder = LadderGameFactory.randomLadderGame(new NaturalNumber(10), new NaturalNumber(6));
		Marker result = ladder.run(new Marker(2));
		System.out.println(result);
	}
		
	@Test
	public void testRunWhenRandomLadderAndDrawLine() throws Exception {
		try {
			LadderGame ladder = LadderGameFactory.randomLadderGame(new NaturalNumber(3), new NaturalNumber(4));
			ladder.drawLine(new NaturalNumber(1) , new NaturalNumber(1)); 
			fail();
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
	
	@Test
	public void testRunWhenRandomLadderAndDIP() throws Exception {
		LadderGame ladder = LadderGameFactory.randomLadderGame(new NaturalNumber(3), new NaturalNumber(4));
		Marker result = ladder.run(new Marker(2));
		System.out.println(result);
	}
	
	@Test
	public void testRunWhenManualLadderAndDIP() throws Exception {
		LadderGame ladder = LadderGameFactory.manualLadderGame(new NaturalNumber(3), new NaturalNumber(4));
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));
		
		assertEquals(new Marker(4), ladder.run(new Marker(1)));
		assertEquals(new Marker(1), ladder.run(new Marker(2)));
		assertEquals(new Marker(2), ladder.run(new Marker(3)));
		assertEquals(new Marker(3), ladder.run(new Marker(4)));
	}
	
	@Test
	public void testdrawLineWhenOverNoOfRowsAndDIP() throws Exception {
		try {
			LadderGame ladder = LadderGameFactory.manualLadderGame(new NaturalNumber(3), new NaturalNumber(4));
			ladder.drawLine(new NaturalNumber(4), new NaturalNumber(4));
			fail("IllegalArgumentException 에러가 발생해야 한다.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
}
