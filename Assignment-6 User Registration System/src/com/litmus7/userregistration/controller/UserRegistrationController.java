package com.litmus7.userregistration.controller;

import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.UserServiceException;
import com.litmus7.userregistration.service.UserRegistrationService;
import com.litmus7.userregistration.util.ApplicationConstants;

public class UserRegistrationController {

	private UserRegistrationService userRegistrationService = new UserRegistrationService();

	public Response<User> registerUser(User user) {
		Response<User> response = new Response<>();

		if (user.getUserName() != null && user.getEmail() != null && user.getPassword() != null) {
			try {
				User registeredUser = userRegistrationService.registerUser(user);
				response.setStatusCode(ApplicationConstants.SUCCESS_STATUS_CODE);
				response.setResponseData(registeredUser);

			} catch (UserServiceException e) {
				response.setStatusCode(ApplicationConstants.ERROR_STATUS_CODE);
				response.setErrorMessage(e.getMessage());
			} catch (Exception e) {
				response.setStatusCode(ApplicationConstants.ERROR_STATUS_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ApplicationConstants.ERROR_STATUS_CODE);
			response.setErrorMessage("Data insufficient");

		}
		return response;

	}

	public Response<User> getUserData(String username) {
		Response<User> response = new Response<>();
		if (username != null) {
			try {

				response.setResponseData(userRegistrationService.getRegisteredUserByUsername(username));
				response.setStatusCode(ApplicationConstants.SUCCESS_STATUS_CODE);
			} catch (UserServiceException e) {
				response.setStatusCode(ApplicationConstants.ERROR_STATUS_CODE);
				response.setErrorMessage(e.getMessage());
			}
		} else {
			response.setStatusCode(ApplicationConstants.ERROR_STATUS_CODE);
			response.setErrorMessage("username cannot be null");
		}
		return response;
	}
}
