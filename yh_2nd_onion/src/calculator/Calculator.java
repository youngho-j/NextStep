package calculator;

public class Calculator {
	
	int add(int i, int j) {
		return i + j;
	}
	
	int subtract(int i, int j) {
		return i - j;
	}
	
	int multiply(int i, int j) {
		return i * j;
	}
	
	int divide(int i, int j) {
		return i / j;
	}
	
	// 테스트 목적
	public static void main(String[] args) {
		// 문제점1 - 테스트 코드(main() 메서드)와 프로덕션 코드(실제 서비스를 담당하는 코드) 
		// `같은 클래스에 위치`
		// 테스트 코드는 테스트 단계에서만 필요하기 떄문에 굳이 서비스 시점에 같이 배포할 필요 없음
		// 따라서 위 문제점을 해결하기 위해 
		// 프로덕션 코드(Calculator 클래스)와
		// 테스트 코드(CalculatorTest)로 분리
		Calculator cal = new Calculator();
		
		System.out.println(cal.add(3, 4));
		System.out.println(cal.subtract(5, 4));
		System.out.println(cal.multiply(2, 6));
		System.out.println(cal.divide(8, 4));
	}
}
