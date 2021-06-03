package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	// ����Ű - ctrl + f11 / ���� ���� �޼��� �׽�Ʈ ����
	// �ϳ��� �޼��常 �����ϰ� ���� ��� �޼��� �̸� Ŭ�� �� ����Ű ����
	// �� �޼��� ���� �׽�Ʈ�� ����
	
	//��� �ʵ�� ����� �����ϳ� ��õ���� ����.. ��� @Before ������̼� ��� ��õ
	//��? �ν��Ͻ��� ���°� ����Ǹ� �޼��忡 ������ ��ĥ �� ���� ���� �׽�Ʈ ���� ������ ��ġ�°��� �����ϰ� �������� �����ϱ� ���� @Before ��� 
	private Calculator cal;
	
	// �׽�Ʈ�� ������ �����Ͽ� �ʱ�ȭ�� ������
	// ���� ���� Before -> Test -> Before -> Test ������ �����
	@Before
	public void setup() {
		cal = new Calculator();
	}
	
	
	@Test
	public void calculator() {
		// ��밪�� ��� ���� ��
		assertEquals(3, cal.add(2, 1));
		assertEquals(1, cal.divide(2, 2));
		assertEquals(5, cal.multiply(5, 1));
		assertEquals(1, cal.subtract(2, 1));
	}
	
	@Test
	public void devide() {
		int reuslt = cal.divide(4, 2);
		// �Ϻη� ���� �ٲ㼭 Ʋ���� �ѵ� ���� ������ �ߴ� ���� Ȯ���� �� ����
		// ���� �޼����� ����, ���δ����ڵ��� ���� ������ �� �־����
		assertEquals(2, reuslt);
	}
	
} 
