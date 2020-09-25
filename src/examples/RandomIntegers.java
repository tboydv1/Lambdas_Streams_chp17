package examples;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class RandomIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SecureRandom randomNumbers = new SecureRandom();
		
		//display 10 random integers on seperate lines
		System.out.println("Random numbers on seperate lines: ");
		randomNumbers.ints(10,1,7)
		.forEach(System.out::println);
		
		//displays 10 random integers on the same line
		String numbers = 
				randomNumbers.ints(10,1,7)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(" "));
		System.out.printf("%nRandom numbers on one line: %s%n",
				numbers);
	}

}
