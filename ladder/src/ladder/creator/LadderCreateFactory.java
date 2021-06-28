package ladder.creator;

import core.NaturalNumber;
// 사디리 타기 게임 생성 관련 팩토리 클래스
public class LadderCreateFactory {
	
	public enum LadderType {
		MANUAL,
		RANDOM;
	}
	
	private LadderCreateFactory () {};
	
	public static LadderCreator newLadderCreator(NaturalNumber height, NaturalNumber numOfPerson, LadderType ladderType) {
		if(ladderType == LadderType.MANUAL) {
			return new ManualLadderCreator(height, numOfPerson);
		}
		return new RandomLadderCreator(height, numOfPerson);
	}
}
