package com.traventure.domain;

import org.springframework.data.annotation.Id;

public class User {
	
	private String userName;
	@Id
	private String displayName;
	private String gender;
	private String age;
	private String email;
	private String password;
	private String location;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String displayName, String gender, String age, String email, String password,
			String location) {
		super();
		this.userName = userName;
		this.displayName = displayName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.password = password;
		this.location = location;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
