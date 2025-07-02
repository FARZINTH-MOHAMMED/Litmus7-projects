package com.litmus7.vehiclerental.ui;
import java.util.Scanner;

import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.dto.Vehicle;

public class UiHandler {
	
	
	

	public static Vehicle inputVehicleDetails() {
		Scanner scanner= new Scanner(System.in);
		System.out.println("---Enter type of vehicle---");
		String type =scanner.nextLine();
		
		System.out.println("Enter the brand: ");
		String brand=scanner.nextLine();
		
		System.out.println("Enter model: ");
		String model= scanner.nextLine();
		
		System.out.println("Enter rental price per day: ");
		double rentalPricePerDay= scanner.nextDouble();
		
		if(type.equalsIgnoreCase("Car")) {
			System.out.println("Enter number of doors: ");
			int numberOfDoors= scanner.nextInt();
			
			System.out.println("Is car automatic: ");
			boolean isAutomatic= scanner.nextBoolean();
			
			return new Car(brand,model,rentalPricePerDay,numberOfDoors,isAutomatic);
		}
		else {
			System.out.println("Is bike geared? ");
			boolean hasGear= scanner.nextBoolean();
			
			System.out.println("Enter engine capacity: ");
			int engineCapacity= scanner.nextInt();
			
			return new Bike(brand,model,rentalPricePerDay,hasGear,engineCapacity);
		}
		
		
	}
	
	public static void displayVehicleDetails(Vehicle vehicle,String type) {
		System.out.println("---Vehicle Details---");
		System.out.println("Brand: "+vehicle.getBrand());
		System.out.println("Model: "+vehicle.getModel());
		System.out.println("Rental price per day: "+vehicle.getRentalPricePerDay());
		if(type.equalsIgnoreCase("Car")) {
			System.out.println("Number of doors:"+((Car)vehicle).getNumberOfDoors());
			System.out.println("Is automatic: "+((Car)vehicle).isAutomatic());
		}
		else if(type.equalsIgnoreCase("Bike")) {
			System.out.println("has gear:"+((Bike)vehicle).hasGear());
			System.out.println("Engine Capacity: "+((Bike)vehicle).getEngineCapacity());
		}
		System.out.println();
	}
	
	
}
