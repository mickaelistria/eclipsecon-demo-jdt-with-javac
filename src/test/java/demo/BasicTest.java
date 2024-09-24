package demo;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class BasicTest {

	final int YEAR = Calendar.getInstance().get(Calendar.YEAR); 

	private boolean areWeIn2024() {
		return YEAR == 2024;
	}
	
	@Test
	void test() {
		assertTrue(areWeIn2024());
	}

}
