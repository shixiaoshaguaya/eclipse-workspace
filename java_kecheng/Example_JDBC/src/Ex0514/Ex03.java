package Ex0514;

import java.sql.*;

public class Ex03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3308/example_jdbc?serverTimezone=UTC&characterEncoding=utf-8";
			String username = "root";
			String password = "123456";
			// 1.获取Connection对象
			conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from users";
			// 2.创建Statement对象并设置常量
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// 3.执行SQL并将获取的数据信息存放在ResultSet中
			ResultSet rs = st.executeQuery(sql);
			// 4.取出ResultSet中指定数据的信息
			System.out.print("第2条数据的name值为：");
			rs.absolute(2);// 将指针定位到结果集中第2行数据
			System.out.println(rs.getString("name"));
			System.out.print("第1条数据的name值为：");
			rs.beforeFirst();// 将指针定位到结果集中第1行数据之前
			rs.next();// 将指针向后滚动
			System.out.println(rs.getString("name"));
			System.out.print("第4条数据的name值为：");
			rs.afterLast();// 将指针定位到结果集中最后一天数据之后
			rs.previous();// 将指针向前滚动
			System.out.println(rs.getString("name"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				stmt = null;
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
