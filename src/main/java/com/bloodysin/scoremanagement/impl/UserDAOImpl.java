package com.bloodysin.scoremanagement.impl;

import com.bloodysin.scoremanagement.dao.*;
import com.bloodysin.scoremanagement.model.*;
import com.bloodysin.scoremanagement.util.BasicSqlSupport;

public class UserDAOImpl extends BasicSqlSupport implements UserDAO {
	@Override
	public void insertUser(User user) {
		this.session.insert("com.bloodysin.scoremanagement.mapper.UserMapper.insertUser", user);
	}
	
	@Override
	public void insertStudentUser(User user) {
		this.session.insert("com.bloodysin.scoremanagement.mapper.UserMapper.insertStudentUser", user);
	}
	
	@Override
	public User getUserByUserName(String userName) {
		return this.session.selectOne("com.bloodysin.scoremanagement.mapper.UserMapper.getUserByUserName", userName);
	}

	@Override
	public User getUserById(int userId) {
		return this.session.selectOne("com.bloodysin.scoremanagement.mapper.UserMapper.getUserById", userId);
	}
}
