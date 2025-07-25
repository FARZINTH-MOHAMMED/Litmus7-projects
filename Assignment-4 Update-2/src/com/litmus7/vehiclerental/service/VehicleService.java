package com.litmus7.vehiclerental.service;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerental.dao.VehicleFileDao;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.VehicleDataAccessExecption;
import com.litmus7.vehiclerental.exception.VehicleServiceException;

public class VehicleService {
	
	VehicleFileDao vehicleFileDao= new VehicleFileDao();
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public List<Vehicle> loadVehicles(String filepath) throws VehicleServiceException {
		try {
			vehicles=vehicleFileDao.loadVehicle(filepath);
			return vehicles;
		} catch (VehicleDataAccessExecption e) {
			throw new VehicleServiceException(e.getMessage(),e);
		}
	}
	
	public void addVehicle(Vehicle vehicle) throws VehicleServiceException{
		
		for(Vehicle existingVehicle:vehicles) {
			if(existingVehicle.equals(vehicle)) {
				throw new VehicleServiceException("Vehicle already exists");
			}
		}
		vehicles.add(vehicle);
	}
	

	
	public Vehicle searchVehicleByBrand(String brand) throws VehicleServiceException{
		for(Vehicle vehicle:vehicles) {
			if((vehicle.getBrand()).equalsIgnoreCase(brand))
				return vehicle;
		}
		
		throw new VehicleServiceException("Couldn't find vehicle with brand name "+brand);
	}
	
	public Vehicle searchVehicleByModel(String model) throws VehicleServiceException{
		for(Vehicle vehicle:vehicles) {
			if((vehicle.getModel()).equals(model))
				return vehicle;
		}
		
		throw new VehicleServiceException("Couldn't find vehicle with model name "+model);
	}
	
	public double calculateTotalRentalPrice() {
		double totalRentalPrice=0;
		for(Vehicle vehicle:vehicles) {
			totalRentalPrice+=vehicle.getRentalPricePerDay();
		}
		return totalRentalPrice;
	}
	
	
	public String rentVehicle(Vehicle vehicle) throws VehicleServiceException{
		if(vehicle.isRented()==false) {	
			if(vehicles.contains(vehicle)) {
				vehicle.setRented(true);
				vehicles.remove(vehicle);
				return "Vehicle rented succesfully";
			}
			else {
				throw new VehicleServiceException("Vehicle doesn't exist");
			}
		}
		else {
			throw new VehicleServiceException("Vehicle already rented");
		}
		
	}
	
	public String returnVehicle(Vehicle rentedVehicle) throws VehicleServiceException{
		if(rentedVehicle.isRented()==true) {
			rentedVehicle.setRented(false);
			vehicles.add(rentedVehicle);
			return "Vehicle returned succesfully";
		}
		else {
			throw new VehicleServiceException("Vehicle not rented");
		}
	}
	
	
}
