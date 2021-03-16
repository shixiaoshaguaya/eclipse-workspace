package com.schoolmanageapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.schoolmanageapp.model.*;
import com.schoolmanageapp.util.JDBCUtil;
//实现对数据库Course表的增加、删除、修改、查询等访问功能接口
public class StudentDao {
	//返回数据库表中所有记录
public List<Student> getAll() throws Exception{
	List<Student> studentList = new ArrayList<Student>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select s_id,s_name,s_sex,s_birth,s_major,s_scholarship,s_address,s_tel from Student order by s_id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        String id = rs.getString("s_id");
        String name = rs.getString("s_name");
        String sex = rs.getString("s_sex");
        Date birth=rs.getDate("s_birth");
        String major=rs.getString("s_major");
        int scholarShip=rs.getInt("s_scholarship");
        String address=rs.getString("s_address");
        String tel=rs.getString("s_tel");
       
        Student s = new Student(id, name, sex, birth, major, scholarShip, address,tel);
        studentList.add(s);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return studentList;
}

//根据条件查询(主键)
public Student getById(String id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select s_id,s_name,s_sex,s_birth,s_major,s_scholarship,s_address,s_tel from Student where s_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,id);
	    ResultSet rs = ps.executeQuery();
	    Student s =null;
	    if(rs.next()){		    
	         String name = rs.getString("s_name");
	         String sex = rs.getString("s_sex");
	         Date birth=rs.getDate("s_birth");
	         String major=rs.getString("s_major");
	         int scholarShip=rs.getInt("s_scholarship");
	         String address=rs.getString("s_address");
	         String tel=rs.getString("s_tel");	        
	         s = new Student(id, name, sex, birth, major, scholarShip, address,tel);
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return s;
}

//插入
public boolean add(Student s) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Insert Into Student(s_id,s_name,s_sex,s_birth,s_major,s_scholarship,s_address,s_tel) values(?,?,?,?,?,?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,s.getId());
	    ps.setString(2,s.getName());
	    ps.setString(3,s.getSex());
	    ps.setDate(4,new java.sql.Date(s.getBirth().getTime()));
	    ps.setString(5,s.getMajor());
	    ps.setInt(6, s.getScholarShip());
	    ps.setString(7, s.getAddress());
	    ps.setString(8, s.getTel());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//删除
public boolean delete(String id) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Delete from Student where s_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,id);
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//更新
public boolean update(Student s) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Update Student set s_name=?,s_sex=?,s_birth=?,s_major=?,s_scholarship=?,s_address=?,s_tel=? where s_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);	 
	    ps.setString(1,s.getName());
	    ps.setString(2,s.getSex());
	    ps.setDate(3,new java.sql.Date(s.getBirth().getTime()));
	    ps.setString(4,s.getMajor());
	    ps.setInt(5, s.getScholarShip());
	    ps.setString(6,s.getAddress());
	    ps.setString(7,s.getTel());
	    ps.setString(8, s.getId());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}
}
