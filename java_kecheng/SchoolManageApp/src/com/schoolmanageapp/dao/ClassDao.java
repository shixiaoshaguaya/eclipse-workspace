package com.schoolmanageapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanageapp.model.*;
import com.schoolmanageapp.model.Class;
import com.schoolmanageapp.util.JDBCUtil;
//实现对数据库Class表的增加、删除、修改、查询等访问功能接口
public class ClassDao {
	//返回数据库表中所有记录
public List<Class> getAll() throws Exception{
	List<Class> classList = new ArrayList<Class>();
    Connection conn = JDBCUtil.getConnection();
    String sql="select class_id,class_name,class_num,class_moniter from class order by class_id";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        String id = rs.getString("class_id");
        String name = rs.getString("class_name");
        int num = rs.getInt("class_num");
        String moniter = rs.getString("class_moniter");        
        Class cls = new Class(id, name, num,moniter);
        classList.add(cls);
    }
    JDBCUtil.closeResource(conn, rs, ps);
    return classList;
}

//根据条件查询(主键)
public Class getById(String id) throws Exception {
	 Connection conn = JDBCUtil.getConnection();
	    String sql="select class_id,class_name,class_num,class_moniter from class where class_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,id);
	    ResultSet rs = ps.executeQuery();
	    Class cls =null;
	    if(rs.next()){	    	
	         String name = rs.getString("class_name");
	         int num = rs.getInt("class_num");
	         String moniter = rs.getString("class_moniter");        
	          cls = new Class(id, name, num,moniter);  
	    }
	    JDBCUtil.closeResource(conn, rs, ps);
	    return cls;
}

//插入
public boolean add(Class cls) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Insert Into Class(class_id,class_name,class_num,class_moniter) values(?,?,?,?)";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,cls.getId());
	    ps.setString(2,cls.getName());
	    ps.setInt(3,cls.getNum());
	    ps.setString(4,cls.getMoniter());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//删除
public boolean delete(String id) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Delete from Class where class_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,id);
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}

//更新
public boolean update(Class cls) throws Exception {
	boolean result=false; 	
	Connection conn = JDBCUtil.getConnection();
	    String sql="Update Class set class_name=?,class_num=?,class_moniter=？ where class_id=?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1,cls.getName());
	    ps.setInt(2, cls.getNum());
	    ps.setString(3, cls.getMoniter());
	    ps.setString(4,cls.getId());
	    if(ps.executeUpdate()>0)
	    {result=true;}
	    JDBCUtil.closeResource(conn,ps);
	    return result;
}
}
