package exercise17_17;

import examples.Employee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EmployeeStreamTest {

	Employee[] employees = {
			
			new Employee("Jason", "Red",5000, "IT"),
			new Employee("Ashley", "Green", 7600, "IT"),
			new Employee("Mathew", "Indigo",3587.5, "Sales"),
			new Employee("James", "Indigo", 4700.77,"Marketing"),
			new Employee("Luke", "Indigo", 6200, "IT"), 
			new Employee("Jason", "Blue", 3200,"Sales"),
			new Employee("Wendy","Brown", 4236.4, "Marketing")
		
		};
	
	List<Employee> employeeList;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		employeeList = Arrays.asList(employees);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void calculateAverageEmployeeSalariesByDepartmentTest() {
		
		Map<String, List<Employee>> groupedByDepartment = 
				employeeList.stream()
							.collect(Collectors.groupingBy(Employee::getDepartment));
		
		groupedByDepartment.forEach((dept, emp) -> {
				
			System.out.printf("Average salaries for %s department is %.2f%n", dept,
					emp.stream()
					   .mapToDouble(Employee::getSalary)
					   .average()
					   .getAsDouble());
		});
	}

}
