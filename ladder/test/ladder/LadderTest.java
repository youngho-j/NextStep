package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class LadderTest {
	
	@Test
	public void testRunWhenNoLine()  throws Exception {
		Ladder ladder = new Ladder(3);
		int target = ladder.run(0);
		assertEquals(0, target);
	}
	
	@Test
	public void testRunWhenLineLeft() throws Exception {
		// 1 1 0
		Ladder ladder = new Ladder(3);
		ladder.drawLine(1);
		
		int target = ladder.run(2);
		assertEquals(1, target);
		// 0 1 1
		ladder = new Ladder(3);
		ladder.drawLine(1);
		
		target = ladder.run(2);
		assertEquals(1, target);
		
	}
	@Test
	public void testRunWhenLineRight() throws Exception {
		// 0 1 1
		Ladder ladder = new Ladder(3);
		ladder.drawLine(1);
		
		int target = ladder.run(1);
		assertEquals(2, target);
		// 1 1 0
		ladder = new Ladder(3);
		ladder.drawLine(0);
		
		target = ladder.run(0);
		assertEquals(1, target);
	}
}
