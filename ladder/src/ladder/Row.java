package ladder;

/*
 * 리팩토링
 * 메서드 이름 리팩토링
 * 1, -1 값을 명확히 한다.(상수 처리)
 * 상수 값을 enum으로 변경(상수 값이 여러개일 경우)
 * 
 * 리팩토링2
 * 접근제어자 처리
 */

// 외부에 공개할 필요 없으므로
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
	Row(int numOfPerson){
		persons = new int[numOfPerson];
	}
	
	void drawLine(int startPosition) {
		// 오른쪽으로 이동하는 선
		persons[startPosition] = Direction.RIGHT.getNum();
		// 왼쪽으로 이동하는 선
		persons[startPosition + 1] = Direction.LEFT.getNum();
	}
	
	public int move(int numOfPerson) {
		if(isNoLine(numOfPerson)) {
			return numOfPerson;
		}
		// 숫자가 1이면 오른쪽으로 이동 가능
		if(isRightDirection(numOfPerson)) {
			return numOfPerson + 1;
		}
		// 그 외의 경우(0, 1이 아닌경우)
		return numOfPerson - 1;		
	}

	private boolean isRightDirection(int numOfPerson) {
		return persons[numOfPerson] == Direction.RIGHT.getNum();
	}

	private boolean isNoLine(int numOfPerson) {
		return persons[numOfPerson] == Direction.CENTER.getNum();
	}
}
