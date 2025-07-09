package com.litmus7.userregistration.dto;

public class User {
	private String userName;
	private int age;
	private String email;
	private String password;
	private int userId;

	
	public boolean equals(User that) {
		if(this.userName==that.userName)
			return true;
		else
			return false;
	}

	public User() {
		this.userName = "no-value";
		this.age = 0;
		this.email = "no-value";
		this.password = "no-value";
	}

	public User(String userName, int age, String email, String password) {
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public User(int userId,String userName, int age, String email, String password) {
		super();
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.userId = userId;
	}
	
	

	public User(String userName, int age, String email) {
		super();
		this.userName = userName;
		this.age = age;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



}
