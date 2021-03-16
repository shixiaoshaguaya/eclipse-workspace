package com.schoolmanage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.dao.TeacherLessonDao;
import com.schoolmanageapp.model.TeacherLesson;
import com.schoolmanageapp.model.TeacherLessonInfo;
import com.schoolmanageapp.util.JDBCUtil;

public class TeacherLessonService {
private TeacherLessonDao dao;
public TeacherLessonService() {
	dao=new TeacherLessonDao();
}
public List<TeacherLesson> getAll() throws Exception{
	return dao.getAll();
}

public List<TeacherLessonInfo> getAllInfo() throws Exception{
	return dao.getAllInfo();
}

public List<TeacherLessonInfo> getAllInfoByCondition(String condition) throws Exception{
	return dao.getAllInfoByCondition(condition);
}


//根据条件查询(主键)
public TeacherLesson getById(int id) throws Exception {
	return dao.getById(id);
}
public TeacherLessonInfo getInfoById(int id) throws Exception {
	return dao.getInfoById(id);
}

//插入
public boolean add(TeacherLesson tl) throws Exception {
	return dao.add(tl);
}

//删除
public boolean delete(int id) throws Exception {
	return dao.delete(id);
}

//更新
public boolean update(TeacherLesson tl) throws Exception {
	return dao.update(tl);
}
}
