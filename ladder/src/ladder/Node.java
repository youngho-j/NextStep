package ladder;
// 값을 비교할때 getter를 사용하여 값을 꺼내오기 보단,
// 객체의 값을 넣어 생성한 뒤 인스턴스끼리 비교하는 것이 좋음 
class Node {
	// 팩토리 메서드를 사용하게 되면서 외부에서 사용되지 않음. 따라서 private으로 접근제어자 변경
	private enum Direction {
		LEFT, CENTER, RIGHT;
	}
	
	private Direction direction;
	
	private Node(Direction direction) {
		this.direction = direction;
	}
	
	Direction getDirection() {
		return direction;
	}

	void changeRight() {
		this.direction = Direction.RIGHT;
	}
	
	void changeLeft() {
		this.direction = Direction.LEFT;
	}
	
	// 기존 row에서 사용하고 있던 코드를 위임받음
	boolean isLeftDirection() {
		return this.direction == Direction.LEFT;
	}
	
	boolean isRightDirection() {
		return this.direction == Direction.RIGHT;
	}
	
	Marker move(Marker marker) {
		
		if(isRightDirection()) {
			return marker.moveRight();
		}
		
		if(isLeftDirection()) {
			return marker.moveLeft();
		}
		
		return marker;
	}
	// 참고
	// 팩토리 메서드 패턴 - 객체 생성 처리를 서브 클래스로 분리 해 처리하도록 캡슐화하는 패턴
	// 객체의 생성 코드를 별도의 클래스/메서드로 분리함으로써 객체 생성의 변화에 대비하는 데 유용
	// static으로 만드어 자기 자신의 인스트너스를 생성해서 반환하는 메서드 - 팩토리 메서드
	// 객체를 생성하는 역할을 분리하고자 함 즉, 객체 생성의 역할을 하는 클래스 메서드
	static Node createCenterNode() {
		return new Node(Direction.CENTER);
	}
	
	static Node createRightNode() {
		return new Node(Direction.RIGHT);
	}
	
	static Node createLeftNode() {
		return new Node(Direction.LEFT);
	}
	
	// 객체 간 비교를 위해 오버라이딩
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (direction != other.direction)
			return false;
		return true;
	}
}
