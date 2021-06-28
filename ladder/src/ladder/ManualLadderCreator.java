package ladder;

import core.NaturalNumber;
// 사다리 생성 관련 클래스
public class ManualLadderCreator implements LadderCreator {

	private Row[] rows;
	
	// 사다리타기 참여 인원만큼 배열 길이 및 행 개수 지정(초기화)
	ManualLadderCreator(NaturalNumber height, NaturalNumber numOfPerson) {
		rows = new Row[height.getNumber()];
		for(int i = 0 ; i < height.getNumber() ; i ++) {
			rows[i] = new Row(numOfPerson);
		}
	}
	
	// 이동선 긋기
	@Override
	public void drawLine(NaturalNumber height, NaturalNumber startPosition) {
		if(isOverHeight(height)) {
			throw new IllegalArgumentException(String.format("사다리 최대 높이를 넘었습니다. 현재 값은 : %d", height.getNumber()));			
		}
		
		rows[height.toArrayIndex()].drawLine(startPosition);
	}
	
	// 기존 코드상 이해하기 힘든부분이 있어 메서드로 추출(현재 높이가 배열의 길이보다 클경우)
	private boolean isOverHeight(NaturalNumber height) {
		return height.toArrayIndex() > rows.length - 1;
	}
	
	@Override
	public Row[] getLadder() {
		return this.rows;
	}
}
