package com.litmus7.userregistration.util;

import com.litmus7.userregistration.dto.User;
import java.util.regex.Pattern;

public class ValidationUtil {
	public static boolean checkAge(User user) {
		if (user.getAge() < ApplicationConstants.getMIN_AGE_LIMIT()
				|| user.getAge() > ApplicationConstants.getMAX_AGE_LIMIT()) {
			return true;
		} else
			return false;
	}

	public static boolean checkEmail(User user) {
		String emailRegex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
		Pattern p = Pattern.compile(emailRegex);

		if (p.matcher(user.getEmail()).matches()) {
			return false;
		} else
			return true;
	}

	public static boolean checkPassword(User user) {
		if (user.getPassword().length() < 6) {
			return true;
		} else
			return false;
	}
}
