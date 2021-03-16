package guiapp.data;

import java.sql.*;
import guiapp.pojo.User;

/**
 * �û�ģ�����ݷ�����
 * 
 */
public class UserDao {
	/**
	 * ��½���
	 */
	public User login(String name, String password) {
		User user = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			// ��ȡ���ݵ�����
			conn = JDBCUtils.getConnection();
			// ����Ҫִ�е�SQL��䣨��������
			String sql = "select name,password,telephone from user where name=? and password=?";
			// ͨ��Connection�����ȡprepareStatement����
			preStmt = conn.prepareStatement(sql);
			// ����SQL�������Ĳ���ֵ�����ύִ�С�
			preStmt.setString(1, name);
			preStmt.setString(2, password);
			rs = preStmt.executeQuery();
			// ����ResultSet�����
			while (rs.next()) {
				String telephone = rs.getString("telephone");// ͨ���б��ȡָ���ֶε�ֵ
				user = new User(name, password, telephone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �������ݿ���Դ
			JDBCUtils.release(rs, preStmt, conn);
		}
		return user;
	}
}
