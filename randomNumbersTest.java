import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class randomNumbersTest {

	@Test
	void test() {
		ConcurrencyAssignment test = new ConcurrencyAssignment();
		int output = test.randomNumbers().size();
		assertEquals(200000000, output);
	}

}
