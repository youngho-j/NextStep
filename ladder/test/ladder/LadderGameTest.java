package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

import core.NaturalNumber;
import ladder.creator.LadderCreateFactory.LadderType;

public class LadderGameTest {

	@Test
	public void testRunBigLadder() throws Exception {
		LadderGame ladder = new LadderGame(new NaturalNumber(10), new NaturalNumber(6), LadderType.RANDOM);
		Marker result = ladder.run(new Marker(2));
		System.out.println(result);
	}
	
	@Test
	public void testRunWhenRandomLadder() throws Exception {
		LadderGame ladder = new LadderGame(new NaturalNumber(3), new NaturalNumber(4), LadderType.RANDOM);
		Marker result = ladder.run(new Marker(2));
		System.out.println(result);
	}
	
	@Test
	public void testRunWhenManualLadder() throws Exception {
		LadderGame ladder = new LadderGame(new NaturalNumber(3), new NaturalNumber(4), LadderType.MANUAL);
		ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
		ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
		ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));
		
		assertEquals(new Marker(4), ladder.run(new Marker(1)));
		assertEquals(new Marker(1), ladder.run(new Marker(2)));
		assertEquals(new Marker(2), ladder.run(new Marker(3)));
		assertEquals(new Marker(3), ladder.run(new Marker(4)));
	}
	
	@Test
	public void testdrawLineWhenOverNoOfRows() throws Exception {
		try {
			LadderGame ladder = new LadderGame(new NaturalNumber(3), new NaturalNumber(4), LadderType.MANUAL);
			ladder.drawLine(new NaturalNumber(4), new NaturalNumber(4));
			fail("IllegalArgumentException 에러가 발생해야 한다.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}
}
