package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * Vehicle class for storing vehicle details such brand,model and name.
 * 
 * @author Farzinth Mohammed
 */

public class Vehicle {
	private String brand;
	private String model;
	private double rentalPricePerDay;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	public void setRentalPricePerDay(double rentalPricePerDay) {
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Default constructor for vehicle
	 */
	public Vehicle() {
		brand = "default";
		model = "default";
		rentalPricePerDay = 0.0;
	}

	/**
	 * Parameterized constructor for Vehicle class
	 * 
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Method for assigning values to attributes {@code brand} {@code model} and
	 * {@code rentalPricePerDay} from user
	 * 
	 */
	public void setInputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the brand name:");
		brand = scanner.nextLine();
		System.out.println("Enter the model name:");
		model = scanner.nextLine();
		System.out.println("Enter rental price per day:");
		rentalPricePerDay = scanner.nextDouble();

	}

	/**
	 * Method for displaying values {@code brand}, {@code model} and
	 * {@code rentalPricePerDay}.
	 * 
	 * 
	 */
	public void displayDetails() {
		System.out.println("Brand:" + brand);
		System.out.println("Model name:" + model);
		System.out.println("Rental price per day:" + rentalPricePerDay);
	}
}
