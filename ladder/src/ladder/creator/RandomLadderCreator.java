package ladder.creator;

import java.util.Random;

import core.NaturalNumber;
import ladder.LadderSize;
import ladder.Position;

public class RandomLadderCreator extends ManualLadderCreator implements LadderCreator{
	
	private static final double DEFAULT_LINE_RATIO = 0.3;
	
	private LadderSize ladderSize;
	
	public RandomLadderCreator(NaturalNumber height, NaturalNumber numOfPerson) {
		// ManaulLadderCreator 클래스를 상속받았기 때문에 해당 파라미터를 상속받은 클래스에 넘겨줌
		// 그렇게되면 사다리 초기화 작업을 현재 클래스에서 진행 할 필요가 없음.
		// 단, 해당 값을 쓰기 위해선 상속받은 클래스의 메서드를 통해 값을 사용해야함
		super(height, numOfPerson);
		
		this.ladderSize = LadderSize.create(height, numOfPerson);
		
		Position[] startPositions = generateStartPositions();
		for(Position position : startPositions) {
			super.drawLine(position.getHeight(), position.getNumOfPerson());
		}
	}
	
	@Override
	public void drawLine(NaturalNumber height, NaturalNumber startPosition) {
		throw new UnsupportedOperationException("RandomLadderCreator에서는 drawLine 메서드 호출 불가");
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
