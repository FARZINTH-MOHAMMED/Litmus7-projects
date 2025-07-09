package com.litmus7.userregistration.util;

public class ApplicationConstants {
	private static int MIN_AGE_LIMIT=18;
	private static int MAX_AGE_LIMIT=60;
	
	private static int ERROR_STATUS_CODE = 400;
	private static int SUCCESS_STATUS_CODE = 200;
	
	public static int getMIN_AGE_LIMIT() {
		return MIN_AGE_LIMIT;
	}
	public static void setMIN_AGE_LIMIT(int mIN_AGE_LIMIT) {
		MIN_AGE_LIMIT = mIN_AGE_LIMIT;
	}
	public static int getMAX_AGE_LIMIT() {
		return MAX_AGE_LIMIT;
	}
	public static void setMAX_AGE_LIMIT(int mAX_AGE_LIMIT) {
		MAX_AGE_LIMIT = mAX_AGE_LIMIT;
	}
	public static int getERROR_STATUS_CODE() {
		return ERROR_STATUS_CODE;
	}
	public static void setERROR_STATUS_CODE(int eRROR_STATUS_CODE) {
		ERROR_STATUS_CODE = eRROR_STATUS_CODE;
	}
	public static int getSUCCESS_STATUS_CODE() {
		return SUCCESS_STATUS_CODE;
	}
	public static void setSUCCESS_STATUS_CODE(int sUCCESS_STATUS_CODE) {
		SUCCESS_STATUS_CODE = sUCCESS_STATUS_CODE;
	}
}
