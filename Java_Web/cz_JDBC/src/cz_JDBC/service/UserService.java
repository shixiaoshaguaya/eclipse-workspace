package cz_JDBC.service;

import java.util.ArrayList;

import cz_JDBC.beans.User;
import cz_JDBC.dao.UserDao;

public class UserService {
	UserDao userDao;
	String msg;

	public String getMsg() {
		return msg;
	}

	public UserService() {
		super();
		userDao = new UserDao();
		msg = "";
	}

	public User checkLogin(String name, String password) {
		User user = userDao.findByName(name);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public boolean addUser(User user) {
		if (this.existUser(user.getName())) {
			this.msg = "该用户已存在，请修改新用户名称！";
			return false;
		}
		if (this.userDao.insert(user)) {
			this.msg = "增加成功！";
			return true;
		} else {
			this.msg = "增加失败！";
			return false;
		}
	}

	public boolean existUser(String name) {
		if (this.userDao.findByName(name) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<User> getAllUser() {
		return this.userDao.findAll();
	}

	// 获取指定商品
	public User getUserById(int id) {
		return this.userDao.find(id);
	}

	// 删除指定商品
	public boolean delUserById(int id) {
		return this.userDao.delete(id);
	}

	// 更新某商品
	public boolean updateUser(User user) {
		return this.userDao.update(user);
	}
}
