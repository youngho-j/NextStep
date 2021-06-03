package calculator;

public class CalculatorTest2 {
	//Calculator의 테스트 코드 
	public static void main(String[] args) {
		// 문제점2 - main 메소드 하나에서 프로덕션 코드의 여러 메소드를 동시에 테스트 
		// 이렇게 되면 프로덕션 코드의 복잡도가 증가하면 main() 메소드의 복잡도 증가, 결과적으로 유지하는데 부담
		Calculator cal = new Calculator();
		
		/*
		 * System.out.println(cal.add(3, 4)); 
		 * System.out.println(cal.subtract(5, 4));
		 * System.out.println(cal.multiply(2, 6)); 
		 * System.out.println(cal.divide(8, 4));
		 */
		
		// 문제점2를 해결하기 위해 테스트 코드를 각 메소드 별로 분리
		// 메소드 별로 분리를 했지만, Calculator 클래스가 가지고 있는 모든 메소드 테스트해야함
		// 또한, 테스트 결과를 콘솔을 통해 수동 확인해야함
		// 해결 방법 - Junit 라이브러리 활용
		add(cal);
		subtract(cal);
		multiply(cal);
		devide(cal);
	}
	
	private static void add(Calculator cal) {
		System.out.println(cal.add(9, 3));
	}
	
	private static void subtract(Calculator cal) {
		System.out.println(cal.subtract(9, 3));
	}
	
	private static void multiply(Calculator cal) {
		System.out.println(cal.multiply(9, 3));
	}
	private static void devide(Calculator cal) {
		System.out.println(cal.divide(9, 3));
	}
	
}
