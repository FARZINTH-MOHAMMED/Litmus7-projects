package com.litmus7.userregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.util.DBConnectionUtil;
import com.litmus7.userregistration.util.SQLConstants;

public class UserDao {

	public User setUserData(User user) throws UserDataAccessException {
		int userId = 0;
		int age = 0;
		String username = null;
		String email = null;
		String password = null;

		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement statment = connection.prepareStatement(SQLConstants.getInsertUserData())) {

			statment.setString(1, user.getUserName());
			statment.setInt(2, user.getAge());
			statment.setString(3, user.getEmail());
			statment.setString(4, user.getPassword());
			statment.executeUpdate();

			try (PreparedStatement resultStatment = connection.prepareStatement(SQLConstants.getGetResonseUserData())) {
				resultStatment.setString(1, user.getUserName());
				try (ResultSet result = resultStatment.executeQuery()) {
					if (result.next()) {
						userId = result.getInt(SQLConstants.getUSERID());
						age = result.getInt(SQLConstants.getAGE());
						username = result.getString(SQLConstants.getUSERNAME());
						email = result.getString(SQLConstants.getEMAIL());
						password = result.getString(SQLConstants.getPASSWORD());
					}
					User registeredUser = new User(userId, username, age, email, password);
					return registeredUser;

				}
			}

		} catch (SQLException e) {
			throw new UserDataAccessException("Unable to insert user data", e);
		}
	}

	public User getUserDataByUserName(String userName) throws UserDataAccessException {
		int age = 0;
		String username = null;
		String email = null;
		try (Connection connection = DBConnectionUtil.getConnection();
				PreparedStatement statment = connection.prepareStatement(SQLConstants.getGetUserData())) {

			statment.setString(1, userName);
			try (ResultSet result = statment.executeQuery()) {
				if (result.next()) {
					age = result.getInt(SQLConstants.getAGE());
					username = result.getString(SQLConstants.getUSERNAME());
					email = result.getString(SQLConstants.getEMAIL());
				}
				return new User(username, age, email);
			}
		} catch (SQLException e) {
			throw new UserDataAccessException("Unable to access user data" + e.getMessage(), e);
		} catch (Exception e) {
			throw new UserDataAccessException("Error occured", e);
		}
	}

}
