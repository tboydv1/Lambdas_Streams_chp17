package examples;

public class Employee {
	
	private String firstName;
	private String lastName;
	private double salary;
	private String department;
	
	public Employee(String firstName, String lastName, double salary, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	//return a string containing the Employees info
	@Override
	public String toString() {
		
		return String.format("%-8s %-8s %8.2f %s", getFirstName(), getLastName(),
				getSalary(), getDepartment());
	}
	
	public String getName() {
		
		return String.format("%s %s", getFirstName(), getLastName());
	}
	
	
	
	
}
