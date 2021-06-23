package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

import core.NaturalNumber;

public class LadderRunnerTest {

	@Test
	public void testGenerate_라인이_없는경우() throws Exception {
		// 사다리 만들기
		Row[] rows = new Row[3];
		for(int i = 0 ; i < rows.length ; i++) {
			rows[i] = new Row(new NaturalNumber(3));
		}
		String result = LadderRunner.generate(rows, Position.create(1, 1));
		assertEquals("0* 0 0 \n0 0 0 \n0 0 0 \n", result);
	}
	
	@Test
	public void testGenerate_라인이_있는경우() throws Exception {
		// 사다리 만들기
		Row[] rows = new Row[3];
		for(int i = 0 ; i < rows.length ; i++) {
			rows[i] = new Row(new NaturalNumber(3));
		}
		rows[0].drawLine(new NaturalNumber(1));
		String result = LadderRunner.generate(rows, Position.create(1, 1));
		assertEquals("1* -1 0 \n0 0 0 \n0 0 0 \n", result);
	}

}
