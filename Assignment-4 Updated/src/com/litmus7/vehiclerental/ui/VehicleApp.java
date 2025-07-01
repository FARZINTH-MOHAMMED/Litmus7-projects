package com.litmus7.vehiclerental.ui;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerental.controller.VehicleController;
import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.service.VehicleService;

/**
 * The {@code VehicleApp} class serves as the entry point of the application. It
 * creates {@code Car} and {@code Bike} objects, take input values and display
 * values for these objects
 * 
 * @author Farzinth Mohammed
 */
public class VehicleApp {

	public static void main(String[] args) {
		VehicleController vehicleController = new VehicleController();
		Vehicle car1= new Car("Hummer","v6",500,6,true);
		
		List<Vehicle> vehicles=new ArrayList<>();
	
		Response loadVehicleResponse= vehicleController.loadVehicleList("vehicle.txt");
		if(loadVehicleResponse.getStatusCode()==200) {
			System.out.println(loadVehicleResponse.getVehicles());
		}
		else {
			System.out.println(loadVehicleResponse.getErrorMessage());
		}
		
		
		Response addVehicleResponse= vehicleController.addVehicle(car1);
		if(addVehicleResponse.getStatusCode()==200) {
			System.out.println(addVehicleResponse.getResponseMessage());
		}
		else {
			System.out.println(addVehicleResponse.getErrorMessage());
		}
		
		
		Vehicle searchVehicleResponse= vehicleController.searchVehicleByBrand("Toyota");
		System.out.println(searchVehicleResponse);
		
		Vehicle searVehicleByModelRepsonse= vehicleController.searchVehicleByModel("R15");
		System.out.println(searVehicleByModelRepsonse);
		
		Response rentResponse= vehicleController.rentVehicle(car1);
		if(rentResponse.getStatusCode()==200) {
			System.out.println(rentResponse.getResponseMessage());
		}
		else {
			System.out.println(rentResponse.getErrorMessage());
		}
		
		String returnVehicleResponse= vehicleController.returnVehicle(car1);
		System.out.println(returnVehicleResponse);
		
		
		double totalRentalPrice=vehicleController.calculateTotalRentalPrice();
		System.out.println(totalRentalPrice);
		
		
		
		
	}

}
