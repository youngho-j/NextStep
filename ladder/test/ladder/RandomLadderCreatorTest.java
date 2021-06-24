package ladder;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import core.NaturalNumber;

public class RandomLadderCreatorTest {
	
	// 학습 테스팅 - 원하는기능이 제대로 동작하는지 확인하는 것
	@Test
	public void testGenerateStartPositions() throws Exception{
		RandomLadderCreator creator = new RandomLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
		int[] positions = creator.generateStartPositions();
		for(int i = 0 ; i < positions.length ; i++) {
			System.out.println(String.format("position : %d", positions[i]));
		}
	}
	
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	@Test
	public void testCountOfLine() throws  Exception {
		int countOfLine = RandomLadderCreator.getCountOfLine(new NaturalNumber(20), 0.3);
		assertEquals(6, countOfLine);
	}
}
