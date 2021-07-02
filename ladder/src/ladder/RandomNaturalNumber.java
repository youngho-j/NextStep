package ladder;

import core.NaturalNumber;

// 랜덤으로 생성된 값에 대한 정보를 갖는 클래스
public class RandomNaturalNumber extends NaturalNumber {

	public RandomNaturalNumber(int number) {
		// NaturalNumber 클래스에게 해당 파라미터 값을 전달하여 해당 값을 가지고 있음
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
	
	// 사람수의 배수가 되는 자리인 경우(줄을 그을 수 없는 자리) 
	public boolean isMultipleOfPerson(int numOfPerson) {
		int remainder = getNumber() % numOfPerson;
		if(remainder == 0) {
			return true;
		}
		return false;
	}
}
