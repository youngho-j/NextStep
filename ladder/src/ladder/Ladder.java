package ladder;

public class Ladder {
	private int[] row;
	
	Ladder(int numOfPerson) {
		row = new int[numOfPerson];
	}
	
	public void drawLine(int StartPosition) {
		row[StartPosition] = 1;
		row[StartPosition + 1] = 1;
	}

	public int run(int numOfPerson) {
		if(numOfPerson - 1 <= 0 && row[numOfPerson - 1] == 1) {
			return numOfPerson + 1;
		}
		
		if(row[numOfPerson - 1] == 1) {
			if(row[numOfPerson - 2] == 1) {
				return numOfPerson -1;
			}
			if(row[numOfPerson] == 1) {
				return numOfPerson + 1;
			}
		}
		return numOfPerson;
	}

}
