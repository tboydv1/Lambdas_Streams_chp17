package exercise17_21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	GradeBook sys;
	
	Integer[][] gradesArray = {{87, 96, 70},
			 {68, 87, 90},
			 {94, 100, 90},
			 {100, 81, 82},
			 {83, 65, 85},
			 {78, 87, 65},
			 {85, 75, 83},
			 {91, 94, 100},
			 {76, 72, 84},
			 {87, 93, 73}};

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		
		sys = new GradeBook(gradesArray);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void calculateAverageGradesTest() {
		
		Double result = sys.calculateScoresAverage();
		
		System.out.println(result);
		
		
	}
	
	@Test
	void calculateAverageTest() {
		
		
		Integer[][] grades = {{55, 45, 50},{75, 89, 56}};
		
		GradeBook sys2 = new GradeBook(grades);
		
		Double result = sys2.calculateScoresAverage();
		
		assertEquals(62,  Math.round(result));
		
	}
	
	
	

}
