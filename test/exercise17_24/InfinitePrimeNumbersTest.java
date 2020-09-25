package exercise17_24;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfinitePrimeNumbersTest {

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
	void infinitePrimeTest() {
		
		
		IntPredicate isPrime = (x) -> primeCheck(x);
		
		IntUnaryOperator prime = ((x) -> {return x + 1;});
		
		int userLimit = getUserInput();
		
		
		IntStream.iterate(2, prime)
				 .filter(isPrime)
				 .limit(userLimit)
				 .forEach((x)-> {
					 
					 assertTrue(primeCheck(x) == true);
					 
					 System.out.println(x);
				 });
//		
		
		
		
	}
	@Test
	void generatePrimeNumbersTest(){
		
		IntStream.rangeClosed(2, 50)
				 .filter(x ->  primeCheck(x))
				 .forEach((x) -> {
					 
					 assertTrue(primeCheck(x) == true);
					 
					 System.out.println(x);
				 });
	}
	
	boolean primeCheck(int n) {
		
		for(int i = 2; i <= n/2; i++) {
			
			if(n%2 == 0) {
			
				return false;
			}
		}
		
			return true;
		
	}
	
	int getUserInput() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter limit");
		int value = input.nextInt();
		
		return value;
	}

}
