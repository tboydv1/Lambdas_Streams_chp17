package examples;

import java.util.stream.IntStream;

public class StreamFilterMapReduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.out.printf("Sum of the triples of even ints from 2 through 10 is: %d%n",
					IntStream.rangeClosed(1,10)
							 .filter( 
								x ->
							 	{System.out.printf("%nfilter : %d%n", x);
							 	return x % 2 == 0;
							 	})
							 .map(
								x -> {
								System.out.printf("%nmap : %d%n", x);
								return x * 3;
								})
							 .sum());
	}

}
