package exercise17_20;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradesMapperTest {

	GradesMapper system;
	
	
	List<Integer> examGrades;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void mapScoresToGradesTest() {
		
		Integer[] grades = {45, 67, 86, 69, 90, 74};
		
		examGrades = Arrays.asList(grades);
		
		system = new GradesMapper(examGrades);
		
		Map<Character, List<Integer>> result = system.mapScoresToGrades();
		
		result.entrySet()
			  .forEach(System.out::println);
		
		
	}
	
	@Test
	void displayScoresGradeTest() {
		
		Integer[] grades = {45, 67, 86, 69, 90, 74};
		
		examGrades = Arrays.asList(grades);
		
		system = new GradesMapper(examGrades);
		
		List<Character> result  = system.displayScoresGrade();
		
		result.forEach(System.out::println);
		
		assertEquals(result.get(0), 'D');
		assertEquals(result.get(1), 'B');
		assertEquals(result.get(2), 'A');
		assertEquals(result.get(3), 'B');
		assertEquals(result.get(4), 'A');
		assertEquals(result.get(5), 'A');
		

	}

}
