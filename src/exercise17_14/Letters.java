package exercise17_14;

import java.util.Arrays;
import java.util.List;

public class Letters {

	private List<Character> alphabets;
	
	public Letters(Character[] initial) {
		
		alphabets = Arrays.asList(initial);
	}

	public List<Character> getAlphabets() {
		return alphabets;
	}

	public void setAlphabets(List<Character> alphabets) {
		this.alphabets = alphabets;
	}
	
	
	
	
}
