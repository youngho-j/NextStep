package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomLadderCreatorTest {
	
	// 학습 테스팅 - 원하는기능이 제대로 동작하는지 확인하는 것
	@Test
	public void testGenerateStartPositions() throws Exception{
		RandomLadderCreator creator = new RandomLadderCreator(LadderSize.create(3, 4));
		Position[] positions = creator.generateStartPositions();
		for(int i = 0 ; i < positions.length ; i++) {
			System.out.println(String.format("position : %s", positions[i]));
		}
	}
}
