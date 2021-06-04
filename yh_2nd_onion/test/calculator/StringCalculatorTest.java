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

}
