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
	
	// �׽�Ʈ ����
	public static void main(String[] args) {
		// ������1 - �׽�Ʈ �ڵ�(main() �޼���)�� ���δ��� �ڵ�(���� ���񽺸� ����ϴ� �ڵ�) 
		// `���� Ŭ������ ��ġ`
		// �׽�Ʈ �ڵ�� �׽�Ʈ �ܰ迡���� �ʿ��ϱ� ������ ���� ���� ������ ���� ������ �ʿ� ����
		// ���� �� �������� �ذ��ϱ� ���� 
		// ���δ��� �ڵ�(Calculator Ŭ����)��
		// �׽�Ʈ �ڵ�(CalculatorTest)�� �и�
		Calculator cal = new Calculator();
		
		System.out.println(cal.add(3, 4));
		System.out.println(cal.subtract(5, 4));
		System.out.println(cal.multiply(2, 6));
		System.out.println(cal.divide(8, 4));
	}
}
