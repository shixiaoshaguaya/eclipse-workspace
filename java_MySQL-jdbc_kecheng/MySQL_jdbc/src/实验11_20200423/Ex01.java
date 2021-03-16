package 实验11_20200423;

import java.sql.*;

public class Ex01{
	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			// 1.注册数据库的驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.通过DriverManager获取数据库连接
			String url = "jdbc:mysql://localhost:3306/20200423-11?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String password = "cz@177511";
			conn = DriverManager.getConnection(url, username, password);
			// 3.通过Connection对象获取Statement对象
			stmt = conn.createStatement();
			// 4.使用Statement执行SQL语句
			String sql = "select * from users";
			rs = stmt.executeQuery(sql);
			// 5.操作ResultSet结果集
			System.out.println("username   |   pwd");
			while (rs.next()) {
				String name = rs.getString("username");
				int pwd = rs.getInt("pwd");
				System.out.println(name + "        |   " + pwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}