package cn.lmu.ssm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.lmu.ssm.pojo.Product;
import cn.lmu.ssm.utils.JDBCUtils;

@Repository("productDao2")
public class ProductDao_JDBC extends ProductDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public List<Product> getProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			// 发送SQL语句
			String sql = "SELECT * FROM product";
			rs = stmt.executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
				product.setQuantity(rs.getInt("quantity"));
				list.add(product);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public boolean insert(Product product) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = JDBCUtils.getConnection();
			// 获得Statement对象
			stmt = conn.createStatement();
			String sql = "INSERT INTO product(name,price,quantity) " + "VALUES('" + product.getName() + "','"
					+ product.getPrice() + "','" + product.getQuantity() + "')";
			int num = stmt.executeUpdate(sql);
			if (num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
}
