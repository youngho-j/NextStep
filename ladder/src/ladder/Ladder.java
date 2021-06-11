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
	 *  
	 *  리팩토링3
	 *  예외 상황에 대한 처리
	 *  Ladder 메서드 예외처리
	 *  - 배열의 길이(높이)가 1보다 작은 경우 - 예외 처리
	 *  drawLine 메서드 예외처리
	 *  - 배열의 길이(높이)가 0보다 작은 경우 - 예외처리
	 *    배열 시작은 0부터 이므로 가장 위 사다리는 0부터 시작
	 *  - 배열의 길이(높이)가 배열의 길이보다 큰 경우 - 예외 처리
	 *    배열의 끝 값은 길이 - 1 이므로 가장 마지막 배열은 배열의 길이 - 1보다 크면 안됨 
	 *  - 시작 지점의 경우 Row 클래스에서 예외 처리를 하기때문에 구현하지 않음
	*/
	private Row[] rows;
	
	// 사다리타기 참여 인원만큼 배열 길이 및 행 개수 지정
	Ladder(NaturalNumber height, NaturalNumber numOfPerson) {
		rows = new Row[height.getNumber()];
		for(int i = 0 ; i < height.getNumber() ; i ++) {
			rows[i] = new Row(numOfPerson);
		}
	}
	
	// 이동선 긋기
	void drawLine(NaturalNumber height, NaturalNumber startPosition) {
		if(height.toArrayIndex() > rows.length - 1) {
			throw new IllegalArgumentException(String.format("사다리 최대 높이를 넘었습니다. 현재 값은 : %d", height.getNumber()));			
		}
		
		rows[height.toArrayIndex()].drawLine(startPosition);
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
