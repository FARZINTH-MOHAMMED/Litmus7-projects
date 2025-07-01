package com.litmus7.vehiclerental.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.VehicleDataAccessExecption;

public class VehicleFileDao {

	public List<Vehicle> loadVehicle(String filepath) throws VehicleDataAccessExecption {
		List<Vehicle> vehicles = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String line;
			while ((line = br.readLine()) != null) {
				Vehicle vehicle = parseData(line);
				vehicles.add(vehicle);
			}
			br.close();

		} catch (IOException e) {
			throw new VehicleDataAccessExecption("Data couldn't loaded");
		}
		
		return vehicles;
	}

	private Vehicle parseData(String line) {
		String[] parts = line.split(",");
		String type = parts[0].trim();
		if (parts.length == 6) {
			String brand = parts[1].trim();
			String model = parts[2].trim();
			double rentalPricePerDay = Double.parseDouble(parts[3].trim());
			if (type.equals("Car")) {
				int numberOfDoors = Integer.parseInt(parts[4].trim());
				boolean isAutomatic = Boolean.parseBoolean(parts[5].trim());
				return new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic);
			} else if (type.equals("Bike")) {
				boolean hasGear = Boolean.parseBoolean(parts[4].trim());
				int engineCapacity = Integer.parseInt(parts[5].trim());
				return new Bike(brand, model, rentalPricePerDay, hasGear, engineCapacity);
			}
		}
		return null;
	}
}
