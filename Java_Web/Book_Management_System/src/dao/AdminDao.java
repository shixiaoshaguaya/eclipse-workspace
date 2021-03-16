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
	 * 返回数据库admin表中所有记录
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
	 * 根据a_id查找指定的Admin
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
	 * 插入
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
	 * 删除
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
	 * 修改
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
		String sql = "select count(*) from admin";// 创建QueryRunner对象 
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource()); // 调用方法 
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
		// 创建QueryRunner对象
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// 写SQL语句
		String sql = "select * from admin limit ?,?";
		// 调用方法
		List<Admin> list = null;
		try {
			list = (List<Admin>) runner.query(sql, new BeanListHandler(Admin.class),
					new Object[] { (pageIndex - 1) * pageSize, pageSize });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = this.getAllCount();
		// 创建Page返回对象
		Page<Admin> result = new Page<Admin>();
		result.setPage(pageIndex);
		result.setRows(list);
		result.setSize(pageSize);
		result.setTotal(count);
		return result;
	}
}
