package cz_JDBC.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils2 {
	public static DataSource ds = null;
	/*static {
		Properties prop = new Properties();
		try {
			InputStream in = new JDBCUtils().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}*/
	static {
		ComboPooledDataSource cpds = new ComboPooledDataSource("itcast");
		ds = cpds;
	}
	// �������������������ݿ�����
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = ds.getConnection();
		return conn;
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/cz_jdbc?useSSL=false&serverTimezone=GMT&useUnicode=true&characterEncoding=UTF-8";
//		String username = "root";
//		String password = "123456";
//		Connection conn = DriverManager.getConnection(url, username, password);
	}

	// �ر����ݿ����ӣ��ͷ���Դ
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
