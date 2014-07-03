package com.bloodysin.scoremanagement.service;

import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.dao.*;

public class UserService {
	private UserDAO userDAO = null;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void addUser(String userName, String password, boolean isTeacher) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		if (isTeacher == true){
			userDAO.insertUser(user);
		}
		else {
			userDAO.insertStudentUser(user);
		}
	}
	
	public int getUserId(String userName) {
		User user = userDAO.getUserByUserName(userName);
		return user.getUserId();
	}
	
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
	
	public boolean isUserNameExisted(String userName) {
		User user = userDAO.getUserByUserName(userName);
		
		if(user != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean validate(String userName, String password) {
		User user = userDAO.getUserByUserName(userName);
		if (password.equals(user.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isTeacher(String userName) {
		User user = userDAO.getUserByUserName(userName);
		if (user.getRole().equals("teacher")) {
			return true;
		}
		else {
			return false;
		}
	}
}
