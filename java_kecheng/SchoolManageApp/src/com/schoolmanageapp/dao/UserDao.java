package com.schoolmanageapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.model.*;
import com.schoolmanageapp.util.JDBCUtil;
//实现对数据库user表的增加、删除、修改、查询等访问功能接口
public class UserDao {
	//返回数据库User表中所有记录
public List<User> getAll() throws Exception{
	List<User> userList = new ArrayList<User>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select id,name,password,role from User order by id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String password = rs.getString("password");
        String role = rs.getString("role");        
        User usr = new User(id, name, password,role);
        userList.add(usr);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return userList;
}

//根据条件查询(主键)
public User getById(int id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select id,name,password,role from User where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,String.valueOf(id));
	    ResultSet rs = ps.executeQuery();
	    User usr=null;
	    if(rs.next()){
	        String name = rs.getString("name");
	        String password = rs.getString("password");
	        String role = rs.getString("role");        
	        usr = new User(id, name, password,role);	      
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return usr;
}

//插入
public boolean add(User usr) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Insert Into User(name,password,role) values(?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,usr.getName());
	    ps.setString(2, usr.getPassword());
	    ps.setString(3, usr.getRole());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//删除
public boolean delete(int id) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Delete from User where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,String.valueOf(id));
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//更新
public boolean update(User usr) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Update User set name=?,password=?,role=？ where id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,usr.getName());
	    ps.setString(2, usr.getPassword());
	    ps.setString(3, usr.getRole());
	    ps.setInt(4,usr.getId());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//登录账号密码检查

public User loginCheck(String name,String password) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select id,name,password,role from User where name=? and password=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,name);
	    ps.setString(2,password);
	    ResultSet rs = ps.executeQuery();
	    User usr=null;
	    if(rs.next()){
	    	int id=rs.getInt("id");
	        String role = rs.getString("role");        
	        usr = new User(id, name, password,role);	      
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return usr;
}

}
