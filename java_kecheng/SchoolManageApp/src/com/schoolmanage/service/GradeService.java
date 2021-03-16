package com.schoolmanage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.dao.GradeDao;
import com.schoolmanageapp.model.Grade;
import com.schoolmanageapp.model.GradeInfo;
import com.schoolmanageapp.util.JDBCUtil;

public class GradeService {
private GradeDao dao;
public GradeService() {
	dao=new GradeDao();
}
public List<Grade> getAll() throws Exception{
	return dao.getAll();
}

public List<GradeInfo> getAllInfo() throws Exception{
	return dao.getAllInfo();
}
//����������ѯ(����)
public GradeInfo getById(int id) throws Exception {
	return dao.getById(id);
}
public GradeInfo getInfoById(int id) throws Exception {
	return dao.getInfoById(id);
}
//����
public boolean add(Grade g) throws Exception {
	return dao.add(g);
}

//ɾ��
public boolean delete(int id) throws Exception {
return dao.delete(id);
}

//����
public boolean update(Grade g) throws Exception {
	return dao.update(g);
}
	
}
