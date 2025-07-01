package com.litmus7.vehiclerental.controller;


import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.VehicleServiceException;
import com.litmus7.vehiclerental.service.VehicleService;

public class VehicleController {

	private final int SUCCESS_STATUS_CODE = 200;
	private final int ERROR_STATUS_CODE = 400;

	private VehicleService vehicleService = new VehicleService();

	public Response addVehicle(Vehicle vehicle) {
		Response response=new Response();
		if (vehicle != null) {
			vehicleService.addVehicle(vehicle);
			response.setResponseMessage("Vehicle added succesfully");
		} else
			response.setErrorMessage("Couldn't add vehicle");
		return response;
	}

	public Response loadVehicleList(String filepath) {
		Response response = new Response();
		if (filepath != null) {
			try {
				response.setVehicles(vehicleService.loadVehicles(filepath));
				response.setStatusCode(SUCCESS_STATUS_CODE);
			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage("Could'nt load vehicles list");
			}
			return response;
		} else
			return null;
	}

	public Response rentVehicle(Vehicle vehicle) {
		Response response= new Response();
		if(vehicle!=null) {
			try {
				response.setVehicles(vehicleService.rentVehicle(vehicle));
				response.setStatusCode(SUCCESS_STATUS_CODE);
				response.setResponseMessage("Vehicle rented succesfully");
				
			} catch (VehicleServiceException e) {
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage(e.getMessage());
			}
		}
		else {
			return null;
		}
		return response;
	}
	
	public Vehicle searchVehicleByBrand(String brand) {
		if(brand!=null) {
			return vehicleService.searchVehicleByBrand(brand);
		}
		else return null;
	}
	
	
	public Vehicle searchVehicleByModel(String model) {
		if(model!=null) {
			return vehicleService.searchVehicleByModel(model);
		}
		else return null;
	}
	
	public double calculateTotalRentalPrice() {
		return vehicleService.calculateTotalRentalPrice();
	}
	
	

	public String returnVehicle(Vehicle vehicle) {
		if(vehicle!=null) {		
			try {
				return vehicleService.returnVehicle(vehicle);
			} catch (VehicleServiceException e) {
				return e.getMessage();
			}
		}
		else {
			return null;
		}
	}
}
