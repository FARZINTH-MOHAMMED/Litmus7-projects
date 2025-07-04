package com.litmus7.vehiclerental.dto;



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

	public boolean hasGear() {
		return hasGear;
	}

	public void setHasGear(boolean hasGear) {
		this.hasGear = hasGear;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
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

}
