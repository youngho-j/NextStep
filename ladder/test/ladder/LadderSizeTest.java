package ladder;

import static org.junit.Assert.*;

import org.junit.Before;

public class LadderSizeTest {
	
	private LadderSize size;
	
	@Before
	public void setUp() throws Exception {
		size = LadderSize.create(3, 4);
	}
}
