package com.schoolmanage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.dao.CourseDao;
import com.schoolmanageapp.model.Course;
import com.schoolmanageapp.util.JDBCUtil;

public class CourseService {
private CourseDao dao;
public CourseService() {
	dao=new CourseDao();
}
	
	//�������ݿ�������м�¼
public List<Course> getAll() throws Exception{
	  return dao.getAll();
}

//����������ѯ(����)
public Course getById(String id) throws Exception {
	return dao.getById(id);
}

//����
public boolean add(Course c) throws Exception {
	return dao.add(c);
}

//ɾ��
public boolean delete(String id) throws Exception {
return dao.delete(id);
}

//����
public boolean update(Course c) throws Exception {
return dao.update(c);
}
}
