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
	
	public NaturalNumber getHeight() {
		return height;
	}
	
	public NaturalNumber getNumOfPerson() {
		return numOfPerson;
	}
	
	static LadderSize create(int height, int numOfPerson) {
		return create(new NaturalNumber(height), new NaturalNumber(numOfPerson));
	}
	
	public static LadderSize create(NaturalNumber height, NaturalNumber numOfPerson) {
		return new LadderSize(height, numOfPerson);
	}
	
	//생성된 좌표값을 Position 객체로 생성
	public Position getPosition(RandomNaturalNumber randomNaturalNumber) {
		// 해당 순서의 높이 및 위치를 변수로 변경
		int positionOfHeight = randomNaturalNumber.getPositionOfHeight(numOfPerson.getNumber());
		int positionOfPerson = randomNaturalNumber.getPositionOfPerson(numOfPerson.getNumber());
		
		return Position.create(positionOfHeight, positionOfPerson);
	}
	
	public int getCountOfLine(double ratio) {
		NaturalNumber totalPositions = getTotalPosition();
		Double val = totalPositions.getNumber() * ratio;
		return val.intValue();
	}
	
	// 전체 위치를 구하는 메서드
	public NaturalNumber getTotalPosition() {
		return height.multiply(numOfPerson);
	}
	
	// 사람수의 배수가 되는 자리인 경우(줄을 그을 수 없는 자리) 
	public boolean isMultipleOfPerson(RandomNaturalNumber randomPostion) {
		return randomPostion.isMultipleOfPerson(numOfPerson.getNumber());
	}

}
