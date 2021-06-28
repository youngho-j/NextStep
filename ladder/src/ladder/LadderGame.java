package ladder;

import core.NaturalNumber;
// 전체 클래스 조율(생성, 실행, 과정 검증)
class LadderGame {
	
	enum LadderType {
		MANUAL,
		RANDOM;
	}
	
	private LadderCreator ladderCreator;
	
	// enum을 통해 수동, 랜덤 게임 진행 선택 가능
	LadderGame(NaturalNumber height, NaturalNumber numOfPerson) {
		ladderCreator = new RandomLadderCreator(height, numOfPerson);
	}
	
	LadderGame(NaturalNumber height, NaturalNumber numOfPerson, LadderType ladderType) {
		if(ladderType == LadderType.MANUAL) {
			ladderCreator = new ManualLadderCreator(height, numOfPerson);
		} else {
			ladderCreator = new RandomLadderCreator(height, numOfPerson);
		}
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
