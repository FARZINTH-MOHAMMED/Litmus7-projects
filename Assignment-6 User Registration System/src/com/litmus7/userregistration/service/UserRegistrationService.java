package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserDao;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.exception.WeakPasswordException;
import com.litmus7.userregistration.exception.UserServiceException;
import com.litmus7.userregistration.util.ValidationUtil;

public class UserRegistrationService {

	private UserDao userDbAccess = new UserDao();

	public User registerUser(User user) throws Exception {

		if (ValidationUtil.checkAge(user)) {
			throw new InvalidAgeException("Age should be between 18 and 16");
		}
		if (ValidationUtil.checkEmail(user))
			throw new InvalidEmailException("Email should contain @ and .");

		if (ValidationUtil.checkPassword(user)) {
			throw new WeakPasswordException("Password should contain atleast 6 characters");
		}
		try {
			User existingUser = userDbAccess.getUserDataByUserName(user.getUserName());
			if (user.getUserName().equals(existingUser.getUserName())) {
				throw new UserServiceException("User already exist");
			}
			User registeredUser = userDbAccess.setUserData(user);
			if (registeredUser == null)
				throw new UserServiceException("Some error occured");
			return registeredUser;
		} catch (UserDataAccessException e) {
			throw new UserServiceException(e.getMessage(), e);
		}
	}

	public User getRegisteredUserByUsername(String username) throws UserServiceException {
		try {
			User existingUser = userDbAccess.getUserDataByUserName(username);
			if (existingUser == null || existingUser.getUserName() == null)
				throw new UserServiceException("Couldn't find user");
			return existingUser;

		} catch (UserDataAccessException e) {
			throw new UserServiceException(e.getMessage(), e);
		}

	}

}
