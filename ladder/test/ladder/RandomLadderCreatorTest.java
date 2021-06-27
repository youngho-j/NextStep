package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

import core.NaturalNumber;

public class RandomLadderCreatorTest {
	
	// 학습 테스팅 - 원하는기능이 제대로 동작하는지 확인하는 것
	@Test
	public void testGenerateStartPositions() throws Exception{
		RandomLadderCreator creator = new RandomLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
		Position[] positions = creator.generateStartPositions();
		for(int i = 0 ; i < positions.length ; i++) {
			System.out.println(String.format("position : %s", positions[i]));
		}
	}
	
	@Test
	public void testIsExisted() throws Exception {
		NaturalNumber[] startPositions = {new NaturalNumber(2), new NaturalNumber(3)};
		assertTrue(RandomLadderCreator.isExisted(startPositions, new NaturalNumber(2)));
		assertFalse(RandomLadderCreator.isExisted(startPositions, new NaturalNumber(4)));
	}
}
