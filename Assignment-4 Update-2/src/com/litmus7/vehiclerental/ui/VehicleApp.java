package com.litmus7.vehiclerental.ui;

import java.util.List;
import com.litmus7.vehiclerental.controller.VehicleController;
import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.dto.Vehicle;


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

		Response<List<Vehicle>> loadVehicleResponse = vehicleController.loadVehicleList("vehicle.txt");
		ResponseHandler.handleResponse(loadVehicleResponse);

		Vehicle car1 =UiHandler.inputVehicleDetails();
		
	
		Response<String> addVehicleResponse = vehicleController.addVehicle(car1);
		ResponseHandler.handleResponse(addVehicleResponse);

		Response<Vehicle> searchVehicleResponseBrand = vehicleController.searchVehicleByBrand("suzuki");
		ResponseHandler.handleResponse(searchVehicleResponseBrand);
		UiHandler.displayVehicleDetails(searchVehicleResponseBrand.getResponseData(),"Bike");

		Response<Vehicle> searVehicleByModelRepsonse = vehicleController.searchVehicleByModel("R15");
		ResponseHandler.handleResponse(searVehicleByModelRepsonse);
		UiHandler.displayVehicleDetails(searchVehicleResponseBrand.getResponseData(),"Bike");

		
		Response<String> rentResponse = vehicleController.rentVehicle(car1);
		ResponseHandler.handleResponse(rentResponse);
	
		Response<String> returnVehicleResponse = vehicleController.returnVehicle(car1);
		ResponseHandler.handleResponse(returnVehicleResponse);

		Response<Double> totalRentalPrice = vehicleController.calculateTotalRentalPrice();
		System.out.println(totalRentalPrice.getResponseData());

	}


}
