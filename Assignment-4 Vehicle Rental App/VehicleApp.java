package com.litmus7.vehiclerental;

import com.litmus7.vehiclerental.dto.*;

/**
 * The {@code VehicleApp} class serves as the entry point of the application. It
 * creates {@code Car} and {@code Bike} objects, take input values and display
 * values for these objects
 * 
 * @author Farzinth Mohammed
 */
public class VehicleApp {

	public static void main(String[] args) {
		Car car1 = new Car();

		car1.setInputDetails();
		car1.displayDetails();

		Car car2 = new Car("Toyota", "model-s", 700, 4, true);
		car2.displayDetails();

		Bike bike1 = new Bike();

		bike1.setInputDetails();
		bike1.displayDetails();

		Bike bike2 = new Bike("Kawasaki", "ninja", 400, true, 1200);
		bike2.displayDetails();

	}

}
