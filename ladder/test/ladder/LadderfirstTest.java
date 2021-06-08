package ladder;

import junit.framework.TestCase;

public class LadderfirstTest extends TestCase {
	// 요구사항 : 1 by 1, 1 by 0, 1 by 2 / 1 => 1
	// 해당 테스트 진행시 NoClassDefFoundError 발생하는 경우
	// 원인 : JUnit 추가시 Modulepath에 추가해서
	// 해결방법 : 기존 추가한 JUnit 제거 후 ClassPath에 추가하면 됨
	public void testRunWhenOneByOne() throws Exception {
		Ladder_first ladder = new Ladder_first(1);
				
		int target = ladder.run(1);
		
		assertEquals(1, target);
	}
	
	// 요구사항 : 2 by 1 (사용자 2명에 선이 하나)
	// 선이 그어져 있지 않은 경우 : 0 0 / 1 => 1, 2 => 2
	public void testRunWhenTwoByOneNoLine() throws Exception {
		Ladder_first ladder = new Ladder_first(2);
		
		int target = ladder.run(1);
		assertEquals(1, target);

		target = ladder.run(2);
		assertEquals(2, target);
	}
	
	public void testRunWhenTwoByOneOneLine() throws Exception {
		Ladder_first ladder = new Ladder_first(2);
		ladder.drawLine(0);
		int target = ladder.run(1);
		assertEquals(2, target);
		
		target = ladder.run(2);
		assertEquals(1, target);
	}
	
	// 요구사항 : 3 by 1 
	// 테스트 실패시 로직을 추가해야 되는구나라고 알 수 있음
	public void testRunWhenThreeByOneOneLine() throws Exception {
		// 1 1 0 의 경우
		Ladder_first ladder = new Ladder_first(3);
		ladder.drawLine(0);
		int target = ladder.run(2);
		assertEquals(1, target);
		target = ladder.run(1);
		assertEquals(2, target);
		target = ladder.run(3);
		assertEquals(3, target);
	}
	
	public void testRunWhenThreeByOneOneLine2() throws Exception {
		// 0 1 1 의 경우
		Ladder_first ladder = new Ladder_first(3);
		ladder.drawLine(1);
		int target = ladder.run(1);
		assertEquals(1, target);
		target = ladder.run(2);
		assertEquals(3, target);
		target = ladder.run(3);
		assertEquals(2, target);
	}
}
