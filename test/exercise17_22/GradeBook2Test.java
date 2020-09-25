package exercise17_22;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBook2Test {
	
	GradeBook2 obj;
	
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
	void studentAveragesTest() {
		
		Integer[][] grades = {{55, 45, 50},{75, 89, 56}};
		
		obj = new GradeBook2(grades);
		
		IntStream result = obj.calcualteEachStudentAverage();
		
		assertEquals(50, result.findFirst().getAsInt());
		
	}
	
	@Test
	void allStudentAverageTest() {
		
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
		
		GradeBook2 sys = new GradeBook2(gradesArray);
		
		sys.calcualteEachStudentAverage().forEach(System.out::println);
	}

}
