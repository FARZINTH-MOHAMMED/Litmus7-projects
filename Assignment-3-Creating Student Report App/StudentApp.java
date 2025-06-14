package com.litmus7.student;

import java.util.Scanner;

public class StudentApp {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] s;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the no of students:");
		int x=scanner.nextInt();
		s=new Student[x];
		for(int i=0;i<x;i++) {
			s[i]=new Student();
			System.out.println("Student"+(i+1)+":");
			s[i].setInputDetails();
		}
		
		for(int i=0;i<x;i++) {
			s[i].printReportCard();
		}
	}

}
