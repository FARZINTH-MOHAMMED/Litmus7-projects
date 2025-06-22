package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * Bike class inheriting {@code Vehicle} class including bike specifc
 * attributes.
 * 
 * @author Farzinth Mohammed
 */
public class Bike extends Vehicle {
	private boolean hasGear;
	private int engineCapacity;

	/**
	 * Default constructor
	 */
	public Bike() {
		hasGear = false;
		engineCapacity = 0;
	}

	/**
	 * Parameterized constructor with invoking {@code Vehicle} class parameterized
	 * constructor.
	 * 
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 * @param hasGear
	 * @param engineCapacity
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Overriding {@code setInputDetails} of vehicle and inputing bike specific
	 * details like {@code hasGear} and {@code isAutomatic}.
	 */
	@Override
	public void setInputDetails() {
		super.setInputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Does bike has gear?");
		hasGear = scanner.nextBoolean();
		System.out.println("Enter engine capacity:");
		engineCapacity = scanner.nextInt();

	}

	/**
	 * Overrides Vehicle's {@code displayDetails} and display bike specific details
	 * values such as {@code hasGear} and {@code engineCapacity}.
	 */
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Is bike with gear:" + hasGear);
		System.out.println("Bike engine capacity:" + engineCapacity);
		System.out.println("-------------");
	}
}
