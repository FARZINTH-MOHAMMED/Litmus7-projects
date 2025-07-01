package com.litmus7.vehiclerental.dto;

import java.util.Objects;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return isAutomatic == other.isAutomatic && numberOfDoors == other.numberOfDoors;
	}

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
		numberOfDoors = 4;
		isAutomatic = false;

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

}
