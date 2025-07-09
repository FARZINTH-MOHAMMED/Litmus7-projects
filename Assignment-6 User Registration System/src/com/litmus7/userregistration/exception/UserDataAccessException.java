package com.litmus7.userregistration.exception;

public class UserDataAccessException extends Exception {

	public UserDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDataAccessException(String message) {
		super(message);
	}

}
