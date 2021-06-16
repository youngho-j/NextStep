package ladder;

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
		
		if(startIndex >= nodes.length -1) {
			throw new IllegalArgumentException(String.format("시작점은 %d 미만이어야 합니다. 현재 값은 : %d", nodes.length -1, startIndex));			
		}
		
		if(nodes[startIndex].equals(Node.createLeftNode())) {
			throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");						
		}
		
		// 오른쪽으로 이동하는 선
		nodes[startIndex].changeRight();
		// 왼쪽으로 이동하는 선
		nodes[startIndex + 1].changeLeft();
	}
	
	// 이동 방향 결정(Node 클래스로 작업 위임)
	Marker move(Marker startNum) {
		return nodes[startNum.toArrayIndex()].move(startNum);
	}
}
