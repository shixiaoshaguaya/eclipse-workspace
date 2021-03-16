package 实验12_20200428;

//向表book插入一条记录："tp276-1-10"、"西游记"、"吴承恩"、"1990-12-23"
//导入java sql工具集
import java.sql.*;

public class dbInsert {
	// 0、准备基本
	// jdbc驱动名及数据库连接（主机、端口、数据库）
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mytest";
	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "cz@177511";

	public static void main(String[] args) {
		// 声明连接对象、执行对象
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			// 1、 注册数据库的驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、通过DriverManager获取数据库连接
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// 3、构建执行的SQL语句
			String sql = "INSERT INTO book(bookid,bname,bauthor,bptime)" + "VALUES(?,?,?,?)";
			// 4、通过Connection对象获取prepareStatement对象
			preStmt = conn.prepareStatement(sql);
			// 5、为SQL语句中的参数赋值
			preStmt.setString(1, "tp276-1-10");
			preStmt.setString(2, "西游记");
			preStmt.setString(3, "吴承恩");
			preStmt.setString(4, "1990-12-23");
			// 6、执行SQL
			int i = preStmt.executeUpdate();
			if (i > 0) {
				System.out.println("记录插入成功!");
			} else {
				System.out.println("记录插入失败!");
			}

		} catch (Exception e) {
			// 处理Class.forName错误
			e.printStackTrace();
		} finally {
			// 6、回收数据库资源
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
