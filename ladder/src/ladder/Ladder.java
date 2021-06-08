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
	 *  리팩토링
	 *  Row 클래스
	 *  Ladder 클래스 분리
	 *  
	*/
	Row[] rows;
	
	// 사다리타기 참여 인원만큼 배열 길이 및 행 개수 지정
	public Ladder(int countOfRow, int numOfPerson) {
		rows = new Row[countOfRow];
		for(int i = 0 ; i < countOfRow ; i ++) {
			rows[i] = new Row(numOfPerson);
		}
	}
	
	// 이동선 긋기
	public void drawLine(int numOfRow,int startPosition) {
		rows[numOfRow].drawLine(startPosition);
	}
	
	// 실행
	public int run(int numOfPerson) {
		for(int i = 0 ; i < rows.length ; i++) {
			Row row = rows[i];
			numOfPerson = row.moveRow(numOfPerson);
		}
		return numOfPerson;
	}
}
