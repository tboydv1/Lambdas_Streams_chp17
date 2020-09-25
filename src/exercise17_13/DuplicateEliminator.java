package exercise17_13;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class DuplicateEliminator {

	
	public List<String> getUniqueWords(String sentence) {
		
		Pattern pattern = Pattern.compile("\\.*");
		
		List<String> letters  =  Arrays.asList(pattern.split(sentence));
		

		Predicate<String> alpha = ((x) -> x.matches("[a-z]"));
		
		
				
		List<String> alphabets = 
				  letters.stream()
				  .map(String::toLowerCase)
				  .filter(alpha)
			  	  .distinct()
			  	  .sorted()
			  	  .collect(Collectors.toList());
		
		
		return alphabets;
			  
	}
}
