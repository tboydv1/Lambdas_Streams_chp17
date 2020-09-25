package exercise17_14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomOperationsTest {

	Letters myLetters;
	RandomOperations obj;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		Character[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L',
				'N','M','O','P','Q','R','S','T','U','V', 'W', 'X', 'Y', 'Z'};
		
		myLetters = new Letters(alpha);
		
		obj = new RandomOperations(new ArrayList<>());
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void classNotNullTest() {
		
		assertNotNull(myLetters);
		assertNotNull(obj);
	}

	@Test
	void insert30RandomLettersTest() {
		
		obj.insert30letters(myLetters);
		
		assertThat(obj.getLetters().size(), is(30));
		
		obj.getLetters().forEach(System.out::println);
	}
	
	@Test
	void sortListInAscendingOrderTest() {
		
		
		obj.insert30letters(myLetters);
		
		assertThat(obj.getLetters().size(), is(30));
		obj.getLetters().forEach(System.out::println);
		
		List<Character> result = obj.getLetters();
		System.out.println();
		
		obj.sortInAscending();
		
		List<Character> newResult = obj.getLetters();
		
		assertNotSame(result, newResult);
		obj.getLetters().forEach(System.out::println);
		
	}
	
	@Test
	void sortListInAscendingOrderRemovingDuplicatesTest() {
		
		
		obj.insert30letters(myLetters);
		
		assertThat(obj.getLetters().size(), is(30));
		obj.getLetters().forEach(System.out::println);
		
		List<Character> result = obj.getLetters();
		System.out.println();
		
		obj.UniqueSort();
		
		List<Character> newResult = obj.getLetters();
		
		assertNotSame(result, newResult);
		obj.getLetters().forEach(System.out::println);
		
	}

}
