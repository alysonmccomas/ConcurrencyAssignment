import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.Test;

class sumTest {

	@Test
	void test() {
		ConcurrencyAssignment test = new ConcurrencyAssignment();
		List<Integer> testList = new ArrayList<Integer>();
		
		testList = test.randomNumbers();

		int output1 = test.sum(testList.size(),1);
		int output2 = test.sum(testList.size(), 1);
		assertEquals(output1, output2);
	}

}
