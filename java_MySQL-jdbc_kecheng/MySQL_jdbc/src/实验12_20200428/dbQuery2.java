package 实验12_20200428;

//获取字段名，显示记录数据;查询所有姓邓同学的学号、姓名、课程名、成绩
//导入java sql工具集
import java.sql.*;

public class dbQuery2 {
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
			// 3、通过Connection对象获取PreparedStatement对象
			String sql;
			sql = "SELECT student.sno,sname,cname,degree ";
			sql = sql + "FROM student join sc on student.sno=sc.sno join course on sc.cno=course.cno ";
			sql = sql + "where sname like "+"'陈%'";
			// sql = sql+"where sname like ?";executeQuery方法不能应用占位符
			preStmt = conn.prepareStatement(sql);

			// 4、使用Statement执行SQL语句。
			rs = preStmt.executeQuery(sql);

			// 5、获取元数据，输出列名
			ResultSetMetaData rem = rs.getMetaData();
			for (int i = 1; i <= rem.getColumnCount(); i++) {// 获取从1到字段的数量
				System.out.print(rem.getColumnName(i) + "\t");
			}
			System.out.println();
			// 6、操作ResultSet结果集，显示记录
			while (rs.next()) {
				for (int i = 1; i <= rem.getColumnCount(); i++) {
					System.out.print(rs.getString(i) + "\t");// 取字段的值，按次序
				}
				System.out.println();
			}
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
