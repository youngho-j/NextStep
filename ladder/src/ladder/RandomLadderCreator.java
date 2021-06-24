package ladder;

import java.util.Random;

import core.NaturalNumber;

public class RandomLadderCreator {
	
	private static final double DEFAULT_LINE_RATIO = 0.3;
	private NaturalNumber totalPositions;
	private Row[] rows;
	
	// 사다리타기 참여 인원만큼 배열 길이 및 행 개수 지정(초기화)
	RandomLadderCreator(NaturalNumber height, NaturalNumber numOfPerson) {
		this.totalPositions = height.multiply(numOfPerson);
		
		rows = new Row[height.getNumber()];
		
		for(int i = 0 ; i < height.getNumber() ; i ++) {
			rows[i] = new Row(numOfPerson);
		}
	}
	
	// 이동선 긋기
	void drawLine(NaturalNumber height, NaturalNumber startPosition) {
		if(isOverHeight(height)) {
			throw new IllegalArgumentException(String.format("사다리 최대 높이를 넘었습니다. 현재 값은 : %d", height.getNumber()));			
		}
		
		rows[height.toArrayIndex()].drawLine(startPosition);
	}
	
	// 기존 코드상 이해하기 힘든부분이 있어 메서드로 추출(현재 높이가 배열의 길이보다 클경우)
	private boolean isOverHeight(NaturalNumber height) {
		return height.toArrayIndex() > rows.length - 1;
	}
	
	Row[] getLadder() {
		return this.rows;
	}

	int[] generateStartPositions() {
		// 단축키 alt shift t : 리팩토링 메뉴
		int countOfLine = getCountOfLine(totalPositions, DEFAULT_LINE_RATIO);
		int[] startPositions = new int[countOfLine];
		for(int i = 0 ; i < startPositions.length ; i++) {
			startPositions[i] = randInt(1, totalPositions.getNumber());
		}
		return startPositions;
	}

	static int getCountOfLine(NaturalNumber totalPositions, double ratio) {
		Double val = totalPositions.getNumber() * ratio;
		return val.intValue();
	}
	
	//랜덤 수 생성
	static int randInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

}
