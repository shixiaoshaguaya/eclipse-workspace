package 实验12_20200428;

//记录指针控制
//导入java sql工具集
import java.sql.*;

public class dbRecordset {
	// 0、准备基本
	// jdbc驱动名及数据库连接（主机、端口、数据库）
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/20200428-12?useUnicode=true&characterEncoding=UTF-8";
	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "cz@177511";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 声明连接对象、执行对象、结果集
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			// 1、 注册数据库的驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、通过DriverManager获取数据库连接
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// 3、通过Connection对象获取Statement对象
			String sql;
			sql="select * from student";
			preStmt = conn.prepareStatement(sql);
			// 4、使用Statement执行SQL语句。
			rs = preStmt.executeQuery(sql);

			// 5、取出ResultSet中指定数据的信息
			System.out.print("第2条数据的sname值为:");
			rs.absolute(2);        //将指针定位到结果集中第2行数据
			System.out.println(rs.getString("sname"));
			System.out.print("第1条数据的sname值为:");
			rs.beforeFirst();      //将指针定位到结果集中第1行数据之前
			rs.next();              //将指针向后滚动
			System.out.println(rs.getString("sname"));
			System.out.print("倒数第1条数据的name值为:");
			rs.afterLast();        //将指针定位到结果集中最后一条数据之后
			rs.previous();         //将指针向前滚动
			System.out.println(rs.getString("sname"));
		} catch (Exception e) {
			// 处理Class.forName错误
			e.printStackTrace();
		} finally {
			// 6、回收数据库资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				preStmt = null;
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
