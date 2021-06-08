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
	 *  여러개의 행을 추가할 수 있도록 자원
	 *  -> 2차원 배열로 변경
	 *  
	*/
	private int[][] rows;
	
	// 사다리타기 참여 인원만큼 배열 길이 지정
	public Ladder(int countOfRow, int numOfPerson) {
		rows = new int[countOfRow][numOfPerson];
	}
	
	// 이동 선 긋기
	public void drawLine(int numOfRow,int startPosition) {
		rows[numOfRow][startPosition] = 1;
		rows[numOfRow][startPosition + 1] = 1;
	}
	
	public int run(int numOfPerson) {
		for(int i = 0 ; i < rows.length ; i++) {
			int[] row = rows[i];
			
			if(row[numOfPerson] == 0) {
				continue;
			}
			
			if(numOfPerson - 1 >= 0) {
				int leftValue = row[numOfPerson - 1];
				if(leftValue == 1) {
					numOfPerson -= 1;
					continue;
				}			
			}
			// 좌측 이동이 아니면 우측이므로.. 
			numOfPerson += 1;
		}
		return numOfPerson;
	}
}
