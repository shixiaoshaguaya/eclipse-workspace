package com.wmsapp.dao;

import java.sql.*;

import com.wmsapp.model.User;
import com.wmsapp.util.JDBCUtil;

public class UserDao {
	/**
	 * µ«¬º’À∫≈√‹¬ÎºÏ≤È
	 * @param u_Name
	 * @param u_Password
	 * @return
	 * @throws Exception
	 */
	public User loginCheck(String u_Name,String u_Password) throws Exception {
		 Connection conn = JDBCUtil.getConnection();
		    String sql="select u_Name, u_Password, u_Type from user where u_Name=? and u_Password=?";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, u_Name);
			ps.setString(2, u_Password);
		    ResultSet rs = ps.executeQuery();
		    User user=null;
		    if(rs.next()){
		    	String u_Type = rs.getString("u_Type");
				user = new User(u_Name, u_Password, u_Type);	      
		    }
		    JDBCUtil.release(rs, ps, conn);
		    return user;
	}

}
