package ladder;

import core.NaturalNumber;
import ladder.creator.LadderCreator;

// 클래스 조율(실행, 과정 검증)
class LadderGame {
	
	private LadderCreator ladderCreator;
	
	// 기존 LadderCreatorFactory 클래스에 의존하여 생성하던 것을 DIP를 활용하여 LadderCreator 인터페이스에 의존하도록 변경
	// Random, ManualLaddeCreator 클래스는 LadderCreator 인터페이스를 상속받으므로 
	// 변하기 쉬운 Random, ManualLaddeCreator 클래스에 영향을 받지 않고 유연하게 동작 가능
	public LadderGame(LadderCreator ladderCreator) {
		this.ladderCreator = ladderCreator;
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
