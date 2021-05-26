package cn.lmu.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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

	public PageInfo<User> getUserListWhereByPage(User user, Integer pageNum, Integer pageSize) {
		// 分页
		PageHelper.startPage(pageNum, pageSize);// page 指定页码，pageSize 为每页显示几条数据
		List<User> list = this.userMapper.getUserList(user);// 调用查询
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	}

	public void deleteUserByIds(String[] idArr) {
		// TODO Auto-generated method stub
		this.userMapper.deleteUsers(idArr);
	}

	public User checkLogin(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.checkLogin(user);
	}
}
