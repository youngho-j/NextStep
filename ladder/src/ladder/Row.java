package ladder;

public class Row {
	int[] persons;
	
	Row(int numOfPerson){
		persons = new int[numOfPerson];
	}
	
	void drawLine(int startPosition) {
		persons[startPosition] = 1;
		persons[startPosition + 1] = 1;
	}
	
	public int moveRow(int numOfPerson) {
		if(isNoLine(numOfPerson)) {
			return numOfPerson;
		}
		
		if(isNotLeftEnd(numOfPerson) && canLeft(numOfPerson)) {
			return numOfPerson - 1;
		}
		
		return numOfPerson + 1;
	}

	private boolean canLeft(int numOfPerson) {
		return persons[numOfPerson - 1] == 1;
	}

	private boolean isNotLeftEnd(int numOfPerson) {
		return numOfPerson - 1 >= 0;
	}

	private boolean isNoLine(int numOfPerson) {
		return persons[numOfPerson] == 0;
	}
}
