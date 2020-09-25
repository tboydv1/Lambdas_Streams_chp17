package exercise17_23;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonsTest {

	Person[] personObj = {
			
			
			new Person("Joseph","Ebuka"),
			new Person("Olamide","David"),
			new Person("Tomi","Davids"),
			new Person("Janet","Jones"),
			new Person("Blessing","Davids"),
			new Person("Tom","Jones"),
			new Person("Mike","Mel"),
			new Person("Chinedu","Samuel"),
			new Person("Uzor","Jones"),
			new Person("Florence","James"),
			new Person("Chris","Rode"),
			
			};
	
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
	void locateFirstPersonWithlastNameJonesTest() {
		
		List<Person> persons = Arrays.asList(personObj);
		
		Predicate<Person> lastName = (x) -> x.getLastName().equals("Jones");
		
		Person result = persons.stream()
			   .filter(lastName)
			   .findFirst()
			   .get();
		
		assertTrue(result.getFirstName().equals("Janet") && result.getLastName().equals("Jones"));
		
	}
	
	

}
