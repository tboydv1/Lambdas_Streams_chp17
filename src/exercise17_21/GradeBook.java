package exercise17_21;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GradeBook {

	private Integer[][] examGrades;
	
	public GradeBook(Integer[][] grades) {
		
		this.examGrades = grades;
		
	}
	
	Double  calculateScoresAverage() {
		
	
		
		Double result = Stream.of(examGrades)
			  .flatMapToInt((x) -> IntStream.of((sum(x))))
			  .average()
			  .getAsDouble();
			  
		return result;
	}
	
	Integer sum(Integer[] args) {
		
		int total  = 0;
		
		for(int value: args) {
			total += value;
		}
		
		int average = total / args.length;
		
		return average;
	}
	
	
}
