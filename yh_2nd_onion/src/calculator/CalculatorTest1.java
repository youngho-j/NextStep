package calculator;

public class CalculatorTest1 {
	//현재 클래스는 Calculator 클래스(프로덕션 코드)와 분리된 테스트 코드
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		 // 테스트 코드 시작
		 System.out.println(cal.add(3, 4)); 
		 System.out.println(cal.subtract(5, 4));
		 System.out.println(cal.multiply(2, 6)); 
		 System.out.println(cal.divide(8, 4));
		 
		/*
		 * 문제점
		 * 현재 코드는 프로덕션 코드와 분리되어 있으나, 테스트시 프로덕션 코드의 여러 메소드가 동시에 테스트 되는 것을 볼 수 있음
		 * 이렇게 될 경우 프로덕션 코드의 복잡도가 증가시 테스트 코드 메소드의 복자도가 증가하게 되고,
		 * 결과적으로 유지하는데 부담이 되는 결과를 초래 
		 * 
		 * 해당 문제를 해결하기 위한 방법
		 * 테스트 코드를 각 메소드별로 분리(CalculatorTest2 클래스)
		*/
	}
}
