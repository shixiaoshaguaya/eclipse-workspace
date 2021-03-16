package com.schoolmanage.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.schoolmanageapp.dao.TeacherDao;
import com.schoolmanageapp.model.Teacher;
import com.schoolmanageapp.util.JDBCUtil;

public class TeacherService {
private TeacherDao dao;
public TeacherService() {
	dao=new TeacherDao();
}
public List<Teacher> getAll() throws Exception{
	return dao.getAll();
}

public List<Teacher> getAllByCondition(String condition) throws Exception{
	return dao.getAllByCondition(condition);
}
//根据条件查询(主键)
public Teacher getById(String id) throws Exception {
	return dao.getById(id);
}

//插入
public boolean add(Teacher t) throws Exception {
	return dao.add(t);
}

//删除
public boolean delete(String id) throws Exception {
	return dao.delete(id);
}

//更新
public boolean update(Teacher t) throws Exception {
	return dao.update(t);
}

}
