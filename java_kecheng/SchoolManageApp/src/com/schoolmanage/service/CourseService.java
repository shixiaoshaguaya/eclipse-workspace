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
	
	//返回数据库表中所有记录
public List<Course> getAll() throws Exception{
	  return dao.getAll();
}

//根据条件查询(主键)
public Course getById(String id) throws Exception {
	return dao.getById(id);
}

//插入
public boolean add(Course c) throws Exception {
	return dao.add(c);
}

//删除
public boolean delete(String id) throws Exception {
return dao.delete(id);
}

//更新
public boolean update(Course c) throws Exception {
return dao.update(c);
}
}
