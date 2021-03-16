package cz_JDBC.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cz_JDBC.beans.Product;
import cz_JDBC.utils.C3p0Utils;
import cz_JDBC.utils.JDBCUtils2;
import cz_JDBC.utils.Page;

public class ProductDao {
	// 添加产品的操作
	public boolean insert(Product product) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			String sql = "INSERT INTO product(id, title, price, manufacture, stock, picturePath) VALUES(?, ?, ?, ?, ?, ?)";
			// 创建一个能够执行含有参数化的SQL语句的PreparedStatement对象
			preStmt = conn.prepareStatement(sql);
			// 创建一个能够执行含有参数的SQL语句作为参数传入，获得的PreparedStatement对象清楚本次SQL语句有哪些参数需要设置
			preStmt.setString(1, product.getId());
			preStmt.setString(2, product.getTitle());
			preStmt.setFloat(3, product.getPrice());
			java.sql.Date dayDatesql = new java.sql.Date(product.getManufacture().getTime());
			preStmt.setDate(4, dayDatesql);
			preStmt.setInt(5, product.getStock());
			preStmt.setString(6, product.getPicturePath());
			int rowCount = preStmt.executeUpdate();
			if (rowCount > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, preStmt, conn);
		}
		return false;
	}

	// 查询所有的Product对象
	public ArrayList<Product> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			stmt = conn.createStatement();// 获取Statement对象
			String sql = "SELECT * FROM Product";
			rs = stmt.executeQuery(sql);
			Product product;
			// 循环读取结果集
			while (rs.next()) {
				product = new Product();
				product.setId(rs.getString("id"));
				product.setTitle(rs.getString("title"));
				product.setPrice(rs.getFloat("price"));
				product.setManufacture(rs.getDate("manufacture"));
				product.setStock(rs.getInt("stock"));
				product.setPicturePath(rs.getString("picturePath"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, stmt, conn);
		}
		return null;
	}

	// 根据id查找指定的Product
	public Product find(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			String sql = "SELECT * FROM Product WHERE id=?";
			stmt = conn.prepareStatement(sql);// 获取Statement对象
			stmt.setString(1, id);// 设置命令中所需的参数值
			rs = stmt.executeQuery();// 发送SQL语句
			// 处理结果集
			if (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setTitle(rs.getString("title"));
				product.setPrice(rs.getFloat("price"));
				product.setManufacture(rs.getDate("manufacture"));
				product.setStock(rs.getInt("stock"));
				return product;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, stmt, conn);
		}
		return null;
	}

	// 删除产品
	public boolean delete(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			String sql = "DELETE FROM Product WHERE id=?";
			stmt = conn.prepareStatement(sql);// 获取Statement对象
			stmt.setString(1, id);
			int num = stmt.executeUpdate();// 发送SQL语句
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, stmt, conn);
		}
		return false;
	}

	// 修改产品
	public boolean update(Product product) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// 获取数据的连接
			String sql = "update product set title=?, price=?, manufacture=?, stock=? where id=?";
			preStmt = conn.prepareStatement(sql);// 创建一个能够执行含有参数的SQL语句的PreparedStatement对象
			// 提供了设置本次所需执行SQL语句中需要的参数的值的方法
			preStmt.setString(1, product.getTitle());
			preStmt.setFloat(2, product.getPrice());
			Date dayDatesql = new Date(product.getManufacture().getTime());
			preStmt.setDate(3, dayDatesql);
			preStmt.setInt(4, product.getStock());
			preStmt.setString(5, product.getId());
			int num = preStmt.executeUpdate();// 执行SQL语句，返回受命令影响的记录数
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, preStmt, conn);
		}
		return false;
	}
	
	// 统计产品记录数
	public int getAllProductCount() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JDBCUtils2.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT count(*) as t FROM Product";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, stmt, conn);
		}
		return count;
		/*
		 * String sql = "select count(*) from product";// 创建QueryRunner对象 QueryRunner
		 * runner = new QueryRunner(C3p0Uitls.getDataSource()); // 调用方法 Number num=0;
		 * try { num = (Number) runner.query(sql, new ScalarHandler()) } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * return num.intValue();
		 */
	}

	// 分页查询所有产品
	public Page<Product> findAll(int pageIndex, int pageSize) {
		pageSize = 3;
		/*Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			conn = JDBCUtils2.getConnection();
			String sql = "SELECT * FROM Product limiy ?, ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (pageIndex - 1) * pageSize);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			Product product;
			while (rs.next()) {
				product = new Product();
				product.setId(rs.getString("id"));
				product.setTitle(rs.getString("title"));
				product.setPrice(rs.getFloat("price"));
				product.setManufacture(rs.getDate("manufacture"));
				product.setStock(rs.getInt("stock"));
				product.setPicturePath(rs.getString("picturePath"));
				list.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils2.release(rs, stmt, conn);
		}*/

		// 创建QueryRunner对象
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// 写SQL语句
		String sql = "select * from product limit ?,?";
		// 调用方法
		List<Product> list = null;
		try {
			list = (List<Product>) runner.query(sql, new BeanListHandler(Product.class),
					new Object[] { (pageIndex - 1) * pageSize, pageSize });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = this.getAllProductCount();
		// 创建Page返回对象
		Page<Product> result = new Page<Product>();
		result.setPage(pageIndex);
		result.setRows(list);
		result.setSize(pageSize);
		result.setTotal(count);
		return result;
	}
}
