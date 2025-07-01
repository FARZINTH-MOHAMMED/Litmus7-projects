package com.litmus7.vehiclerental.dto;

import java.util.Objects;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		return engineCapacity == other.engineCapacity && hasGear == other.hasGear;
	}

	/**
	 * Default constructor
	 */
	public Bike() {
		hasGear = false;
		engineCapacity = 0;
	}

	public boolean isHasGear() {
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
