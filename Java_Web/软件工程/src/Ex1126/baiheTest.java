package Ex1126;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class baiheTest {
	private baihe baihe = new baihe();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAaa() {
		baihe.aaa(60, 60);
		assertEquals(1, baihe.aaaReturn());
		baihe.aaa(70, 10);
		assertEquals(2, baihe.aaaReturn());
		baihe.aaa(30, 30);
		assertEquals(3, baihe.aaaReturn());
	}

}
