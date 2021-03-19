package cn.lmu.ssm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.lmu.ssm.pojo.Product;
import cn.lmu.ssm.pojo.SaleInfo;

@Repository("productDao")
public class ProductDao_SpringJDBC extends ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Product> getProducts() {
		// 定义SQL语句
		String sql = "select * from product";
		// 创建一个新的BeanPropertyRowMapper对象
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		// 执行静态的SQL查询，并通过RowMapper返回结果
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public boolean insert(Product product) {
		// 定义SQL
		String sql = "insert into  product(name,price,quantity) value(?,?,?)";
		// 定义数组来存放SQL语句中的参数
		Object[] obj = new Object[] { product.getName(), product.getPrice(), product.getQuantity() };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		int num = this.jdbcTemplate.update(sql, obj);
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void sale(SaleInfo saleInfo) {
		// 插入销售记录
		// 定义SQL
		String sqlInsert = "insert into  sale(product_id,salePrice,quantity)  value(?,?,?)";
		// 定义数组来存放SQL语句中的参数
		Object[] objInsert = new Object[] { saleInfo.getProduct_id(), saleInfo.getSalePrice(), saleInfo.getQuantity() };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		this.jdbcTemplate.update(sqlInsert, objInsert);

		// 更新产品库存
		String sqlUpdate = "update product  set quantity=quantity-? where id=?";
		// 定义数组来存放SQL语句中的参数
		Object[] objUpdate = new Object[] { saleInfo.getQuantity(), saleInfo.getProduct_id() };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		this.jdbcTemplate.update(sqlUpdate, objUpdate);
	}

	public Product find(int id) {
		String sql = "SELECT * FROM product WHERE id=?";
//		Product product = this.jdbcTemplate.queryForList(sql, new Object[] { id });
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
//		return product;
	}
}
