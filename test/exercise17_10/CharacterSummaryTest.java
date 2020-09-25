package exercise17_10;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharacterSummaryTest {

	CharacterSummary summary;
	MyFile fileObj;
	
	@BeforeEach
	void setUp() throws Exception {
		
		summary = new CharacterSummary();
		
		fileObj = new MyFile(Paths.get("/home/oluwatobi/Dev/java_project/chapter17/src/file.txt"));
	}

	@AfterEach
	void tearDown() throws Exception {
		
		
	}

	@Test
	void FileExistTest() {
		
		assertNotNull(fileObj.getFile());
		
		
		
		
	}
	
	@Test 
	void characterCountTest() throws IOException {
	
		assertNotNull(summary);
		
		Map<String , Long> charCount = summary.countCharacterOccurence(fileObj);
		
		charCount.entrySet()
				 .stream()
				 .collect(Collectors.groupingBy(Function.identity()))
				 .forEach((c, v) -> {
					 
					 System.out.printf("%-5S%n", v.listIterator().next());
					 
				 });
		
	}
	
	
	@Test
	void randomTest() {
		
		String word = "Welcome, to, lamdas,";
		
		String[] arr;
		
		arr = word.split("\\.*");
		
		for(String l : arr) {
//			System.out.println("running");
			System.out.print(l + " ");
		}
	}

}
