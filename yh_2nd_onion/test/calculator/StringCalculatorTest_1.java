package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest_1 {
	private StringCalculator_1 cal;
	
	@Before
	public void setUp() {
		cal = new StringCalculator_1(); 
	}
	
	@Test
	public void 입력시_빈칸_혹은_null값인경우_0리턴_테스트() {
		assertEquals(0, cal.add(null));
		assertEquals(0, cal.add(""));
	}
	
	@Test
	public void 문자를_숫자화_테스트() {
		assertEquals(1, cal.add("1"));
	}
	
	@Test
	public void 구분자_분리_테스트() {
		assertEquals(7, cal.add("3,4"));
	}
	
	@Test
	public void 커스텀_구분자_테스트() {
		assertEquals(10, cal.add("//u\n3u4u3"));
	}
	
	@Test(expected = RuntimeException.class)
	public void 음수_예외_출력_테스트() {
		assertEquals(0, cal.add("-1,1"));
	}
}
