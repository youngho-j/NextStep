package ladder;

public class Ladder {

	/*
	 *  0 - 좌/우 이동 X, 0 => 0
	 *  1
	 *  * 좌로 이동할 수 있는가?
	 *    1 => 0
	 *  * 우로 이동할 수 있는가?
	 *    0 => 1
	 *    
	*/
	private int[] row;
	
	// 사다리타기 참여 인원만큼 배열 길이 지정
	public Ladder(int numOfPerson) {
		row = new int[numOfPerson];
	}
	// 이동 선 긋기
	public void drawLine(int startPosition) {
		row[startPosition] = 1;
		row[startPosition + 1] = 1;
	}
	
	public int run(int numOfPerson) {
		if(row[numOfPerson] == 0) {
			return numOfPerson;
		}
		
		if(numOfPerson - 1 >= 0) {
			int leftValue = row[numOfPerson - 1];
			if(leftValue == 1) {
				return numOfPerson - 1;
			}			
		}
		// 좌측 이동이 아니면 우측이므로.. 
		return numOfPerson + 1;
		
	}
}
