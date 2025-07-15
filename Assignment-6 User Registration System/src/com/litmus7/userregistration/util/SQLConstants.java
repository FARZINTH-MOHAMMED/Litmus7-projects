package com.litmus7.userregistration.util;

public class SQLConstants {
	public static String INSERT_USER_DATA = "INSERT INTO userdata(username,age,email,user_password)"
			+ "VALUES(?,?,?,?);";
	public static String RESPONSE_USER_DATA = "Select userid,age,username,user_password,email from userdata where username=?";
	public static String USER_DATA = "Select username,age,email from userdata where username=?";
	public static String AGE = "age";
	public static String EMAIL = "email";
	public static String USERNAME = "username";
	public static String USERID = "userid";
	public static String PASSWORD = "user_password";
}
