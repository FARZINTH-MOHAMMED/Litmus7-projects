package com.litmus7.vehiclerental.controller;

import java.util.List;

import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.VehicleServiceException;
import com.litmus7.vehiclerental.service.VehicleService;

public class VehicleController {

	private final int SUCCESS_STATUS_CODE = 200;
	private final int ERROR_STATUS_CODE = 400;

	private VehicleService vehicleService = new VehicleService();

	public Response<String> addVehicle(Vehicle vehicle) {
		Response<String> response = new Response<>();
		if (vehicle != null) {
			try {
				vehicleService.addVehicle(vehicle);
				response.setStatusCode(SUCCESS_STATUS_CODE);
				response.setResponseData("Vehicle added succesfully");
			} catch (Exception e) {
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Vehicle provided is empty");
		}
		return response;
	}

	public Response<List<Vehicle>> loadVehicleList(String filepath) {
		Response<List<Vehicle>> response = new Response<>();
		if (filepath != null) {
			try {
				response.setResponseData(vehicleService.loadVehicles(filepath));
				response.setStatusCode(SUCCESS_STATUS_CODE);
			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage("Could'nt load vehicles list");
			}

		} else {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("filepath does'nt exist");
		}
		return response;
	}

	public Response<String> rentVehicle(Vehicle vehicle) {
		Response<String> response = new Response<>();
		if (vehicle != null) {
			try {
				response.setResponseData(vehicleService.rentVehicle(vehicle));
				response.setStatusCode(SUCCESS_STATUS_CODE);

			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Vehicle provided is empty");
		}
		return response;
	}

	public Response<Vehicle> searchVehicleByBrand(String brand) {
		Response<Vehicle> response= new Response<>();
		if (brand != null) {
			response.setResponseData(vehicleService.searchVehicleByBrand(brand));
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} else {		
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Brand provided is empty");
		}
		return response;
	}

	public Response<Vehicle> searchVehicleByModel(String model) {
		Response<Vehicle> response= new Response<>();
		if (model != null) {
			response.setResponseData(vehicleService.searchVehicleByModel(model));
			response.setStatusCode(SUCCESS_STATUS_CODE);
		} else {
			
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Model provided is empty");
		}
		return response;
	}

	public Response<Double> calculateTotalRentalPrice() {
		Response<Double> response= new Response<Double>();
		response.setResponseData(vehicleService.calculateTotalRentalPrice());
		return response;
	}

	
	public Response<String> returnVehicle(Vehicle vehicle) {
		Response<String> response= new Response<String>();
		if (vehicle != null) {
			try {
				response.setResponseData(vehicleService.returnVehicle(vehicle));
				response.setStatusCode(SUCCESS_STATUS_CODE);
			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Vehicle provided is empty");
		}
		
		return response;
	}
}
