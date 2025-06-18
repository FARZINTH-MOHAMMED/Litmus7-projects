package com.litmus7.studentGrader;

import java.util.Scanner;

/**
 * Used for student report card application Reads the number of students, input
 * their values and print the report card for each student
 * 
 * @author Farzinth Mohammed
 */

public class StudentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the no of students:");
		int studentCount = scanner.nextInt();
		Student[] students = new Student[studentCount];

//		Take input details for each student

		for (int i = 0; i < studentCount; i++) {
			students[i] = new Student();
			System.out.println("Student" + (i + 1) + ":");
			students[i].setInputDetails();
		}
//		print report card for each student

		for (Student eachStudent : students) {
			eachStudent.printReportCard();
		}

		scanner.close();
	}

}
