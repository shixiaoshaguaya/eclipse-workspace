package guiapp.data;

import java.sql.*;

/**
 * ���ݿ���ʹ�����
 */
public class JDBCUtils {
	// ��ȡһ�����ݿ�����
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// 1. ע�����ݿ������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.ͨ��DriverManager��ȡ���ݿ�����
		String url = "jdbc:mysql://localhost:3308/student_info?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	// �ͷ������Դ
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

	// �ͷ���Դ
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
