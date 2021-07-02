package ladder.creator;

import java.util.ArrayList;

import org.junit.Test;

import core.NaturalNumber;
import ladder.Position;

public class RandomLadderCreatorTest {
	
	@Test
	public void testGenerateStartPositions() throws Exception{
		ManualLadderCreator manualLadderCreator = new ManualLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
		RandomLadderCreator creator = new RandomLadderCreator(manualLadderCreator);
		ArrayList<Position> positions = creator.generateStartPositions();
		for(Position position : positions) {
			System.out.println(String.format("position : %s", position));			
		}
	}
}