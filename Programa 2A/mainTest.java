import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class mainTest {
	@Test
	public void testC1() {
		assertEquals("1 2 4 5 3\n", main.resolve("5\n1 102 2 62\n1 128 3 127\n1 144 4 80\n1 102 5 101\n2 62 3 61\n2 100 4 80\n2 88 5 82\n3 79 4 90\n3 87 5 100\n4 110 5 99\n"));
	}
}