package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import beans.Admin;
import utils.C3p0Utils;
import utils.Page;

public class AdminDao {
	/**
	 * �������ݿ�admin�������м�¼
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Admin> getAll() {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM admin";
		List<Admin> list = null;
		try {
			list = (List<Admin>) runner.query(sql, new BeanListHandler(Admin.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ����a_id����ָ����Admin
	 * 
	 * @param a_id
	 * @return
	 * @throws SQLException
	 */
	public Admin find(String a_id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM admin WHERE a_id=?";
		Admin admin = null;
		try {
			admin = (Admin) runner.query(sql, new BeanHandler(Admin.class), new Object[] { a_id });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}

	/**
	 * ����
	 * 
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	public boolean add(Admin admin) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "INSERT INTO admin(a_id, a_name, a_password) VALUES(?, ?, ?)";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { admin.getA_id(), admin.getA_name(), admin.getA_password() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	/**
	 * ɾ��
	 * 
	 * @param a_id
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String a_id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "DELETE FROM admin WHERE a_id=?";
		int num = 0;
		try {
			num = runner.update(sql, a_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	/**
	 * �޸�
	 * 
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	public boolean update(Admin admin) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update admin set a_name=?, a_password=? where a_id=?";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { admin.getA_name(), admin.getA_password(), admin.getA_id() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	public int getAllCount() {
		String sql = "select count(*) from admin";// ����QueryRunner���� 
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource()); // ���÷��� 
		Number num = 0;
		try { 
			num = (Number) runner.query(sql, new ScalarHandler());	
		} 
		catch(SQLException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return num.intValue();
	}
	
	public Page<Admin> findAll(int pageIndex, int pageSize) {
		pageSize = 10;
		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from admin limit ?,?";
		// ���÷���
		List<Admin> list = null;
		try {
			list = (List<Admin>) runner.query(sql, new BeanListHandler(Admin.class),
					new Object[] { (pageIndex - 1) * pageSize, pageSize });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = this.getAllCount();
		// ����Page���ض���
		Page<Admin> result = new Page<Admin>();
		result.setPage(pageIndex);
		result.setRows(list);
		result.setSize(pageSize);
		result.setTotal(count);
		return result;
	}
}
