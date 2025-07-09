package com.litmus7.userregistration.ui;

import java.util.Scanner;

import com.litmus7.userregistration.controller.UserRegistrationController;
import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.dto.User;

/**
 * User registration app
 * 
 * @author Farzinth Mohammed
 */
public class RegistrationApp {

	public static void main(String[] args) {

		UserRegistrationController userRegistrationController = new UserRegistrationController();

		String username;
		String email;
		String password;
		int age;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Register user=1 \nLoad saved user=2");
		int option = scanner.nextInt();
		if (option == 1) {
			System.out.println("Enter username");
			username = scanner.next();
			System.out.println("Enter age");
			age = scanner.nextInt();
			System.out.println("Enter email");
			email = scanner.next();
			System.out.println("Enter password");
			password = scanner.next();

			User user = new User(username, age, email, password);

			Response<User> registerUserResponse = userRegistrationController.registerUser(user);
			if (registerUserResponse.getStatusCode() == 200) {
				String newUserName = registerUserResponse.getResponseData().getUserName();
				int newAge = registerUserResponse.getResponseData().getAge();
				String newEmail = registerUserResponse.getResponseData().getEmail();
				int userid = registerUserResponse.getResponseData().getUserId();

				System.out.println("Registration successful! User Details: Username:" + newUserName + " Age:" + newAge
						+ " Email:" + newEmail + "User-ID:" + userid);
			} else {
				System.out.println(registerUserResponse.getErrorMessage());
			}
		} else if (option == 2) {
			System.out.println("Enter username:");
			username = scanner.next();

			Response<User> loadUserResponse = userRegistrationController.getUserData(username);
			if (loadUserResponse.getStatusCode() == 200) {
				System.out.println("Username:" + loadUserResponse.getResponseData().getUserName());
				System.out.println("age:" + loadUserResponse.getResponseData().getAge());
				System.out.println("email:" + loadUserResponse.getResponseData().getEmail());
			} else {
				System.out.println(loadUserResponse.getErrorMessage());
			}

		}
		scanner.close();

	}

}
