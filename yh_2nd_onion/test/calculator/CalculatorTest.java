package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// Junit 테스트 단축키 - Ctrl + F11 (직전 실행 테스트 다시 실행됨)
// 메소드 각각 따로 실행하고 싶은 경우 해당 메소드 이름에 커서 이동후 단축키 실행
public class CalculatorTest {
	private Calculator cal;
	
	// 매번 인스턴스 생성하는 것(반복적으로 발생하는 코드)을 줄여주는 메서드
	// @Before - Test 메서드가 실행될때마다 그 전에 호출됨 즉, 테스트 실행 전마다 계속 호출됨
	// 참고 @After는 Test 메서드 실행 다음에 호출 즉, 테스트 실행 후 계속 호출
	@Before
	public void setup() {
		// junit에서는 멤버 필드로 초기화하는 것을 권장하지 않기때문에 @Before 어노테이션 사용
		// 멤버 필드를 통해 초기화를 권장하지 않는 이유
		// 멤버 필드를 통해 초기화시 테스트 실행시 초기화 작업이 한번만 실행되고 메서드에서 공유된 인스턴스를 사용하게 됨
		// 이렇게 되면 메서드에서 인스턴스의 상태를 변경하면 다른 메서드에 영향을 미칠 수 있음
		// 그렇게 되면 테스트가 매번 결과가 달라질 수 있음 즉, 테스트의 독립성을 보장할 수 없음
		// 따라서 각 테스트의 독립성을 보장하기 위해 @Before 어노테이션을 사용 
		
		cal = new Calculator();
	}
	
	
	@Test
	public void calculator() {
		//assertEquals(기대값, 비교하자고 하는 값) - 프로덕션 코드의 결과값을 검증하고 싶을때 사용
		assertEquals(3, cal.add(2, 1));
		assertEquals(1, cal.divide(2, 2));
		assertEquals(5, cal.multiply(5, 1));
		assertEquals(1, cal.subtract(2, 1));
	}
	
	@Test
	public void devide() {
		// 1번 방법
//		int reuslt = cal.divide(4, 2);
//		assertEquals(2, reuslt);
		
		// 2번 방법(1번 리팩토링)
		assertEquals(2, cal.divide(4, 2));
	}
	
	// 일부러 실패 유도 코드 - 기대값(expected)은 4였는데 결과는 3
	// 테스트 실패 메시지를 보고 프로덕션 코드가 문제가 있다는 것을 알 수 있음
	@Test
	public void add() {
		assertEquals(4, cal.add(2, 1));
	}
	
} 
