package examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreaOfLines {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
 
	//regex that matches one or more consecutive whitespace characters
		
		Pattern pattern = Pattern.compile("\\s+");
		
		//count occurrence of each word in a stream<String> sorted by words
		
		Map<String, Long> wordCounts =
				Files.lines(Paths.get("/home/oluwatobi/Dev/java_project/chapter17/src/file.txt"))
					 .flatMap(line -> pattern.splitAsStream(line))
					 .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));
		
		
		//displays the words grouped by starting letter
		wordCounts.entrySet()
				  .stream()
				  .collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0),
						  TreeMap::new, Collectors.toList()))
				  .forEach((letter, wordList) -> {
					  
					  System.out.printf("%n%C%n", letter);
					  wordList.stream().forEach(word -> System.out.printf("%13s: %d%n", word.getKey(), word.getValue()));
				  });
			











	}

}
