package com.bloodysin.scoremanagement.model;

public class User {
	private int userId;
	private String userName;
	private String role;
	private String password;
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
