package ladder;

import core.NaturalNumber;
// 전체 클래스 조율(생성, 실행, 과정 검증)
class LadderGame {
	private LadderCreator ladderCreator;
	
	// 사다리타기 참여 인원만큼 배열 길이 및 행 개수 지정(초기화)
	LadderGame(NaturalNumber height, NaturalNumber numOfPerson) {
		ladderCreator = new LadderCreator(height, numOfPerson);
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
