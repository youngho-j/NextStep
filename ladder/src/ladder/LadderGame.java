package ladder;

import core.NaturalNumber;
import ladder.creator.LadderCreateFactory;
import ladder.creator.LadderCreator;
import ladder.creator.LadderCreateFactory.LadderType;
// 클래스 조율(실행, 과정 검증)
class LadderGame {
	
	private LadderCreator ladderCreator;
	
	// enum을 통해 수동, 랜덤 게임 생성 가능(역할 생성 + 구분) -> LadderCreateFactory로 역할 위임
	LadderGame(NaturalNumber height, NaturalNumber numOfPerson, LadderType ladderType) {
			ladderCreator = LadderCreateFactory.newLadderCreator(height, numOfPerson, ladderType); 
	}
	
	// 이동선 긋기
	void drawLine(NaturalNumber height, NaturalNumber startPosition) {
		ladderCreator.drawLine(height, startPosition);
	}
	
	// 실행	
	Marker run(Marker numOfPerson) {
		LadderRunner runner = new LadderRunner(ladderCreator.getLadder());
		return runner.run(numOfPerson);
	}
}
