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
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			String sql = "INSERT INTO user(name, password) VALUES(?, ?)";
			// ����һ���ܹ�ִ�к��в�������SQL����PreparedStatement����
			preStmt = conn.prepareStatement(sql);
			// ����һ���ܹ�ִ�к��в�����SQL�����Ϊ�������룬��õ�PreparedStatement�����������SQL�������Щ������Ҫ����
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
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			stmt = conn.createStatement();// ��ȡStatement����
			String sql = "SELECT * FROM user";
			rs = stmt.executeQuery(sql);
			User user;
			// ѭ����ȡ�����
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

	// ����id����ָ����User
	public User find(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			String sql = "SELECT * FROM user WHERE id=?";
			stmt = conn.prepareStatement(sql);// ��ȡStatement����
			stmt.setInt(1, id);// ��������������Ĳ���ֵ
			rs = stmt.executeQuery();// ����SQL���
			// ��������
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
	
	// ����id����ָ����User
		public User findByName(String name) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
				String sql = "SELECT * FROM user WHERE name=?";
				stmt = conn.prepareStatement(sql);// ��ȡStatement����
				stmt.setString(1, name);// ��������������Ĳ���ֵ
				rs = stmt.executeQuery();// ����SQL���
				// ��������
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
	
	// ɾ��ָ���û�
	public boolean delete(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			String sql = "DELETE FROM user WHERE id=?";
			stmt = conn.prepareStatement(sql);// ��ȡStatement����
			stmt.setInt(1, id);
			int num = stmt.executeUpdate();// ����SQL���
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
	
	// �޸��û�
	public boolean update(User user) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			String sql = "update user set name=?, password=? where id=?";
			preStmt = conn.prepareStatement(sql);// ����һ���ܹ�ִ�к��в�����SQL����PreparedStatement����
			// �ṩ�����ñ�������ִ��SQL�������Ҫ�Ĳ�����ֵ�ķ���
			preStmt.setString(1, user.getName());
			preStmt.setString(2, user.getPassword());
			preStmt.setInt(3, user.getId());
			int num = preStmt.executeUpdate();// ִ��SQL��䣬����������Ӱ��ļ�¼��
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
