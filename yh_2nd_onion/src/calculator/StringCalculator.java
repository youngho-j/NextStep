package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	// 리팩토링 시 주의 깊게 살펴볼 부분은 private 메서드가 아니라 
	// public으로 공개하고 있는 메서드가 얼마나 읽기 쉽고 좋은가가 가장 중요!
	
	public int add(String text) {
		// 리팩토링을 극단적으로 한 이유는 
		// 소스코드 읽을 때 이 메소드가 무슨 일을 하지는 최대한 쉽게 파악할 수 있도록 하기 위해 
		// 좋은 코드란 세부 구현에 집중하도록 하지 않고, 논리적인 로직을 쉽게 파악할 수 있도록 구현하는 것
		
		//text 값이 비었으면 0 반환
		if(isBlank(text)) {
			return 0;			
		}
		
		// text 값이 비어있지 않으면 구분자로 분리, 숫자로 변환, 숫자의 합 리턴
		return sum(toInts(splitString(text)));
		
	}
	
	// 요구사항 1 리팩토링 - 빈칸 혹은 null값일 경우 0리턴
	private boolean isBlank(String text) {
		return text == null || text.isEmpty();
	}
	
	// 요구사항5 - //와 \n 문자 사이에 커스텀 구분자 지정 가능
	private String[] splitString(String text) {
		Matcher m  = Pattern.compile("//(.)\n(.*)").matcher(text);
		if(m.find()) {
			String customDelimeter = m.group(1);
			return m.group(2).split(customDelimeter);
		}
		return text.split(",|:"); 
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
			arr[i] = toPositive(values[i]);
		}
		
		return arr;
	}
	
	// 요구사항 6 음수 입력시 RuntimeException
	private int toPositive(String val) {
		int num = Integer.parseInt(val);
		if(num < 0) {
			throw new RuntimeException();
		}
		return num;
	}
}
