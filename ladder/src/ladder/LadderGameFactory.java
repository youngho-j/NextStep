package ladder;

import core.NaturalNumber;
import ladder.creator.ManualLadderCreator;
import ladder.creator.RandomLadderCreator;

// 팩토리 메서드를 사용하여 외부에서 사다리 타기의 형태를 갖춤
public class LadderGameFactory {
	
	private LadderGameFactory() {}
	
	static LadderGame randomLadderGame(NaturalNumber height, NaturalNumber numOfPerson) {
		ManualLadderCreator manualLadderCreator = new ManualLadderCreator(height, numOfPerson);
		RandomLadderCreator ladderCreator = new RandomLadderCreator(manualLadderCreator);
		return new LadderGame(ladderCreator);
	}
	
	static LadderGame manualLadderGame(NaturalNumber height, NaturalNumber numOfPerson) {
		ManualLadderCreator ladderCreator = new ManualLadderCreator(height, numOfPerson);
		return new LadderGame(ladderCreator);
	}
}
