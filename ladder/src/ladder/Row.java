package ladder;

// 외부에 공개할 필요 없으므로 default 값 유지
class Row {
	// enum - 클래스 안, 밖에 만들 수 있음.. 여기에선 안에서만 사용하므로 내부에 만들예정
	private enum Direction {
		LEFT(-1),
		CENTER(0),
		RIGHT(1);
		
		private int num;
		
		private Direction(int num) {
			this.num = num;
		}
		
		int getNum() {
			return num;
		}
	}
//  1, -1 값을 명확히 한다.
//	private static final int LEFT_DIRECTION = -1;
//	private static final int RIGHT_DIRECTION = 1;
//	private static final int CENTER_DIRECTION = 0;
	
	private int[] persons;
	
	// 같은 패키지 다른 클래스에서 접근을 해야하므로 default 유지
	Row(NaturalNumber numOfPerson){
		persons = new int[numOfPerson.getNumber()];
	}
	// 선긋기	
	void drawLine(NaturalNumber startPosition) {
		int startIndex = startPosition.toArrayIndex();
		
		if(startIndex >= persons.length -1) {
			throw new IllegalArgumentException(String.format("시작점은 %d 미만이어야 합니다. 현재 값은 : %d", persons.length -1, startIndex));			
		}
		
		if(persons[startIndex] == -1) {
			throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");						
		}
		// 오른쪽으로 이동하는 선
		persons[startIndex] = Direction.RIGHT.getNum();
		// 왼쪽으로 이동하는 선
		persons[startIndex + 1] = Direction.LEFT.getNum();
	}
	
	// 이동 방향 결정
	Marker move(Marker startNum) {
		if(isNoLine(startNum.toArrayIndex())) {
			return startNum;
		}
		// 숫자가 1이면 오른쪽으로 이동 가능
		if(isRightDirection(startNum.toArrayIndex())) {
			return startNum.moveRight();
		}
		// 그 외의 경우(0, 1이 아닌경우)
		return startNum.moveLeft();
	}

	private boolean isRightDirection(int numOfPerson) {
		return persons[numOfPerson] == Direction.RIGHT.getNum();
	}

	private boolean isNoLine(int numOfPerson) {
		return persons[numOfPerson] == Direction.CENTER.getNum();
	}
}
