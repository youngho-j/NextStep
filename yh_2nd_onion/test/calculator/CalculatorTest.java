package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	// 단축키 - ctrl + f11 / 직전 실행 메서드 테스트 가능
	// 하나의 메서드만 실행하고 싶을 경우 메서드 이름 클릭 후 단축키 실행
	// 각 메서드 별로 테스트가 가능
	
	//멤버 필드로 사용이 가능하나 추천하지 않음.. 대신 @Before 어노테이션 사용 추천
	//왜? 인스턴스의 상태가 변경되면 메서드에 영향을 끼칠 수 있음 따라서 테스트 간에 영향을 미치는것을 방지하고 독립성을 보장하기 위해 @Before 사용 
	private Calculator cal;
	
	// 테스트가 실행전 실행하여 초기화를 진행함
	// 실행 순서 Before -> Test -> Before -> Test 순으로 진행됨
	@Before
	public void setup() {
		cal = new Calculator();
	}
	
	
	@Test
	public void calculator() {
		// 기대값과 결과 값을 비교
		assertEquals(3, cal.add(2, 1));
		assertEquals(1, cal.divide(2, 2));
		assertEquals(5, cal.multiply(5, 1));
		assertEquals(1, cal.subtract(2, 1));
	}
	
	@Test
	public void devide() {
		int reuslt = cal.divide(4, 2);
		// 일부러 값을 바꿔서 틀리게 한뒤 보면 에러가 뜨는 것을 확인할 수 있음
		// 에러 메세지를 보고, 프로덕션코드의 에러 수정할 수 있어야함
		assertEquals(2, reuslt);
	}
	
} 
