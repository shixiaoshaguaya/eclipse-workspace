package com.schoolmanageapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.model.*;
import com.schoolmanageapp.util.JDBCUtil;
//实现对数据库Course表的增加、删除、修改、查询等访问功能接口
public class CourseDao {
	//返回数据库表中所有记录
public List<Course> getAll() throws Exception{
	List<Course> courseList = new ArrayList<Course>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select c_id,c_name,c_hours,c_credit,limited_num,c_type from Course order by c_id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        String id = rs.getString("c_id");
        String name = rs.getString("c_name");
        int credit = rs.getInt("c_credit");
        int limitedNum = rs.getInt("limited_num");
        String type = rs.getString("c_type");
        int hours=rs.getInt("c_hours");        
        Course c = new Course(id, name, hours,credit,type,limitedNum);
        courseList.add(c);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return courseList;
}

//根据条件查询(主键)
public Course getById(String id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select c_id,c_name,c_hours,c_credit,limited_num,c_type from Course where c_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,id);
	    ResultSet rs = ps.executeQuery();
	    Course c =null;
	    if(rs.next()){	
	    	 String name = rs.getString("c_name");
	         int credit = rs.getInt("c_credit");
	         int limitedNum = rs.getInt("limited_num");
	         String type = rs.getString("c_type");
	         int hours=rs.getInt("c_hours");        
	         c = new Course(id, name, hours,credit,type,limitedNum);
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return c;
}

//插入
public boolean add(Course c) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Insert Into Course(c_id,c_name,c_hours,c_credit,limited_num,c_type) values(?,?,?,?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,c.getId());
	    ps.setString(2,c.getName());
	    ps.setInt(3,c.getHours());
	    ps.setInt(4, c.getCredit());
	    ps.setInt(5,c.getLimitedNum());
	    ps.setString(6, c.getType());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//删除
public boolean delete(String id) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Delete from Course where c_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,id);
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//更新
public boolean update(Course c) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Update Course set c_name=?,c_hours=?,c_credit=?,limited_num=?,c_type=? where c_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);	 
	    ps.setString(1,c.getName());
	    ps.setInt(2,c.getHours());
	    ps.setInt(3, c.getCredit());
	    ps.setInt(4,c.getLimitedNum());
	    ps.setString(5, c.getType());
	    ps.setString(6,c.getId());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}
}
