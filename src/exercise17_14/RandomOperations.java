package exercise17_14;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class RandomOperations {

	private List<Character> letters;
	
	Random rand = new Random();
	
	public RandomOperations(List<Character> type) {
		
		this.letters = type;
	}
	
	
	
	
	public List<Character> getLetters() {
		return letters;
	}




	public void setLetters(List<Character> letters) {
		this.letters = letters;
	}




	public void insert30letters(Letters alpha) {
		
		rand.ints(30, 0, 26)
			.forEach((x) -> {
				
				letters.add(alpha.getAlphabets().get(x));
			});
	}
	
	public void sortInAscending() {
		
		letters = letters.stream()
					     .sorted()
					     .collect(Collectors.toList());
	}
	
	public void UniqueSort() {
		
		letters = letters.stream()
					     .sorted()
					     .distinct()
					     .collect(Collectors.toList());
	}
}
