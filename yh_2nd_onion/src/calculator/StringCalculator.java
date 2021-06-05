package calculator;

public class StringCalculator {

	int add(String text) {
		
		// 요구사항 1. 빈 문자열 or null 값 입력시 0 반환
		if(text == null || text.isEmpty()) {
			return 0;			
		}
		
		// 요구사항 3. 숫자 두개를 구분자(쉼표)로 입력시 숫자의 합을 반환
		// 요구사항 3 리팩토링 (if 분기 제거 + 하나의 문자열을 해당 숫자로 변환)

		String[] values = text.split(",");
		
		int sum = 0;
		for(String val : values) {
			sum += Integer.parseInt(val);
		}
		
		return sum;
		
	}
}
