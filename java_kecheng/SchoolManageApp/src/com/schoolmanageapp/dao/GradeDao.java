package com.schoolmanageapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.model.*;
import com.schoolmanageapp.util.JDBCUtil;
//实现对数据库Course表的增加、删除、修改、查询等访问功能接口
public class GradeDao {
	//返回数据库表中所有记录
public List<Grade> getAll() throws Exception{
	List<Grade> gradeList = new ArrayList<Grade>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select id,s_id,c_id,score from grade order by id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    	int id=rs.getInt("id");
        String stuId = rs.getString("s_id");
        String courseId = rs.getString("c_id");
       int score=rs.getInt("score");
        Grade g = new Grade(id,stuId,courseId,score);
        gradeList.add(g);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return gradeList;
}

public List<GradeInfo> getAllInfo() throws Exception{
	List<GradeInfo> gradeList = new ArrayList<GradeInfo>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select id,s_id,s_name,c_id,c_name,score from v_grade order by id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    	int id=rs.getInt("id");
        String studentId = rs.getString("s_id");
        String studentName=rs.getString("s_name");
        String courseId = rs.getString("c_id");
        String courseName=rs.getString("c_name");
       int score=rs.getInt("score");
        GradeInfo g = new GradeInfo(id,studentId,studentName,courseId,courseName,score);
        gradeList.add(g);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return gradeList;
}
//根据条件查询(主键)
public GradeInfo getById(int id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select id,s_id,s_name,c_id,c_name,score from v_grade where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1,id);
	    ResultSet rs = ps.executeQuery();
	    GradeInfo g  =null;
	    if(rs.next()){	
	    	 String studentId = rs.getString("s_id");
	         String studentName=rs.getString("s_name");
	         String courseId = rs.getString("c_id");
	         String courseName=rs.getString("c_name");
	       int score=rs.getInt("score");
	       g = new GradeInfo(id,studentId,studentName,courseId,courseName,score);
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return g;
}
public GradeInfo getInfoById(int id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select id,s_id,s_name,c_id,c_name,score from v_grade order by id";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1,id);
	    ResultSet rs = ps.executeQuery();
	    GradeInfo g  =null;
	    if(rs.next()){		    
	        String stuId = rs.getString("s_id");
	        String stuName=rs.getString("s_name");
	        String courseId = rs.getString("c_id");
	        String courseName=rs.getString("c_name");
	       int score=rs.getInt("score");	       
	       g = new GradeInfo(id, stuId, stuName, courseId, courseName, score);
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return g;
}
//插入
public boolean add(Grade g) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Insert Into Grade(s_id,c_id,score) values(?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, g.getStudentId());
ps.setString(2, g.getCourseId());
ps.setInt(3, g.getScore());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//删除
public boolean delete(int id) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Delete from grade where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1,id);
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//更新
public boolean update(Grade g) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Update grade set s_id=?,c_id=?,score=? where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);	 
	    ps.setString(1,g.getStudentId());
	 ps.setString(2, g.getCourseId());
	 ps.setInt(3, g.getScore());
	 ps.setInt(4, g.getId());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}
}
