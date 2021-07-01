package ladder;

import core.NaturalNumber;

// 랜덤으로 생성된 값을 계산하는 클래스
public class RandomNaturalNumber extends NaturalNumber {

	public RandomNaturalNumber(int number) {
		super(number);
	}

	public int getPositionOfPerson(int numOfPerson) {
		int remainder = getNumber() % numOfPerson;
		if(remainder == 0) {
			return getNumber();
		}
		return remainder;
	}

	public int getPositionOfHeight(int numOfPerson) {
		Double ceilDividende = 0.0;
		ceilDividende = Math.ceil(getNumber() / (double)numOfPerson);
		return ceilDividende.intValue();
	}
	
}
