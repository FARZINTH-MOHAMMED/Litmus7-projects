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
			throw new VehicleServiceException();
		}
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	

	
	public Vehicle searchVehicleByBrand(String brand) {
		for(Vehicle vehicle:vehicles) {
			if((vehicle.getBrand()).equals(brand))
				return vehicle;
		}
		
		return null;
	}
	
	public Vehicle searchVehicleByModel(String model) {
		for(Vehicle vehicle:vehicles) {
			if((vehicle.getModel()).equals(model))
				return vehicle;
		}
		
		return null;
	}
	
	public double calculateTotalRentalPrice() {
		double totalRentalPrice=0;
		for(Vehicle vehicle:vehicles) {
			totalRentalPrice+=vehicle.getRentalPricePerDay();
		}
		return totalRentalPrice;
	}
	
//	public void displayVehicleWithRentalPrice() {
//		for(Vehicle vehicle:vehicles) {
//			System.out.println("\t"+vehicle.getBrand()+":"+vehicle.getModel()+"="+vehicle.getRentalPricePerDay());
//		}
//	}
	
	public List<Vehicle> rentVehicle(Vehicle vehicle) throws VehicleServiceException{
		if(vehicle.isRented()==false) {	
			if(vehicles.contains(vehicle)) {
				vehicle.setRented(true);
				vehicles.remove(vehicle);
				return vehicles;
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
