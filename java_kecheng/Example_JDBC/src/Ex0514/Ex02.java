package Ex0514;

import java.sql.*;

public class Ex02 {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3308/example_jdbc?serverTimezone=UTC&characterEncoding=utf-8";
			String uesrname = "root";
			String password = "123456";
			// 创建应用程序与数据库连接的Connection对象
			conn = DriverManager.getConnection(url, uesrname, password);
			// 执行的SQL语句
			String sql = "INSERT INTO users(name,password,email,birthday)VALUES(?,?,?,?)";
			// 1.创建执行SQL语句的PrepareStatement对象
			preStmt = conn.prepareStatement(sql);
			// 2.为SQL语句中的参数赋值
			preStmt.setString(1, "zl");
			preStmt.setString(2, "123456");
			preStmt.setString(3, "zl@sina.com");
			preStmt.setString(4, "1789-12-23");
			// 3.执行SQL
			preStmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				preStmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}

	}
}
