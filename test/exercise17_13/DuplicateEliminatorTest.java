package exercise17_13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DuplicateEliminatorTest {
	
	DuplicateEliminator obj;
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		obj = new DuplicateEliminator();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void sortWordsInAplhabeticalOrder() {
		
		List<String> result = obj.getUniqueWords("This is An example tEst");
		
//		result.add("Yess");
		result.forEach(System.out::println);
		
	}
	
	@Test
	void printLettersAlphabetically() {
		
		String word = "This is a sentence all";
		
		char l;
		for(int i = 0; i < word.length(); i++) {
			
			l = word.charAt(i);
			
			
			
		}
		
	}
	


}
