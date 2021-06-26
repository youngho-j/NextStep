package ladder;

import core.NaturalNumber;

// 사다리의 높이와 참여인원에 대한 정보를 갖는 클래스
public class LadderSize {

	private NaturalNumber height;
	private NaturalNumber numOfPerson;
	
	private LadderSize(NaturalNumber height, NaturalNumber numOfPerson) {
		this.height = height;
		this.numOfPerson = numOfPerson;
	}
	
	NaturalNumber getHeight() {
		return height;
	}
	
	NaturalNumber getNumOfPerson() {
		return numOfPerson;
	}
	
	static LadderSize create(int height, int numOfPerson) {
		return new LadderSize(new NaturalNumber(height), new NaturalNumber(numOfPerson));
	}
	
	// 전체 위치에서 몇번째 위치에 있는지 구하는 메서드
	NaturalNumber getPositionOfPerson(NaturalNumber currentTotalPosition) {
		int remainder = currentTotalPosition.getNumber() % numOfPerson.getNumber();
		if(remainder == 0) {
			return numOfPerson;
		}
		return new NaturalNumber(remainder);
	}

	// 전체 라인에서 몇번째 라인에 있는지 구하는 메서드
	NaturalNumber getPositionOfHeight(NaturalNumber currentTotalPosition) {
		Double ceilDividende = 0.0;
		ceilDividende = Math.ceil(currentTotalPosition.getNumber() / (double)numOfPerson.getNumber());
		return new NaturalNumber(ceilDividende.intValue());
	}

	//생성된 좌표값을 Position 객체로 생성
	Position getPosition(NaturalNumber currentTotalPosition) {
		return Position.create(getPositionOfHeight(currentTotalPosition), getPositionOfPerson(currentTotalPosition));
	}
	
	int getCountOfLine(double ratio) {
		NaturalNumber totalPositions = getTotalPosition();
		Double val = totalPositions.getNumber() * ratio;
		return val.intValue();
	}
	
	// 전체 위치를 구하는 메서드
	NaturalNumber getTotalPosition() {
		return height.multiply(numOfPerson);
	}
	
	// 사람수의 배수가 되는 자리인 경우(줄을 그을 수 없는 자리) 
	boolean isMultipleOfPerson(NaturalNumber randomPostion) {
		int remainder = randomPostion.getNumber() % numOfPerson.getNumber();
		if(remainder == 0) {
			return true;
		}
		return false;
	}

}
