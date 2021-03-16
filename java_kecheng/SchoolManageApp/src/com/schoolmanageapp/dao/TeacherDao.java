package com.schoolmanageapp.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.schoolmanageapp.model.*;
import com.schoolmanageapp.util.JDBCUtil;
//实现对数据库Teacher表的增加、删除、修改、查询等访问功能接口
public class TeacherDao {
	//返回数据库表中所有记录
public List<Teacher> getAll() throws Exception{
	List<Teacher> teacherList = new ArrayList<Teacher>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select t_id,t_name,t_sex,t_birth,t_professionaltitle,t_department,t_salary from teacher order by t_id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        String id = rs.getString("t_id");
        String name = rs.getString("t_name");
        String sex = rs.getString("t_sex");
        Date birth=rs.getDate("t_birth");
        String professionalTitle=rs.getString("t_professionaltitle");
        String department=rs.getString("t_department");
        double salary=Double.parseDouble(rs.getBigDecimal("t_salary").toString());
        Teacher t = new Teacher(id, name, sex, birth, professionalTitle, department, salary);
        teacherList.add(t);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return teacherList;
}

public List<Teacher> getAllByCondition(String condition) throws Exception{
	List<Teacher> teacherList = new ArrayList<Teacher>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select t_id,t_name,t_sex,t_birth,t_professionaltitle,t_department,t_salary from teacher where "+condition+" order by t_id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
    	 String id = rs.getString("t_id");
         String name = rs.getString("t_name");
         String sex = rs.getString("t_sex");
         Date birth=rs.getDate("t_birth");
         String professionalTitle=rs.getString("t_professionaltitle");
         String department=rs.getString("t_department");
         double salary=Double.parseDouble(rs.getBigDecimal("t_salary").toString());
         Teacher t = new Teacher(id, name, sex, birth, professionalTitle, department, salary);
         teacherList.add(t);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return teacherList;
}
//根据条件查询(主键)
public Teacher getById(String id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select t_id,t_name,t_sex,t_birth,t_professionaltitle,t_department,t_salary from teacher where t_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,id);
	    ResultSet rs = ps.executeQuery();
	    Teacher t =null;
	    if(rs.next()){		    
	    	 String name = rs.getString("t_name");
	         String sex = rs.getString("t_sex");
	         Date birth=rs.getDate("t_birth");
	         String professionalTitle=rs.getString("t_professionaltitle");
	         String department=rs.getString("t_department");
	         double salary=Double.parseDouble(rs.getBigDecimal("t_salary").toString());
	         t = new Teacher(id, name, sex, birth, professionalTitle, department, salary);
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return t;
}

//插入
public boolean add(Teacher t) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Insert Into Teacher(t_id,t_name,t_sex,t_birth,t_professionaltitle,t_department,t_salary) values(?,?,?,?,?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,t.getId());
	    ps.setString(2,t.getName());
	    ps.setString(3,t.getSex());
	    ps.setDate(4,new java.sql.Date(t.getBirth().getTime()));
	    ps.setString(5,t.getProfessionalTitle());
	    ps.setString(6, t.getDepartment());
	    ps.setBigDecimal(7, BigDecimal.valueOf(t.getSalary()));	   
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//删除
public boolean delete(String id) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Delete from Teacher where t_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,id);
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//更新
public boolean update(Teacher t) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Update Teacher set t_name=?,t_sex=?,t_birth=?,t_professionaltitle=?,t_department=?,t_salary=? where t_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);	 
	    ps.setString(1,t.getName());
	    ps.setString(2,t.getSex());
	    ps.setDate(3,new java.sql.Date(t.getBirth().getTime()));
	    ps.setString(4,t.getProfessionalTitle());
	    ps.setString(5,t.getDepartment());
	    ps.setBigDecimal(6,BigDecimal.valueOf(t.getSalary()));
	    ps.setString(7, t.getId());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}
}
