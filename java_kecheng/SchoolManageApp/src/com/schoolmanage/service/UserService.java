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

//����������ѯ(����)
public User getById(int id) throws Exception {
	return dao.getById(id);
}

//����
public boolean add(User usr) throws Exception {
return dao.add(usr);
}

//ɾ��
public boolean delete(int id) throws Exception {
return dao.delete(id);
}

//����
public boolean update(User usr) throws Exception {
	return dao.update(usr);
}

//��¼�˺�������

public User loginCheck(String name,String password) throws Exception {
	return dao.loginCheck(name, password);
}
}
