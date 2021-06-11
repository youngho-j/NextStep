package ladder;

/*
 * 리팩토링
 * 메서드 이름 리팩토링
 * 1, -1 값을 명확히 한다.(상수 처리)
 * 상수 값을 enum으로 변경(상수 값이 여러개일 경우)
 * 
 * 리팩토링2
 * 접근제어자 처리
 * 
 * 리팩토링3
 * 예외 상황에 대한 처리
 * enum 부분에 대한 리팩토링
 * Row 생성자 예외처리(완)
 * - numOfPerson > 0
 * drawLine 메서드 예외처리
 * - startPosition < 0 => 예외 
 * - 5명 참여 => 범위 0 ~ 4 => 실제 그을 수 있는 범위는 3
 *   즉, startPosition >= persons.length - 1 => 예외
 * - 현재 위치 값이 -1 => 예외
 *   겹치면 잘못 실행 되므로
 * move 메서드 예외처리(완)
 * 
 * 리팩토링4
 * 예외처리시 반복되는 코드를
 * int 형의 값을 1보다 큰 자연수의 값을 가진 NaturalNumber 타입의 객체로 만들어 추출
 * 자연수 검증 코드를 추출하여 NaturalNumber 클래스로 만들기
 * 
 * 참고
 * 해당 메서드가 사용중인 곳을 알고 싶을땐 ctrl shift g
 * 테스트 코드 작성 -> 클래스 생성 -> 테스트 통과 확인 -> 중복된 코드 복사 -> 복사한 코드 테스트 -> 반복
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
	Row(NaturalNumber numOfPerson){
		persons = new int[numOfPerson.getNumber()];
	}
		
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
	
	public int move(int startNum) {
		
		if(startNum < 0) {
			throw new IllegalArgumentException(String.format("사다리 시작 위치는 0 이상이어야 합니다. 현재 위치 : %d", startNum));									
		}
		
		if(isNoLine(startNum)) {
			return startNum;
		}
		// 숫자가 1이면 오른쪽으로 이동 가능
		if(isRightDirection(startNum)) {
			return startNum + 1;
		}
		// 그 외의 경우(0, 1이 아닌경우)
		return startNum - 1;		
	}

	private boolean isRightDirection(int numOfPerson) {
		return persons[numOfPerson] == Direction.RIGHT.getNum();
	}

	private boolean isNoLine(int numOfPerson) {
		return persons[numOfPerson] == Direction.CENTER.getNum();
	}
}
