package com.litmus7.vehiclerental.dto;

import java.util.Objects;

/**
 * Vehicle class for storing vehicle details such brand,model and name.
 * 
 * @author Farzinth Mohammed
 */

public class Vehicle {
	private String brand;
	private String model;
	private double rentalPricePerDay;
	private boolean isRented = false;

	@Override
	public int hashCode() {
		return Objects.hash(brand, model, rentalPricePerDay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(model, other.model)
				&& Double.doubleToLongBits(rentalPricePerDay) == Double.doubleToLongBits(other.rentalPricePerDay);
	}

	@Override
	public String toString() {

		return brand + ":" + model;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

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

}
