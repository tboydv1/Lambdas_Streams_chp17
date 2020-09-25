package exercise17_19;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClassAverage {

	private List<Integer> grades;
	
	Scanner input;
	
	
	public List<Integer> getGrades() {
		return grades;
	}

	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}

	public ClassAverage(Scanner input) {
		
		this.input = input;
		
		grades = new ArrayList<>();
		
	}
	
	public void readGrades(List<Integer> grades) {
		
		this.grades = grades;
	}
	
	public void readGrades() {
		
		
		
		int grade;
		
		System.out.println("Enter grades and -1 to terminate");
		try {
			do {
				
				grade = input.nextInt();
				
				grades.add(grade);
				
				}while(grade != -1);
		}
		catch(InputMismatchException e) {
			
			System.out.println("Invalid Grade");
		}
			
		
	}
	
	public void readGrades(int count) {
		
		
		int grade, counter = 0;
		
		System.out.printf("Enter %d grades seperated by spaces", count);
		
		try {
			while(counter < count) {
				
				grade = input.nextInt();
				
				grades.add(grade);
				
				counter++;
			}
		}
		catch(InputMismatchException e) {
			
			System.out.println("Invalid Grade");
		}
			
		
	}
	
	
	
	public Double getAverage() {
		
		Double average = grades.stream()
			  .mapToDouble(x -> x)
			  .average()
			  .getAsDouble();
		
		return average;
			  
	}
}
