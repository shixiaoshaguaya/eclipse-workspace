package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pojo.Product;

public class ProductTest {
//	@Test
	public void allProduct() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Product> products = sqlSession.selectList("dao.ProductMapper.allProduct");
		for (Product u : products) {
			System.out.println("list:" + u);
		}
		sqlSession.close();
	}

//	@Test
	public void selectProductById() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Product u2 = (Product) sqlSession.selectOne("dao.ProductMapper.selectProductById", 2);
		System.out.println("22:" + u2.toString());
		System.out.println();
		sqlSession.close();
	}

//	@Test
	public void insertProduct() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Product product = new Product();
		product.setProductname("44");
		product.setCategory("吸顶灯");
		double d = Double.parseDouble("444");
		product.setPrice(d);
		product.setDescription("灯");
		int row = sqlSession.insert("dao.ProductMapper.insertProduct", product);
		sqlSession.commit();
		if (row > 0) {
			System.out.println("您成功插入了" + row + "条记录！记录编号为：" + product.getId());
		} else {
			System.out.println("执行插入操作失败！！！");
		}
		sqlSession.close();
	}

//	@Test
	public void updateProduct() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Product product = new Product();
		product.setId(2);
		product.setProductname("22");
		product.setCategory("筒灯");
		double d = Double.parseDouble("222");
		product.setPrice(d);
		int row = sqlSession.update("dao.ProductMapper.updateProduct", product);
		if (row > 0) {
			System.out.println("您成功修改了" + row + "条记录！记录编号为：" + product.getId());
		} else {
			System.out.println("执行修改操作失败！！！");
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void deleteUser() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int row = sqlSession.delete("dao.ProductMapper.deleteProduct", 3);
		if (row > 0) {
			System.out.println("您成功地删除了" + row + "条记录！");
		} else {
			System.out.println("执行删除操作失败！！！");
		}
		sqlSession.commit();
		sqlSession.close();
	}
}
