package ladder;

import core.NaturalNumber;

// 외부에 공개할 필요 없으므로 default 값 유지
class Row {
	private Node[] nodes;
	
	// 같은 패키지 다른 클래스에서 접근을 해야하므로 default 유지
	Row(NaturalNumber numOfPerson){
		nodes = new Node[numOfPerson.getNumber()];
		
		for(int i = 0 ; i < nodes.length ; i++) {
			nodes[i] = Node.createCenterNode();
		}
	}
	// 선긋기	
	void drawLine(NaturalNumber startPosition) {
		int startIndex = startPosition.toArrayIndex();
		
		if(isOverNumOfPersons(startIndex)) {
			throw new IllegalArgumentException(String.format("시작점은 %d 미만이어야 합니다. 현재 값은 : %d", nodes.length -1, startIndex));			
		}
		// 기존 Row에서 메서드에서 처리하던 코드를 Node클래스 메서드 위임
		if(nodes[startIndex].isLeftDirection()) {
			throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");						
		}
		
		// 오른쪽으로 이동하는 선
		nodes[startIndex].changeRight();
		// 왼쪽으로 이동하는 선
		nodes[startIndex + 1].changeLeft();
	}
	
	// 기존 코드상 이해하기 힘든부분이 있어 메서드로 추출(선 시작 위치가 참여 인원수보다 클 경우)
	private boolean isOverNumOfPersons(int startIndex) {
		return startIndex >= nodes.length -1;
	}
	
	// 이동 방향 결정(Node 클래스로 작업 위임)
	Marker move(Marker startNum) {
		return nodes[startNum.toArrayIndex()].move(startNum);
	}
}
