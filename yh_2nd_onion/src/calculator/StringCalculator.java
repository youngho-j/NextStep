package calculator;

public class StringCalculator {
	// 요구사항 1. 빈 문자열 or null 값 입력시 0 반환
	int add(String text) {
		if(text == null || text.isEmpty()) {
			return 0;			
		}
		// 요구사항 3. 숫자 두개를 구분자(쉼표)로 입력시 숫자의 합을 반환
		if(text.contains(",")) {
			String[] values = text.split(",");
			int sum = 0;
			for(String val : values) {
				sum += Integer.parseInt(val);
			}
			return sum;
		}
		// 요구사항 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
		return Integer.parseInt(text);
	}
}
