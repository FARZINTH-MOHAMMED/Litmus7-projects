package com.litmus7.vehiclerental.exception;



public class VehicleServiceException extends Exception{

	public VehicleServiceException() {
		super();
	}

	public VehicleServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public VehicleServiceException(String message) {
		super(message);
	}

}
