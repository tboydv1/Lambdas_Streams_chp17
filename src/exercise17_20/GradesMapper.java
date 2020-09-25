package exercise17_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GradesMapper {

	private List<Integer> scores;
	
	
	public GradesMapper(List<Integer> grades) {
		
		this.scores = grades;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> grades) {
		this.scores = grades;
	}
	
	public Map<Character, List<Integer>> mapScoresToGrades(){
		
		
		Map<Character, List<Integer>> gradeMap;
		
		gradeMap = getScores().stream()
				   .collect(Collectors.groupingBy((g) -> getGrade(g)));
		
		return gradeMap;
		
		
	}
	
	public List<Character> displayScoresGrade() {
		
		List<Character> grades =
		getScores().stream()
				   .map(grade -> getGrade(grade))
				   .collect(Collectors.toList());
		
		return grades;
		
	}
	
	
	private Character getGrade(int grade) {
		
		if(grade > 70 && grade <= 100) {
			
			return 'A';
			
		}
		else if(grade >= 65 && grade < 70){
			
			return 'B';
		}
		else if(grade >= 55 && grade < 65){
			
			return 'C';
		}
		else if(grade >= 40 && grade < 55){
			
			return 'D';
		}
		else if(grade < 40 && grade > 0){
			
			return 'F';
		}
		else
			return null;
		
		
	}
	
}
