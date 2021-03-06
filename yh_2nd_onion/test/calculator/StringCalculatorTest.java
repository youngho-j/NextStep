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
	
	@Test
	public void 리팩토링_스플릿_분리_및_문자열_숫자변환_테스트() {
		// 1. 문자열 숫자 변환 
		assertArrayEquals(new String[] {"1"}, "1".split(","));
		// 2, 스플릿 분리
		assertArrayEquals(new String[] {"1", "2"}, "1,2".split(","));
	}
	
	@Test
	public void 구분자_쉼표_또는_콜론_테스트() {
		assertEquals(6, cal.add("1:2,3"));
	}
	
	@Test
	public void 커스텀_구분자_테스트() {
		assertEquals(10, cal.add("//u\n6u4"));
	}
	
	//기대하는 결과 값이 exception이므로 기대값에 runtimeException class 전달
	@Test(expected = RuntimeException.class)
	public void 음수_입력시_런타임_테스트() {
		assertEquals(5, cal.add("-1;2;2"));
	}
}
