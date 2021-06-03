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
	
	//여기에서 main 메서드는 테스트를 목적으로 하는 테스트 코드
	public static void main(String[] args) {
		/*
		 * main 메서드를 테스트 목적으로 사용시 발생하는 문제점(아래 코드 시작 부분)
		 * 1. 테스트 코드와 프로덕션 코드(실제 서비스를 담당하는 코드)가 같은 클래스에 위치하게 됨 
		 * 보통 테스트 코드는 테스트 단계에서만 필요하기 떄문에 굳이 서비스 시점에 같이 배포할 필요 없음
		 * 
		 * 해당 문제를 해결하기 위한 방법
		 * 1. 프로덕션 코드(Calculator 클래스)와 테스트 코드(CalculatorTest1 클래스)로 분리
		 * 
		 */
		
		// 코드 시작
		Calculator cal = new Calculator();
		
		System.out.println(cal.add(3, 4));
		System.out.println(cal.subtract(5, 4));
		System.out.println(cal.multiply(2, 6));
		System.out.println(cal.divide(8, 4));
	}
}
