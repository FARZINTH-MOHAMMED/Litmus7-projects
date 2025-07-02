package com.litmus7.vehiclerental.ui;

import com.litmus7.vehiclerental.dto.Response;

public class ResponseHandler {
	public static<T> void handleResponse(Response<T> response) {
		if (response.getStatusCode() == 200) {
			System.out.println(response.getResponseData());
		} else {
			System.out.println(response.getErrorMessage());
		}
	}
}
