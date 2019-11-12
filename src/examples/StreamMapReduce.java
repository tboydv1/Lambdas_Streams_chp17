package examples;

import java.util.stream.IntStream;

public class StreamMapReduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.printf("Sum of even ints from 2 through 20 is %d%n",
				
				IntStream.rangeClosed(1, 10)
						 .map((int x) -> {return x * 2;})
						 .sum());
		
//		() -> System.out.println("Welcome to lambdas");
		
	}

}
