package exercise17_19;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassAverageTest {

	ClassAverage grades;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Scanner input = new Scanner(System.in);
		grades = new ClassAverage(input);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void readgradesTest() {
		
		grades.readGrades(4);
		
		assertEquals(4, grades.getGrades().size());
		
		System.out.println(grades.getAverage());
	}
	
	@Test
	void calculateGradesAverageTest() {
		
		
		Integer[] class01 = {30, 40, 80, 70};
		List<Integer> school = Arrays.asList(class01);
		
		grades.readGrades(school);
		
		assertEquals(55.0, grades.getAverage());
		
	}

}
