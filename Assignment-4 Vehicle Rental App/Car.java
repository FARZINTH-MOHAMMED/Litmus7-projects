package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * Car class extends the vehicle and inlcuding features like number of doors and
 * is Automatic.
 * 
 * 
 * @author Farzinth Mohammed
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public boolean isAutomatic() {
		return isAutomatic;
	}

	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Default constructor for Car.
	 */
	public Car() {
		super();
		numberOfDoors=4;
		isAutomatic=false;
		
	}

	/*
	 * Parameterized constructor for Car by calling Vehicle's parameterized
	 * constructor.
	 */

	/**
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 * @param numberOfDoors
	 * @param isAutomatic
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Overriding {@code setInputDetails} of vehicle and inputing car specific
	 * details like {@code numberOfDoors} and {@code isAutomatic}.
	 *
	 */
	@Override

	public void setInputDetails() {
		System.out.println("---Enter Car Details---");
		super.setInputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of doors:");
		numberOfDoors = scanner.nextInt();
		System.out.println("Is the car Automatic?");
		isAutomatic = scanner.nextBoolean();

	}

	/**
	 * 
	 *  Overrides Vehicle's {@code displayDetails} and display car
	 * specific details values such as {@code numberOfDoors} and {@code isAutomatic}
	 *
	 */
	@Override
	public void displayDetails() {
		System.out.println("---Displaying Car Details---");
		super.displayDetails();
		System.out.println("Number of doors:" + numberOfDoors);
		System.out.println("Automatic:" + isAutomatic);

	}

}
