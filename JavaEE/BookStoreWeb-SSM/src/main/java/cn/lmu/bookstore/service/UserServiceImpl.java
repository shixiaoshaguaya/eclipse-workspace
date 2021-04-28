package cn.lmu.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lmu.bookstore.dao.UserMapper;
import cn.lmu.bookstore.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public int createUser(User user) {
		return this.userMapper.createUser(user);
	}

	public User getUserById(int id) {
		return this.userMapper.getUserById(id);
	}

	public List<User> getUserListWhere(User user) {
		return this.userMapper.getUserList(user);
	}

	public int editUser(User user) {
		return this.userMapper.editUser(user);
	}

	public int deleteUserById(int id) {
		return this.userMapper.deleteUser(id);
	}

}
