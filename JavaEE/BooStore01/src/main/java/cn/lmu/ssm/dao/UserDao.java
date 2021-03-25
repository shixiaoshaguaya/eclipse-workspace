package cn.lmu.ssm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.lmu.ssm.pojo.UserInfo;

@Repository
public class UserDao {
	List<UserInfo> users;

	public UserDao() {
		this.users = new ArrayList<UserInfo>();
		users.add(new UserInfo("张三", 18));
		users.add(new UserInfo("李四", 20));
		users.add(new UserInfo("王五", 19));
	}

	public List<UserInfo> getUsers() {
		return this.users;
	}
}
