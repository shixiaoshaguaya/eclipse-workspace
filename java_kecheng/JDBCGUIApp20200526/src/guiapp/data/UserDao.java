package guiapp.data;

import java.sql.*;
import guiapp.pojo.User;

/**
 * 用户模块数据访问类
 * 
 */
public class UserDao {
	/**
	 * 登陆检查
	 */
	public User login(String name, String password) {
		User user = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			// 获取数据的连接
			conn = JDBCUtils.getConnection();
			// 定义要执行的SQL语句（带参数）
			String sql = "select name,password,telephone from user where name=? and password=?";
			// 通过Connection对象获取prepareStatement对象
			preStmt = conn.prepareStatement(sql);
			// 设置SQL语句所需的参数值，并提交执行。
			preStmt.setString(1, name);
			preStmt.setString(2, password);
			rs = preStmt.executeQuery();
			// 操作ResultSet结果集
			while (rs.next()) {
				String telephone = rs.getString("telephone");// 通过列表获取指定字段的值
				user = new User(name, password, telephone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 回收数据库资源
			JDBCUtils.release(rs, preStmt, conn);
		}
		return user;
	}
}
