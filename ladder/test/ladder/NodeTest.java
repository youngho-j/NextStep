package ladder;

import static org.junit.Assert.*;

import org.junit.Test;

// 각 노드의 상태값을 가지고 있는 클래스
public class NodeTest {

	@Test
	public void testCreateCenter() throws Exception {
//		assertEquals(Node.Direction.CENTER, node.getDirection());
		assertEquals(Node.createCenterNode(), Node.createCenterNode());
	}

	@Test
	public void testChangeRight() throws Exception {
		Node node = Node.createCenterNode();
		node.changeRight();
		assertEquals(Node.createRightNode(), node);
	}

	@Test
	public void testChangeLeft() throws Exception {
		Node node = Node.createCenterNode();
		node.changeLeft();
		assertEquals(Node.createLeftNode(), node);
	}

	@Test
	public void testMoveRight() throws Exception {
		Node node = Node.createRightNode();
		Marker marker = node.move(new Marker(3));
		assertEquals(new Marker(4), marker);
	}

	@Test
	public void testMoveLeft() throws Exception {
		Node node = Node.createLeftNode();
		Marker marker = node.move(new Marker(3));
		assertEquals(new Marker(2), marker);
	}

	@Test
	public void testMoveCenter() throws Exception {
		Node node = Node.createCenterNode();
		Marker marker = node.move(new Marker(3));
		assertEquals(new Marker(3), marker);
	}
}
