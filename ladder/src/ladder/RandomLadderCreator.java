package ladder;

import java.util.Random;

import core.NaturalNumber;

public class RandomLadderCreator {
	
	private static final double DEFAULT_LINE_RATIO = 0.3;
	
	private Row[] rows;
	
	private LadderSize ladderSize;
	
	// 사다리타기 참여 인원만큼 배열 길이 및 행 개수 지정(초기화)
	RandomLadderCreator(LadderSize ladderSize) {
		NaturalNumber height = ladderSize.getHeight();
		NaturalNumber numOfPerson = ladderSize.getNumOfPerson();
		this.ladderSize = ladderSize;
		
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
	
	Position[] generateStartPositions() {
		NaturalNumber[] numbers = generateRandomPositions();
		return toPostions(numbers);
	}
	
	//랜덤 위치 정보를 구하는 메서드
	NaturalNumber[] generateRandomPositions() {
		NaturalNumber totalPositions = ladderSize.getTotalPosition();
		// 단축키 alt shift t : 리팩토링 메뉴
		int countOfLine = ladderSize.getCountOfLine(DEFAULT_LINE_RATIO);
		NaturalNumber[] startPositions = new NaturalNumber[countOfLine];
		for(int i = 0 ; i < startPositions.length ; i++) {
			startPositions[i] = randInt(1, totalPositions.getNumber());
			System.out.println(String.format("random position : %s", startPositions[i]));
		}
		return startPositions;
	}
	
	// 2차원 배열로 변경
	Position[] toPostions(NaturalNumber[] positions) {
		Position[] startPositions = new Position[positions.length];
		for(int i = 0 ; i < positions.length ; i++) {
			startPositions[i] = ladderSize.getPosition(positions[i]);
		}
		return startPositions;
	}
	
	//랜덤 수 생성
	static NaturalNumber randInt(int min, int max) {
		Random rand = new Random();
		return new NaturalNumber(rand.nextInt((max - min) + 1) + min);
	}
}
