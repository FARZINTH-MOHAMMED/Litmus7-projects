package com.litmus7.retail.dto;

public class Response<T> {
	private int statusCode;
	private String errorMessage;
	private T responseData;

	public T getResponseData() {
		return responseData;
	}

	public void setResponseData(T successResponse) {
		this.responseData = successResponse;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
