package exercise17_16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


class RandomOpsTest {

	SecureRandom random;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		random = new SecureRandom();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void filteringRandomIntStreamTest() {
		
		
		List<Integer> result = random.ints(50, 1, 999)
			  .filter(x -> x % 2 == 1)
			  .sorted()
			  .boxed()
			  .collect(Collectors.toList());
		
		result.forEach(System.out::println);
		
		result.forEach((x) -> {
			assertTrue(x % 2 == 1);
		});
//		assertEquals(50, result.stream().count());
			  
		
	}

}
