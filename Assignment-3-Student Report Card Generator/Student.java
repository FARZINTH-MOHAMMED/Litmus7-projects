package com.litmus7.student;

import java.util.Scanner;


public class Student {
	private String name;
	private int rollNo;
	private int[] marks=new int[5];
	private enum Grade{
		A,B,C,D,F
	}
	
	public void setInputDetails() {
		Scanner scanner= new Scanner(System.in);
		System.out.print("Enter student name:");
		name= scanner.nextLine();
		
		System.out.print("Enter roll number:");
		rollNo=scanner.nextInt();
		System.out.println("Enter marks in 5 subjects:");
		for(int i=0;i<5;i++) {
			System.out.print("Subject "+(i+1)+":");
			marks[i]=scanner.nextInt();
		}

	}
	
	private int calculateTotal() {
		int sum=0;
		for(int i=0;i<5;i++) {
			sum+=marks[i];
		}
		return sum;
	}
	
	private double calculateAverage() {
		double average=calculateTotal()/5;
		return average;
	}
	
	
	private Grade getGrade() {
		
		double average=calculateAverage();
		if(average>=90) {
			return Grade.A;
		}
		else if(average >=75) return Grade.B;
		else if(average>=60) return Grade.C;
		else if(average>=50) return Grade.D;
		else return Grade.F;
	}
	
	public void printReportCard() {
		System.out.println("\n---Report Card---");
		System.out.println("Name:"+name);
		System.out.println("Roll Number:"+rollNo);
		System.out.println("Total marks scored:"+calculateTotal());
		System.out.println("Average marks:"+calculateAverage());
		System.out.println("Grade:"+getGrade());
	}

}

