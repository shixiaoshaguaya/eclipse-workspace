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
	// ��Ӳ�Ʒ�Ĳ���
	public boolean insert(Product product) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			String sql = "INSERT INTO product(id, title, price, manufacture, stock, picturePath) VALUES(?, ?, ?, ?, ?, ?)";
			// ����һ���ܹ�ִ�к��в�������SQL����PreparedStatement����
			preStmt = conn.prepareStatement(sql);
			// ����һ���ܹ�ִ�к��в�����SQL�����Ϊ�������룬��õ�PreparedStatement�����������SQL�������Щ������Ҫ����
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

	// ��ѯ���е�Product����
	public ArrayList<Product> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			stmt = conn.createStatement();// ��ȡStatement����
			String sql = "SELECT * FROM Product";
			rs = stmt.executeQuery(sql);
			Product product;
			// ѭ����ȡ�����
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

	// ����id����ָ����Product
	public Product find(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			String sql = "SELECT * FROM Product WHERE id=?";
			stmt = conn.prepareStatement(sql);// ��ȡStatement����
			stmt.setString(1, id);// ��������������Ĳ���ֵ
			rs = stmt.executeQuery();// ����SQL���
			// ��������
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

	// ɾ����Ʒ
	public boolean delete(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			String sql = "DELETE FROM Product WHERE id=?";
			stmt = conn.prepareStatement(sql);// ��ȡStatement����
			stmt.setString(1, id);
			int num = stmt.executeUpdate();// ����SQL���
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

	// �޸Ĳ�Ʒ
	public boolean update(Product product) {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils2.getConnection();// ��ȡ���ݵ�����
			String sql = "update product set title=?, price=?, manufacture=?, stock=? where id=?";
			preStmt = conn.prepareStatement(sql);// ����һ���ܹ�ִ�к��в�����SQL����PreparedStatement����
			// �ṩ�����ñ�������ִ��SQL�������Ҫ�Ĳ�����ֵ�ķ���
			preStmt.setString(1, product.getTitle());
			preStmt.setFloat(2, product.getPrice());
			Date dayDatesql = new Date(product.getManufacture().getTime());
			preStmt.setDate(3, dayDatesql);
			preStmt.setInt(4, product.getStock());
			preStmt.setString(5, product.getId());
			int num = preStmt.executeUpdate();// ִ��SQL��䣬����������Ӱ��ļ�¼��
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
	
	// ͳ�Ʋ�Ʒ��¼��
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
		 * String sql = "select count(*) from product";// ����QueryRunner���� QueryRunner
		 * runner = new QueryRunner(C3p0Uitls.getDataSource()); // ���÷��� Number num=0;
		 * try { num = (Number) runner.query(sql, new ScalarHandler()) } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * return num.intValue();
		 */
	}

	// ��ҳ��ѯ���в�Ʒ
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

		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from product limit ?,?";
		// ���÷���
		List<Product> list = null;
		try {
			list = (List<Product>) runner.query(sql, new BeanListHandler(Product.class),
					new Object[] { (pageIndex - 1) * pageSize, pageSize });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = this.getAllProductCount();
		// ����Page���ض���
		Page<Product> result = new Page<Product>();
		result.setPage(pageIndex);
		result.setRows(list);
		result.setSize(pageSize);
		result.setTotal(count);
		return result;
	}
}
