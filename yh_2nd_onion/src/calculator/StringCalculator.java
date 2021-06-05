package calculator;

public class StringCalculator {
	// 리팩토링 시 주의 깊게 살펴볼 부분은 private 메서드가 아니라 
	// public으로 공개하고 있는 메서드가 얼마나 읽기 쉽고 좋은가가 가장 중요!
	public int add(String text) {
		
		// 요구사항 1. 빈 문자열 or null 값 입력시 0 반환
		if(text == null || text.isEmpty()) {
			return 0;			
		}
		
		// 요구사항 3. 숫자 두개를 구분자(쉼표)로 입력시 숫자의 합을 반환
		// 요구사항 3 리팩토링 (if 분기 제거 + 하나의 문자열을 해당 숫자로 변환)

		String[] values = text.split(",");
		
		return sum(toInts(values));
		
	}
	// 요구사항3 리팩토링 (add 메소드 내 역할 분리) - sum 메소드 역할 분리 필요(변환 + 합치기)  
	private int sum(int[] values) {
		int sum = 0;
		for(int val : values) {
			sum += val;
		}
		return sum;
	}
	
	// 요구사항3 리팩토링 - 문자열을 숫자로 변환
	private int[] toInts(String[] values) {
		int[] arr = new int[values.length];
		
		for(int i = 0 ; i < values.length ; i++) {
			arr[i] = Integer.parseInt(values[i]);
		}
		
		return arr;
	}
}
