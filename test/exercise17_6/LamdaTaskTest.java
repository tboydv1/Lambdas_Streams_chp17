package exercise17_6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LamdaTaskTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/*
	 * Write a lambda expression that receives two double parameters
		a and b and returns their product. Use the lambda form that
		explicitly lists the type of each parameter.
	 */
	@Test
	void productTest() {
		
		
		int product = IntStream.of(5, 2)
				 .reduce(1, (int x, int y) -> {return x * y;});
		
		assertEquals(10, product);
		
		product = IntStream.of(3, 4)
						   .reduce(1, (x, y) -> x * y);
		
		assertEquals(12, product);
	}

	/*Write a no-argument lambda that implicitly returns the string
	*"Welcome to lambdas!"
	*/
	
	@Test
	void LambaMessage() {
		
		Supplier<String> message =  () ->  ("Welcome to lambdas!");
		
		System.out.println(message.get());
		assertTrue("Welcome to lambdas!".equals(message.get()));
	}
	
	/*
	 * Write a constructor reference for class ArrayList.
	 */
	
	@Test 
	void constructorReferenceTest() {
		
		@SuppressWarnings("unused")
		Supplier<List<String>> list = () -> new ArrayList<String>();
		
	}
	
	

}
