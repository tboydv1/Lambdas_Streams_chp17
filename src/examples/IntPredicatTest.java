package examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntPredicatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Int predicate method test
		 
		 Integer[] arr = {1,2,6,7,4,5,3,8,8,6,16,27,28,20};
		 
		 List<Integer> values = Arrays.asList(arr);
		 
		 Predicate<Integer> even = x -> x % 2 == 1;
		 
		 
		 Predicate<Integer> greaterThan5 = x -> x >= 5;
		 
		 System.out.printf("%n%s%n",
		 values.stream()
		 	   .filter(even.and(greaterThan5))
		 	   .map(String::valueOf)
		 	   .collect(Collectors.joining(" ")));
	}

}
