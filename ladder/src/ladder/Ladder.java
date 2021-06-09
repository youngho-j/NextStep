package ladder;

class Ladder {

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
	 *  Row 클래스 - 행관리, 이동 여부 결정, 사다리 그리기
	 *  Ladder 클래스 - 사다리 타기 전체 구조 관리
	 *  
	 *  LadderTest의 테스트를 RowTest로 이동(완)
	 *  moveRow() 메서드 리팩토링 찾기(완) - 1 - 우측, -1 - 좌측 이동
	 *  Row의 moveRow => move로 rename(완 - alt shift r[윈도우])
	 *  
	 *  리팩토링2
	 *  접근 제어자 처리
	*/
	private Row[] rows;
	
	// 사다리타기 참여 인원만큼 배열 길이 및 행 개수 지정
	Ladder(int countOfRow, int numOfPerson) {
		rows = new Row[countOfRow];
		for(int i = 0 ; i < countOfRow ; i ++) {
			rows[i] = new Row(numOfPerson);
		}
	}
	
	// 이동선 긋기
	void drawLine(int numOfRow,int startPosition) {
		rows[numOfRow].drawLine(startPosition);
	}
	
	// 실행
	int run(int numOfPerson) {
		for(int i = 0 ; i < rows.length ; i++) {
			Row row = rows[i];
			numOfPerson = row.move(numOfPerson);
		}
		return numOfPerson;
	}
}
