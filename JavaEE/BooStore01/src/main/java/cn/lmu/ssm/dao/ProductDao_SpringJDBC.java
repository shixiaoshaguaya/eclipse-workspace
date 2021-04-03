package cn.lmu.ssm.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.lmu.ssm.pojo.Product;
import cn.lmu.ssm.pojo.SaleInfo;

@Repository("productDao")
public class ProductDao_SpringJDBC extends ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@Autowired
//	private PlatformTransactionManager transactionManager;

	private SqlSessionFactory sqlSessionFactory = null;

	public ProductDao_SpringJDBC() throws IOException {
		// 不使用Spring方式创建，反之可以直接用注解由Spring自动创建
		// 1. 创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 2. 加载SqlMapConfig.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 3. 创建SqlSessionFactory对象
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}

	@Override
	public List<Product> getProducts() {
//		// 定义SQL语句
//		String sql = "select * from product";
//		// 创建一个新的BeanPropertyRowMapper对象
//		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
//		// 执行静态的SQL查询，并通过RowMapper返回结果
//		return this.jdbcTemplate.query(sql, rowMapper);

		// 4. 创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 5. 执行SqlSession对象执行查询，获取结果User
		// 第一个参数是product.xml的statement的id；
		List<Product> products = sqlSession.selectList("getProducts");
		return products;
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

//	@SuppressWarnings("unchecked")
	@Transactional
	public void sale(SaleInfo saleInfo) {
		// 插入销售记录
		// 定义SQL
		String sqlInsert = "insert into  sale(product_id,salePrice,quantity)  value(?,?,?)";
		// 定义数组来存放SQL语句中的参数
		Object[] objInsert = new Object[] { saleInfo.getProduct_id(), saleInfo.getSalePrice(), saleInfo.getQuantity() };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		this.jdbcTemplate.update(sqlInsert, objInsert);
//		int div = 1 / 0;// 模拟异常
		// 更新产品库存
		String sqlUpdate = "update product  set quantity=quantity-? where id=?";
		// 定义数组来存放SQL语句中的参数
		Object[] objUpdate = new Object[] { saleInfo.getQuantity(), saleInfo.getProduct_id() };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		this.jdbcTemplate.update(sqlUpdate, objUpdate);

//		TransactionTemplate tt = new TransactionTemplate(this.transactionManager);
//		tt.execute(new TransactionCallback() {
//			public Object doInTransaction(TransactionStatus status) {
//				// 定义SQL
//				String sqlInsert = "insert into sale(product_id,salePrice,quantity) value(?,?,?)";
//				// 定义数组来存放SQL语句中的参数
//				Object[] objInsert = new Object[] { saleInfo.getProduct_id(), saleInfo.getSalePrice(),
//						saleInfo.getQuantity() };
//				// 执行添加操作，返回的是受SQL语句影响的记录条数
//
//				String sqlUpdate = "update product set quantity=quantity-? where id=?";
//				// 定义数组来存放SQL语句中的参数
//				Object[] objUpdate = new Object[] { saleInfo.getQuantity(), saleInfo.getProduct_id() };
//				// 执行添加操作，返回的是受SQL语句影响的记录条数
//				jdbcTemplate.update(sqlInsert, objInsert);
////				int div = 1 / 0;// 模拟异常
//				// 更新产品库存
//				jdbcTemplate.update(sqlUpdate, objUpdate);
//				return null;
//			}
//		});
	}

	public Product find(int id) {
//		String sql = "SELECT * FROM product WHERE id=?";
////		Product product = this.jdbcTemplate.queryForList(sql, new Object[] { id });
//		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
//		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
////		return product;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		Product product = sqlSession.selectOne("getProductsById", id);
		return product;
	}
}
