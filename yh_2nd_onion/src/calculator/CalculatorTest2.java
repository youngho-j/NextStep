package calculator;

public class CalculatorTest2 {
	//Calculator�� �׽�Ʈ �ڵ� 
	public static void main(String[] args) {
		// ������2 - main �޼ҵ� �ϳ����� ���δ��� �ڵ��� ���� �޼ҵ带 ���ÿ� �׽�Ʈ 
		// �̷��� �Ǹ� ���δ��� �ڵ��� ���⵵�� �����ϸ� main() �޼ҵ��� ���⵵ ����, ��������� �����ϴµ� �δ�
		Calculator cal = new Calculator();
		
		/*
		 * System.out.println(cal.add(3, 4)); 
		 * System.out.println(cal.subtract(5, 4));
		 * System.out.println(cal.multiply(2, 6)); 
		 * System.out.println(cal.divide(8, 4));
		 */
		
		// ������2�� �ذ��ϱ� ���� �׽�Ʈ �ڵ带 �� �޼ҵ� ���� �и�
		// �޼ҵ� ���� �и��� ������, Calculator Ŭ������ ������ �ִ� ��� �޼ҵ� �׽�Ʈ�ؾ���
		// ����, �׽�Ʈ ����� �ܼ��� ���� ���� Ȯ���ؾ���
		// �ذ� ��� - Junit ���̺귯�� Ȱ��
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
