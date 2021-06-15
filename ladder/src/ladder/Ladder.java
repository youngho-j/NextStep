package ladder;

class Ladder {

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
	Marker run(Marker numOfPerson) {
		for(int i = 0 ; i < rows.length ; i++) {
			Row row = rows[i];
			numOfPerson = row.move(numOfPerson);
		}
		return numOfPerson;
	}
}
