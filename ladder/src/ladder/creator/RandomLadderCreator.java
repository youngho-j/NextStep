package ladder.creator;

import java.util.Random;

import core.NaturalNumber;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

public class RandomLadderCreator implements LadderCreator{
	
	private static final double DEFAULT_LINE_RATIO = 0.3;
	
	private Row[] rows;
	
	private LadderSize ladderSize;
	
	// 사다리타기 참여 인원만큼 배열 길이 및 행 개수 지정(초기화)
	public RandomLadderCreator(NaturalNumber height, NaturalNumber numOfPerson) {
		this.ladderSize = LadderSize.create(height, numOfPerson);
		
		rows = new Row[height.getNumber()];
		
		for(int i = 0 ; i < height.getNumber() ; i ++) {
			rows[i] = new Row(numOfPerson);
		}
		
		Position[] startPositions = generateStartPositions();
		for(Position position : startPositions) {
			drawLine(position.getHeight(), position.getNumOfPerson());
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
		
		int i = 0;
		do {
			NaturalNumber randomPosition = randInt(1, totalPositions.getNumber());
			if(ladderSize.isMultipleOfPerson(randomPosition)) {
				continue;
			}
			if (isExisted(startPositions, randomPosition)) {
				continue;
			}
			if (isExisted(startPositions, new NaturalNumber(randomPosition.getNumber() + 1))) {
				continue;
			}
			
			if(randomPosition.equals(new NaturalNumber(1))) {
				startPositions[i] = randomPosition;
				System.out.println(String.format("random position : %s", startPositions[i]));
				i++;				
			} else {
				if (isExisted(startPositions, new NaturalNumber(randomPosition.toArrayIndex()))) {
					continue;
				}				
				startPositions[i] = randomPosition;
				System.out.println(String.format("random position : %s", startPositions[i]));
				i++;				
			}
			
		} while (i < countOfLine);		
		
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
	// 랜덤으로 생성된 지점이 배열에 해당 값과 같은 값이 존재하는지 안하는지 검사
	public static boolean isExisted(NaturalNumber[] startPositions, 
			NaturalNumber randomPosition) {
		for(NaturalNumber each : startPositions) {
			if(randomPosition.equals(each)) {
				return true;
			}
		}
		return false;
	}
}
