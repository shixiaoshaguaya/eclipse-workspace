package Ex1126;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	private static Calculator calculator = new Calculator();

	@BeforeEach
	void setUp() throws Exception {
		calculator.clear();
	}

	@Test
	void testAdd() {
		calculator.add(2);
		calculator.add(3);
		assertEquals(5, calculator.getResult());
	}

	@Test
	void testSubstract() {
		calculator.add(10);
		calculator.substract(2);
		assertEquals(8, calculator.getResult());
	}
	
	@Ignore("Multiply() Not yet implemented")
	@Test
	void testMultiply() {
		
	}

	@Test
	void testDivide() {
		calculator.add(8);
		calculator.divide(2);
		assertEquals(4, calculator.getResult());
	}

}
