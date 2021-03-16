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
			// ����Ӧ�ó��������ݿ����ӵ�Connection����
			conn = DriverManager.getConnection(url, uesrname, password);
			// ִ�е�SQL���
			String sql = "INSERT INTO users(name,password,email,birthday)VALUES(?,?,?,?)";
			// 1.����ִ��SQL����PrepareStatement����
			preStmt = conn.prepareStatement(sql);
			// 2.ΪSQL����еĲ�����ֵ
			preStmt.setString(1, "zl");
			preStmt.setString(2, "123456");
			preStmt.setString(3, "zl@sina.com");
			preStmt.setString(4, "1789-12-23");
			// 3.ִ��SQL
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
