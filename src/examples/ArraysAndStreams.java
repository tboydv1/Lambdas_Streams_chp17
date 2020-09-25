package examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] values = {2, 9, 5, 0, 7, 1, 4, 8, 6};
		
		//displays original values
		System.out.printf("Original values: %s%n", Arrays.asList(values));
		
		//sort values in ascending order with streams
		System.out.printf("Sorted values: %s%n", Arrays.stream(values)
													   .sorted()
													   .collect(Collectors.toList()));
		
		//values greater than 4
		
		List<Integer> greaterThan4 = 
				Arrays.stream(values)
					  .filter(value -> value > 4)
					  .collect(Collectors.toList());
		
		//filter values greater than 4 then sort the resultd
		System.out.printf("values greater than 4: %s%n", 
						greaterThan4);
		
		//filter values greater that 4 and sort the results
		System.out.printf("Sorted values greater than 4: %s%n",
				Arrays.stream(values)
					  .filter(value -> value > 4)
					  .sorted()
					  .collect(Collectors.toList())
				);
		
		//greater than 4 list sorted with streams
		System.out.printf("Values greater than 4 (ascending with streams): %s%n", 
								greaterThan4.stream()
											.sorted(Comparator.reverseOrder())
											.collect(Collectors.toList()));
		
		
		
	}

}
