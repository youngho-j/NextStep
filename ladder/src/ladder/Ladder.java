package ladder;

import core.NaturalNumber;

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
		if(isOverHeight(height)) {
			throw new IllegalArgumentException(String.format("사다리 최대 높이를 넘었습니다. 현재 값은 : %d", height.getNumber()));			
		}
		
		rows[height.toArrayIndex()].drawLine(startPosition);
	}
	// 기존 코드상 이해하기 힘든부분이 있어 메서드로 추출(현재 높이가 배열의 길이보다 클경우)
	private boolean isOverHeight(NaturalNumber height) {
		return height.toArrayIndex() > rows.length - 1;
	}
	
	// 실행	
	Marker run(Marker numOfPerson) {
		for(int i = 0 ; i < rows.length ; i++) {
			Row row = rows[i];
			numOfPerson = row.move(numOfPerson);
			// 로그 출력 부분
			String result = generate(rows, new NaturalNumber(i + 1), numOfPerson);
			System.out.println(result);
		}
		return numOfPerson;
	}
	
	// 출력을 위해 사다리 값 메세지로 표현
	static String generate(Row[] rows, NaturalNumber height, NaturalNumber numOfPerson) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < rows.length ; i++) {
			Row row = rows[i];
			Node[] nodes = row.getNodes();
			for(int j = 0 ; j < nodes.length ; j++) {
				Node node = nodes[j];
				if(node.equals(Node.createCenterNode())) {
					sb.append("0");
				} else if(node.equals(Node.createLeftNode())) {
					sb.append("-1");
				} else {
					sb.append("1");
				}
				
				if(height.toArrayIndex() == i && numOfPerson.toArrayIndex() == j) {
					sb.append("*");
				}
				
				sb.append(" ");
			}
			sb.append("\n");			
		}
		return sb.toString();
	}
}
