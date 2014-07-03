package com.bloodysin.scoremanagement.dao;

import com.bloodysin.scoremanagement.model.*;

public interface UserDAO {
	public void insertUser(User user);
	
	public void insertStudentUser(User user);
	
	public User getUserByUserName(String userName);
	
	public User getUserById(int userId);
}
