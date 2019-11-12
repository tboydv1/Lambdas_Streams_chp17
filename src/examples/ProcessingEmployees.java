package examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee[] employees = {
				
			new Employee("Jason", "Red",5000, "IT"),
			new Employee("Ashley", "Green", 7600, "IT"),
			new Employee("Mathew", "Indigo",3587.5, "Sales"),
			new Employee("James", "Indigo", 4700.77,"Marketing"),
			new Employee("Luke", "Indigo", 6200, "IT"), 
			new Employee("Jason", "Blue", 3200,"Sales"),
			new Employee("Wendy","Brown", 4236.4, "Marketing")
		
		};
		
		
	
	
	//get list view of the Employeees
	
	List<Employee> list = Arrays.asList(employees);
	
	//display all employees
	System.out.println("Complete Employee list:");
	list.stream().forEach(System.out::println);
	
	//predicate returns true for salaries in the range $4000-$6000
	
	Predicate<Employee> fourToSixThousand =
			e -> (e.getSalary() >= 9000 && e.getSalary() <= 11000);
	
	//display Employees with salaries in the specified range
			//sorted in ascending order 
		System.out.printf("%nEmployees earning $4000-$6000 per month sorted by salary:%n");
				list.stream()
					.filter(fourToSixThousand)
					.sorted(Comparator.comparing(Employee::getSalary))
					.forEach(System.out::println);
				
					
		Optional<Employee> result;

		result = list.stream()
			.filter(fourToSixThousand)
			.findFirst();
		
		//Display first Employee with salary in the range $4000-$6000
		System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
				result.isPresent() ? result.get() : "No result!"); 
		
				
	//Function for getting the first and last name from an Empoloyee
			Function<Employee, String> byFirstName = Employee::getFirstName;
			Function<Employee, String> byLastName = Employee::getLastName;
			
			//Comparator for comparing Employees by firstName then last name
			Comparator <Employee> lastThenFirst = 
					Comparator.comparing(byLastName).thenComparing(byFirstName);
			
	//sort employee by last name , then first name
			System.out.printf("%nEmployees in ascending order by last name the first:%n");
			
			list.stream()
				.sorted(lastThenFirst)
				.forEach(System.out::println);
			
			// sort employees in descending order by last name, then first name
			 System.out.printf(
			 "%nEmployees in descending order by last name then first:%n");
			 list.stream()
			 .sorted(lastThenFirst.reversed())
			 .forEach(System.out::println);
			 
			 
		Consumer<String> println = System.out::println;
	//display unique employee last names sorted
			 System.out.printf("%nUnique employee last names:%n");
			 list.stream()
			 .map(Employee::getLastName)
			 .distinct()
			 .sorted()
			 .forEach(println);
			 
			 
	//display only first and last names
			 System.out.printf("%nEmployee names in order by last then first name:%n");
			 list.stream()
			 	 .sorted(lastThenFirst)
			 	 .map(Employee::getName)
			 	 .forEach(println);
	
	//group  Employee by department
			 System.out.printf("%nEmployees by department:%n");
			 
			 Map<String, List<Employee>> groupedByDepartment = 
					 list.stream()
					 .collect(Collectors.groupingBy(Employee::getDepartment));
			 
			 System.out.println(groupedByDepartment);
			 
			 
		groupedByDepartment.forEach((department, employeesInDepartment) -> {    
			
			System.out.printf("%n%s%n", department);
			employeesInDepartment.forEach(employee -> System.out.printf("%s%n", employee));
				
				}); 
		
		//count number of Employees in each department
		System.out.printf("%nCount of Employees by department:%n");
		Map<String, Long> employeeCountByDepartment = 
				list.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		
		employeeCountByDepartment.forEach((department, count) -> System.out.printf("%s has %d employee(s)%n", department, count));
		
		//sum of Employee salaries with DoubleStream sum method
		System.out.printf("%nSum of Employees' salaries (via sum method): %.2f%n",
				list.stream()
					.mapToDouble(Employee::getSalary)
					.sum()
					);
		
		//calculate sum of Employee salaries with stream reduce methos
		System.out.printf("Sum of Employees' salaries (via reduce method): %.2f%n", 
					list.stream()
					.mapToDouble(Employee::getSalary)
					.reduce(0, (value1, value2) -> value1 + value2)
					);
		
		
		//average of Employee salaries with DoubleStream average method
		System.out.printf("Average of Employees' salaries: %.2f%n", 
				list.stream()
					.mapToDouble(Employee::getSalary)
					.average()
					.getAsDouble()
				);
			 	
			 
			 
	
			
	}
	
}
