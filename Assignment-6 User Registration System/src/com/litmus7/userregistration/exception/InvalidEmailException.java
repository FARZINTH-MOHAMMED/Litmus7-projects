package com.litmus7.userregistration.exception;

public class InvalidEmailException extends Exception {

	public InvalidEmailException(String message) {
		super(message);
	}

	public InvalidEmailException(String message, Throwable cause) {
		super(message, cause);
	}

}
