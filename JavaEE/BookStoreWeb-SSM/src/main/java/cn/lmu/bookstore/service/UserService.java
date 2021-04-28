package cn.lmu.bookstore.service;

import java.util.List;

import cn.lmu.bookstore.pojo.User;

public interface UserService {
	public int createUser(User user);

	public User getUserById(int id);

	public List<User> getUserListWhere(User user);

	public int editUser(User user);

	public int deleteUserById(int id);
}
