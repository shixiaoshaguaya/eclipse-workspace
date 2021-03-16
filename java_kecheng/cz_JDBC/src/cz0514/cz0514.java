package cz0514;

import java.sql.*;

public class cz0514 {
	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs =null;
		Connection conn=null;
		PreparedStatement preStmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3308/cz_jdbc?serverTimezone=UTC&characterEncoding=utf-8";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url,username,password);
			stmt = conn.createStatement();
			String sql = "select * from users";
			rs = stmt.executeQuery(sql);
			System.out.println("id |   name   |   password |   email    |   birthday");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String psw = rs.getString("password");
				String email = rs.getString("email");
				Date birthday = rs.getDate("birthday");
				System.out.println(id+"  |   "+name+"     |   "+psw+"   |"+email+ " |   "+birthday);
			}
			String sql1 = "INSERT INTO users(name,password,email,birthday)VALUES(?,?,?,?)";
			preStmt = conn.prepareStatement(sql1);
			preStmt.setString(1, "hzx");
			preStmt.setString(2, "123456");
			preStmt.setString(3, "hzx@sina.com");
			preStmt.setString(4, "2000-10-23");
			preStmt.executeUpdate();
			String sql2 = "select * from users";
			rs = stmt.executeQuery(sql2);
			System.out.println("id |   name   |   password |   email    |   birthday");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String psw = rs.getString("password");
				String email = rs.getString("email");
				Date birthday = rs.getDate("birthday");
				System.out.println(id+"  |   "+name+"     |   "+psw+"   |"+email+ " |   "+birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt !=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				preStmt = null;
			}
		}
	}
}
