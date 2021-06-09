package ladder;

public class Row {
	int[] persons;
	
	Row(int numOfPerson){
		persons = new int[numOfPerson];
	}
	
	void drawLine(int startPosition) {
		// 오른쪽으로 이동하는 선
		persons[startPosition] = 1;
		// 왼쪽으로 이동하는 선
		persons[startPosition + 1] = -1;
	}
	
	public int move(int numOfPerson) {
		if(isNoLine(numOfPerson)) {
			return numOfPerson;
		}
		// 숫자가 1이면 오른쪽으로 이동 가능
		if(isRight(numOfPerson)) {
			return numOfPerson + 1;
		}
		// 그 외의 경우(0, 1이 아닌경우)
		return numOfPerson - 1;		
	}

	private boolean isRight(int numOfPerson) {
		return persons[numOfPerson] == 1;
	}

	private boolean isNoLine(int numOfPerson) {
		return persons[numOfPerson] == 0;
	}
}
