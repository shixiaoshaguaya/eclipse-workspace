package com.schoolmanage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.schoolmanageapp.dao.StudentDao;
import com.schoolmanageapp.model.Student;
import com.schoolmanageapp.util.JDBCUtil;

public class StudentService {
private StudentDao dao;
public StudentService() {
	dao=new StudentDao();
	
}

public List<Student> getAll() throws Exception{
	return dao.getAll();
}

//根据条件查询(主键)
public Student getById(String id) throws Exception {
	return dao.getById(id);
	}

//插入
public boolean add(Student s) throws Exception {
	return dao.add(s);
}

//删除
public boolean delete(String id) throws Exception {
	return dao.delete(id);
}

//更新
public boolean update(Student s) throws Exception {
	return dao.update(s);
}

}
