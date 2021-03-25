package cn.lmu.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lmu.ssm.dao.UserDao;
import cn.lmu.ssm.pojo.UserInfo;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserInfo> getUsers() {
		return this.userDao.getUsers();
	}
}
