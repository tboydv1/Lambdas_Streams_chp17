package exercise17_18;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SummingTriplesTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		IntUnaryOperator evenTriples = x -> evenTriples(x);
		
		int result = IntStream.rangeClosed(1,10)
				.map(evenTriples)
				.sum();
		
		assertEquals(90, result);
		
	}
	
	Integer evenTriples(int x) {
		
		if(x % 2 == 0) {
			return x * 3;
		}
		else
			return 0;
	}
	
	

}
