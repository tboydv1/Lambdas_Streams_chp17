package examples;

import java.util.Random;
import java.util.function.Function;
//import java.util.function.;
import java.util.stream.Collectors;

public class RandomIntsStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		
		//roll a die 60,000,000 times and summarize the results
		System.out.printf("%-6s%s%n", "Face", "Frequency");
		
		random.ints(60_000, 1, 7)
			  .boxed()
			  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			  .forEach((face, frequency) -> System.out.printf("%-6d%d%n", face, frequency));
	}

}
