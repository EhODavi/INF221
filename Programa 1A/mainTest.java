import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class mainTest {
	@Test
	public void testC1() {
		assertEquals("Y\n", main.resolve("2 2\n25 50\n50 50\n0 0\n"));
	}
	
	@Test
	public void testC2() {
		assertEquals("N\n", main.resolve("2 2\n75 75\n50 50\n0 0\n"));
	}
}
