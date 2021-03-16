package cz_JDBC.dao;

import java.sql.*;
import java.util.ArrayList;

import cz_JDBC.beans.User;
import cz_JDBC.utils.JDBCUtils2;

public class UserDao2 {
	public boolean insert(User user) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			String sql = "INSERT INTO user(name, password) VALUES(?, ?)";
			// 创建一个能够执行含有参数化的SQL语句的PreparedStatement对象
			preStmt = conn.prepareStatement(sql);
			// 创建一个能够执行含有参数的SQL语句作为参数传入，获得的PreparedStatement对象清楚本次SQL语句有哪些参数需要设置
			preStmt.setString(1, user.getName());
			preStmt.setString(2, user.getPassword());
			int rowCount = preStmt.executeUpdate();
			if (rowCount > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, preStmt, conn);
		}
		return false;
	}
	
	public ArrayList<User> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			stmt = conn.createStatement();// 获取Statement对象
			String sql = "SELECT * FROM user";
			rs = stmt.executeQuery(sql);
			User user;
			// 循环读取结果集
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, stmt, conn);
		}
		return null;
	}

	// 根据id查找指定的User
	public User find(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			String sql = "SELECT * FROM user WHERE id=?";
			stmt = conn.prepareStatement(sql);// 获取Statement对象
			stmt.setInt(1, id);// 设置命令中所需的参数值
			rs = stmt.executeQuery();// 发送SQL语句
			// 处理结果集
			if (rs.next()) {
				User user = new User();
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, stmt, conn);
		}
		return null;
	}
	
	// 根据id查找指定的User
		public User findByName(String name) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = JDBCUtils2.getConnection();// 获取数据的连接
				String sql = "SELECT * FROM user WHERE name=?";
				stmt = conn.prepareStatement(sql);// 获取Statement对象
				stmt.setString(1, name);// 设置命令中所需的参数值
				rs = stmt.executeQuery();// 发送SQL语句
				// 处理结果集
				if (rs.next()) {
					User user = new User();
					user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					return user;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils2.release(rs, stmt, conn);
			}
			return null;
		}
	
	// 删除指定用户
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			String sql = "DELETE FROM user WHERE id=?";
			stmt = conn.prepareStatement(sql);// 获取Statement对象
			stmt.setInt(1, id);
			int num = stmt.executeUpdate();// 发送SQL语句
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, stmt, conn);
		}
		return false;
	}
	
	// 修改用户
	public boolean update(User user) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			String sql = "update user set name=?, password=? where id=?";
			preStmt = conn.prepareStatement(sql);// 创建一个能够执行含有参数的SQL语句的PreparedStatement对象
			// 提供了设置本次所需执行SQL语句中需要的参数的值的方法
			preStmt.setString(1, user.getName());
			preStmt.setString(2, user.getPassword());
			preStmt.setInt(3, user.getId());
			int num = preStmt.executeUpdate();// 执行SQL语句，返回受命令影响的记录数
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, preStmt, conn);
		}
		return false;
	}
}
