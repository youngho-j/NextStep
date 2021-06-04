package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	private StringCalculator cal;
	
	@Before
	public void setup(){
		cal = new StringCalculator();
	}
	
	@Test
	public void null_또는_빈물자_처리_테스트() {
		assertEquals(0, cal.add(null));
		assertEquals(0, cal.add(""));
	}
	
	@Test
	public void 숫자하나_문자열_입력시_해당_숫자반환_테스트() {
		assertEquals(10, cal.add("10"));
	}
	
	@Test
	public void 구분자_쉼표로_입력시_숫자의합_반환_테스트() {
		assertEquals(9, cal.add("3,2,4"));
	}

}
