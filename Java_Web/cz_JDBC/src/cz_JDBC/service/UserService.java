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
			this.msg = "���û��Ѵ��ڣ����޸����û����ƣ�";
			return false;
		}
		if (this.userDao.insert(user)) {
			this.msg = "���ӳɹ���";
			return true;
		} else {
			this.msg = "����ʧ�ܣ�";
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

	// ��ȡָ����Ʒ
	public User getUserById(int id) {
		return this.userDao.find(id);
	}

	// ɾ��ָ����Ʒ
	public boolean delUserById(int id) {
		return this.userDao.delete(id);
	}

	// ����ĳ��Ʒ
	public boolean updateUser(User user) {
		return this.userDao.update(user);
	}
}
