package calculator;

public class CalculatorTest2 {
	//현재 클래스는 테스트 코드를 각 메소드별로 분리한 테스트 코드
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
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
	
	/*
	 * 문제점읗 해결하기위해 테스트 코드를 각 메소드 별로 분리했으나, Calculator 클래스가 가지고 있는
	 * 모든 메소드를 테스트 해야함 또한, 테스트 결과를 확인하기 위해 콘솔을 통해 수동으로 확인 해야함
	 * 
	 * 해결을 위한 방법
	 * Junit 라이브러리 활용
	 * 
	 * Junit 적용하기
	 * 1. 현재 프로젝트는 자바 프로젝트
	 * 2. 프로젝트 생성시 Library, src 외에는 없음
	 * 3. 따라서 Test 폴더 생성 필요
	 * 4. 프로젝트 우클릭 후 build path -> Configure build ... 클릭
	 * 5. source 탭에서 add Folder
	 * 6. create .. 버튼 클릭하여 test 폴더 생성 후 체크한 뒤 ok
	 * 7. apply 후 패키지와 생성
	 * 8. 패키지 우클릭 후 new 에서 other 클릭
	 * 9. junit 검색하여 junit test case 생성
	 * 10. 라이브러리 추가 ok하면 끝
	*/
}
