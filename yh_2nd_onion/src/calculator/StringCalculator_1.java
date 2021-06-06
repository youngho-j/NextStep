package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator_1 {
	public int add(String text) {
		if(isBlank(text)) {
			return 0;
		}
		return sum(toInt(splitCheck(text)));
	}
	
	private boolean isBlank(String text) {
		// null 체크가 isEmpty 메서드보다 뒤에있을때 오류남..
		return text == null || text.isEmpty();
	}
	
	private String[] splitCheck(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if(m.find()) {
			String customDelimeter = m.group(1);
			return m.group(2).split(customDelimeter);
		}
		return text.split(",|:");
				
	}
	
	private int[] toInt(String[] splitList) {
		int[] convertList = new int[splitList.length];
		for(int i = 0 ; i < splitList.length ; i++) {
			convertList[i] = isPossible(splitList[i]);
		}
		return convertList;
	}
	
	private int sum(int[] convertList) {
		int sum = 0;
		for(int pick : convertList) {
			sum += pick;
		}
		return sum;
	}
	
	private int isPossible(String value) {
		int num = Integer.parseInt(value);
		if(num < 0) {
			throw new RuntimeException();
		}
		return num;
	}
}
