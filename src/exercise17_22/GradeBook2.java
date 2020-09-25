package exercise17_22;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GradeBook2 {
	
	
	private Integer[][] examGrades ;
	
	
	public GradeBook2(Integer[][] grades) {
		examGrades = grades;
		
	}


	public Integer[][] getExamGrades() {
		return examGrades;
	}


	public void setExamGrades(Integer[][] examGrades) {
		this.examGrades = examGrades;
	}
	
	
	public IntStream calcualteEachStudentAverage() {
		
		IntStream studentAverages = Stream.of(getExamGrades())
			  .flatMapToInt((x)-> IntStream.of(average(x)));
		
		return studentAverages;
	}
	
	Integer average(Integer[] scores) {
		
		int total = 0;
		
		for(Integer score: scores) {
			
			total += score;
		}
		
		return (Integer)total/scores.length;
		
	}
}
