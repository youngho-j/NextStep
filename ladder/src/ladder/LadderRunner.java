package ladder;

// 실행 관련 클래스
public class LadderRunner {
	
	private Row[] rows;
	
	public LadderRunner(Row[] rows) {
		this.rows = rows;
	}
	
	Marker run(Marker numOfPerson) {
		for(int i = 0 ; i < rows.length ; i++) {
			Row row = rows[i];
			// 로그 출력 부분 - 랜덤값으로 테스트를 할 수 없어 콘솔 출력으로 변환
			System.out.println("Before : ");
			String result = generate(rows, Position.createFromArrayIndex(i, numOfPerson.toArrayIndex()));
			System.out.println(result);
			numOfPerson = row.move(numOfPerson);		
			System.out.println("After : ");
			result = generate(rows, Position.createFromArrayIndex(i, numOfPerson.toArrayIndex()));
			System.out.println(result);
		}
		return numOfPerson;
	}
	
	// 출력을 위해 사다리 값 메세지로 표현, 리팩토링(5-2), 디버깅을 위한 검증 코드	
	static String generate(Row[] rows, Position position) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < rows.length ; i++) {
			Row row = rows[i];
			row.generate(sb, i, position);			
		}
		return sb.toString();
	}
}
