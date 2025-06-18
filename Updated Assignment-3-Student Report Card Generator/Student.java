package com.litmus7.studentGrader;

import java.util.Scanner;

/**
 * This class is used to input student details, calculate student grades from
 * marks and print report card
 * 
 * @author Farzinth Mohammed
 */
public class Student {
	private String name;
	private int rollNo;
	private int[] marks = new int[5];

	/**
	 * This enum is used to predefine grades and description
	 */
	private enum Grades {
		A("Excelent"), B("Good"), C("Average"), D("Pass"), F("Fail");

		String description;

		/**
		 * This constructor sets description for the grades
		 * 
		 * @param description- String value for the grade description
		 */
		Grades(String description) {
			this.description = description;
		}

		/**
		 * This method returns the description for the grade
		 * 
		 * @return String value for the grade description.
		 */
		public String getDescription() {
			return description;
		}
	}

	/**
	 * Reads student details from standard input including name, roll number, and 5
	 * subject marks.
	 */
	public void setInputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student name:");
		name = scanner.nextLine();

		System.out.print("Enter roll number:");
		rollNo = scanner.nextInt();
		System.out.println("Enter marks in 5 subjects:");
		for (int i = 0; i < 5; i++) {
			System.out.print("Subject " + (i + 1) + ":");
			marks[i] = scanner.nextInt();
		}

	}

	/**
	 * Calculates the total marks
	 * 
	 * @return integer value of total marks
	 */

	private int calculateTotal() {
		int sum = 0;
		for (int eachSubjectMark : marks) {
			sum += eachSubjectMark;
		}
		return sum;
	}

	/**
	 * Calculates the average value
	 * 
	 * @return double of average value
	 */
	private double calculateAverage() {

		return calculateTotal() / 5;
	}

	/**
	 * Getter for returning grade from average mark
	 * 
	 * @return enum Grade value of grade
	 */
	private Grades getGrade() {

		double average = calculateAverage();
		if (average >= 90) {
			return Grades.A;
		} else if (average >= 75)
			return Grades.B;
		else if (average >= 60)
			return Grades.C;
		else if (average >= 50)
			return Grades.D;
		else
			return Grades.F;
	}

	/**
	 * Print the report card with name,roll number, marks and grade
	 */

	public void printReportCard() {
		System.out.println("\n---Report Card---");
		System.out.println("Name:" + name);
		System.out.println("Roll Number:" + rollNo);
		System.out.println("Total marks scored:" + calculateTotal());
		System.out.println("Average marks:" + calculateAverage());
		System.out.println("Grade:" + getGrade() + ":" + getGrade().getDescription());
	}

}
