package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import beans.Sort;
import utils.C3p0Utils;
import utils.Page;

public class SortDao {
	// 查询所有数据
	public List<Sort> getAll() {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM sort";
		List<Sort> list = null;
		try {
			list = (List<Sort>) runner.query(sql, new BeanListHandler(Sort.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 根据sort_id查询数据
	public Sort find(String sort_id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM sort WHERE sort_id=?";
		Sort sort = null;
		try {
			sort = (Sort) runner.query(sql, new BeanHandler(Sort.class), new Object[] { sort_id });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sort;
	}

	// 添加数据
	public boolean add(Sort sort) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "INSERT INTO sort(sort_id, sort_name) VALUES(?, ?)";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { sort.getSort_id(), sort.getSort_name() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// 删除数据
	public boolean delete(String sort_id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "DELETE FROM sort WHERE sort_id=?";
		int num = 0;
		try {
			num = runner.update(sql, sort_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// 更新数据
	public boolean update(Sort sort) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update sort set sort_name=? where sort_id=?";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { sort.getSort_name(), sort.getSort_id() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// 统计记录数
	public int getAllCount() {
		String sql = "select count(*) from sort";// 创建QueryRunner对象
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource()); // 调用方法
		Number num = 0;
		try {
			num = (Number) runner.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num.intValue();
	}

	// 分页查询所有数据
	public Page<Sort> findAll(int pageIndex, int pageSize) {
		pageSize = 3;
		// 创建QueryRunner对象
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// 写SQL语句
		String sql = "select * from sort limit ?,?";
		// 调用方法
		List<Sort> list = null;
		try {
			list = (List<Sort>) runner.query(sql, new BeanListHandler(Sort.class),
					new Object[] { (pageIndex - 1) * pageSize, pageSize });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = this.getAllCount();
		// 创建Page返回对象
		Page<Sort> result = new Page<Sort>();
		result.setPage(pageIndex);
		result.setRows(list);
		result.setSize(pageSize);
		result.setTotal(count);
		return result;
	}

	// 条件查询
	public List<Sort> findByManyCondition(String sort_id, String sort_name) {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from sort where 1=1 ";
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		if (sort_id != null && sort_id.trim().length() > 0) {
			sql += " and sort_id=?";
			list.add(sort_id);
		}
		if (sort_name != null && sort_name.trim().length() > 0) {
			sql += " and sort_name=?";
			list.add(sort_name);
		}

		Object[] params = list.toArray();
		List<Sort> sList = null;
		try {
			sList = runner.query(sql, new BeanListHandler<Sort>(Sort.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sList;
	}
}
