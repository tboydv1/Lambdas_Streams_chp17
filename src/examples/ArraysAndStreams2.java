package examples;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] string = {"Red", "orange", "Yellow", "Blue",
				"indigo", "Violet"};
		
		//display original strings
		System.out.printf("Original strings: %s%n", Arrays.asList(string).toString());
		
		
		//string in uppercase
		System.out.printf("string in uppercase: %s%n", 
				Arrays.stream(string)
					  .map(String::toUpperCase)
					  .collect(Collectors.toList())
				);
		
		//string less that "n" (case insensitive sorted ascending)
		System.out.printf("strings less that n sorted ascending: %s%n", 
					Arrays.stream(string)
						  .filter(s -> s.compareToIgnoreCase("n") < 0)
						  .sorted(String.CASE_INSENSITIVE_ORDER)
						  .collect(Collectors.toList())
				);
		
		//string less than "n" (case insesitive) sorted descending
		System.out.printf("string less than n sorted descending: %s%n",
					Arrays.stream(string)
						  .filter(s -> s.compareToIgnoreCase("n") < 0)
						  .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
						  .collect(Collectors.toList())
				);
		
	}

}
