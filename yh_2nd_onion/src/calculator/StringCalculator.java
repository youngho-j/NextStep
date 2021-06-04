package calculator;

public class StringCalculator {
	// 요구사항 1. 빈 문자열 or null 값 입력시 0 반환
	int add(String text) {
		if(text == null || text.isEmpty()) {
			return 0;			
		}
		// 요구사항 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
		return Integer.parseInt(text);
	}
}
