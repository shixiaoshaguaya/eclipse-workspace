package com.schoolmanage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.dao.UserDao;
import com.schoolmanageapp.model.User;
import com.schoolmanageapp.util.JDBCUtil;

public class UserService {
private UserDao dao;
public UserService() {
	dao=new UserDao();
}
public List<User> getAll() throws Exception{
	return dao.getAll();
}

//根据条件查询(主键)
public User getById(int id) throws Exception {
	return dao.getById(id);
}

//插入
public boolean add(User usr) throws Exception {
return dao.add(usr);
}

//删除
public boolean delete(int id) throws Exception {
return dao.delete(id);
}

//更新
public boolean update(User usr) throws Exception {
	return dao.update(usr);
}

//登录账号密码检查

public User loginCheck(String name,String password) throws Exception {
	return dao.loginCheck(name, password);
}
}
