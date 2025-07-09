package com.litmus7.userregistration.util;

public class SQLConstants {
	private static String INSERT_USER_DATA="INSERT INTO userdata(username,age,email,user_password)" + "VALUES(?,?,?,?);";
	private static String RESPONSE_USER_DATA="Select userid,age,username,user_password,email from userdata where username=?";
	private static String USER_DATA="Select username,age,email from userdata where username=?";
	private static String AGE="age";
	private static String EMAIL="email";
	private static String USERNAME="username";
	private static String USERID="userid";
	private static String PASSWORD="user_password";
	
	
	
	public static String getAGE() {
		return AGE;
	}
	public static void setAGE(String aGE) {
		AGE = aGE;
	}
	public static String getEMAIL() {
		return EMAIL;
	}
	public static void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public static String getUSERNAME() {
		return USERNAME;
	}
	public static void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public static String getUSERID() {
		return USERID;
	}
	public static void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public static String getPASSWORD() {
		return PASSWORD;
	}
	public static void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public static String getInsertUserData() {
		return INSERT_USER_DATA;
	}
	public static void setInsertUserData(String insertUserData) {
		SQLConstants.INSERT_USER_DATA = insertUserData;
	}
	public static String getGetResonseUserData() {
		return RESPONSE_USER_DATA;
	}
	public static void setGetResonseUserData(String getResonseUserData) {
		SQLConstants.RESPONSE_USER_DATA = getResonseUserData;
	}
	public static String getGetUserData() {
		return USER_DATA;
	}
	public static void setGetUserData(String getUserData) {
		SQLConstants.USER_DATA = getUserData;
	}
}

