package cn.lmu.bookstore.dao;

import java.util.List;

import cn.lmu.bookstore.pojo.User;

public interface UserMapper {
	// 创建用户
	public int createUser(User user);

	// 获取某用户
	public User getUserById(int id);

	// 获取符合条件的用户列表
	public List<User> getUserList(User user);

	// 编辑某用户
	public int editUser(User user);

	// 删除用户
	public int deleteUser(int id);

	public void deleteUsers(String[] idArr);

	public User checkLogin(User user);
}
