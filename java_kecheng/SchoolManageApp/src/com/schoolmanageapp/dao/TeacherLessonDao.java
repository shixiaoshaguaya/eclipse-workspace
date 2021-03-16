package com.schoolmanageapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.model.*;
import com.schoolmanageapp.util.JDBCUtil;
//实现对数据库Course表的增加、删除、修改、查询等访问功能接口
public class TeacherLessonDao {
	//返回数据库表中所有记录
public List<TeacherLesson> getAll() throws Exception{
	List<TeacherLesson> teacherLessonList = new ArrayList<TeacherLesson>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select id,t_id,c_id,class_id,period from teacherlesson order by id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    	int id=rs.getInt("id");
        String teacherId = rs.getString("t_id");
        String courseId = rs.getString("c_id");
        String classId = rs.getString("class_id");
        String period = rs.getString("period");
        TeacherLesson tl = new TeacherLesson(id,teacherId,courseId,classId,period);
        teacherLessonList.add(tl);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return teacherLessonList;
}

public List<TeacherLessonInfo> getAllInfo() throws Exception{
	List<TeacherLessonInfo> teacherLessonList = new ArrayList<TeacherLessonInfo>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select id,t_id,t_name,c_id,c_name,class_id,class_name,period from v_teacherlesson order by id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    	int id=rs.getInt("id");
        String teacherId = rs.getString("t_id");
        String teacherName=rs.getString("t_name");
        String courseId = rs.getString("c_id");
        String courseName=rs.getString("c_name");
        String classId = rs.getString("class_id");
        String className=rs.getString("class_name");
        String period = rs.getString("period");
        TeacherLessonInfo tl = new TeacherLessonInfo(id,teacherId,teacherName,courseId,courseName,classId,className,period);
        teacherLessonList.add(tl);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return teacherLessonList;
}

public List<TeacherLessonInfo> getAllInfoByCondition(String condition) throws Exception{
	List<TeacherLessonInfo> teacherLessonList = new ArrayList<TeacherLessonInfo>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select id,t_id,t_name,c_id,c_name,class_id,class_name,period from v_teacherlesson where "+condition+" order by id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    	int id=rs.getInt("id");
        String teacherId = rs.getString("t_id");
        String teacherName=rs.getString("t_name");
        String courseId = rs.getString("c_id");
        String courseName=rs.getString("c_name");
        String classId = rs.getString("class_id");
        String className=rs.getString("class_name");
        String period = rs.getString("period");
        TeacherLessonInfo tl = new TeacherLessonInfo(id,teacherId,teacherName,courseId,courseName,classId,className,period);
        teacherLessonList.add(tl);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return teacherLessonList;
}


//根据条件查询(主键)
public TeacherLesson getById(int id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select id,t_id,c_id,class_id,period from teacherlesson where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1,id);
	    ResultSet rs = ps.executeQuery();
	    TeacherLesson tl =null;
	    if(rs.next()){	
	    	  String teacherId = rs.getString("t_id");
	          String courseId = rs.getString("c_id");
	          String classId = rs.getString("class_id");
	          String period = rs.getString("period");
	         tl = new TeacherLesson(id,teacherId,courseId,classId,period);
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return tl;
}
public TeacherLessonInfo getInfoById(int id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select id,t_id,t_name,c_id,c_name,class_id,class_name,period from v_teacherlesson where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1,id);
	    ResultSet rs = ps.executeQuery();
	    TeacherLessonInfo tl =null;
	    if(rs.next()){	
	    	 String teacherId = rs.getString("t_id");
	         String teacherName=rs.getString("t_name");
	         String courseId = rs.getString("c_id");
	         String courseName=rs.getString("c_name");
	         String classId = rs.getString("class_id");
	         String className=rs.getString("class_name");
	         String period = rs.getString("period");
	       tl = new TeacherLessonInfo(id,teacherId,teacherName,courseId,courseName,classId,className,period);
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return tl;
}

//插入
public boolean add(TeacherLesson tl) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Insert Into TeacherLesson(t_id,c_id,class_id,period) values(?,?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, tl.getTeacherId());
	ps.setString(2, tl.getCourseId());
	ps.setString(3, tl.getClassId());
	ps.setString(4, tl.getPeriod());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//删除
public boolean delete(int id) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Delete from teacherlesson where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1,id);
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//更新
public boolean update(TeacherLesson tl) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Update teacherlesson set t_id=?,c_id=?,class_id=?,period=? where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);	 
	    ps.setString(1,tl.getTeacherId());
	 ps.setString(2, tl.getCourseId());
	 ps.setString(3, tl.getClassId());
	 ps.setString(4, tl.getPeriod());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}
}
