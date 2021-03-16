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

//����������ѯ(����)
public Student getById(String id) throws Exception {
	return dao.getById(id);
	}

//����
public boolean add(Student s) throws Exception {
	return dao.add(s);
}

//ɾ��
public boolean delete(String id) throws Exception {
	return dao.delete(id);
}

//����
public boolean update(Student s) throws Exception {
	return dao.update(s);
}

}
