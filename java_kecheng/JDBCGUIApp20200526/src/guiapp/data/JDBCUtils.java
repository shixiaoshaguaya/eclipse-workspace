package guiapp.data;

import java.sql.*;

/**
 * 数据库访问工具类
 */
public class JDBCUtils {
	// 获取一个数据库连接
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// 1. 注册数据库的驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.通过DriverManager获取数据库连接
		String url = "jdbc:mysql://localhost:3308/student_info?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	// 释放相关资源
	public static void release(Statement stmt, Connection conn) {
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

	// 释放资源
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(stmt, conn);
	}

}
