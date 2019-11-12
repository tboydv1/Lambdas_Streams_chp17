package exercise17_10;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CharacterSummary {

	
	public Map<String, Long> countCharacterOccurence(MyFile file) throws IOException {
		
		Pattern pattern = Pattern.compile("\\.*");
		
		Map<String, Long> characterCount = 
				Files.lines(file.getFile())
					 .flatMap(line -> pattern.splitAsStream(line))
					 .filter(c -> c.matches("[a-zA-Z]"))
					 .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));
		
		
		return characterCount;
		
	}
	
}
