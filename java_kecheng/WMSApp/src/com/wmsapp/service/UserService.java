package com.wmsapp.service;

import com.wmsapp.dao.UserDao;
import com.wmsapp.model.User;

public class UserService {
	private UserDao dao;
	public UserService() {
		dao = new UserDao();
	}
	public User loginCheck(String name, String password) throws Exception {
		return dao.loginCheck(name, password);
	}
}
