package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pojo.Order;
import pojo.User;

public class AllTest {
	@Test
	public void selectUserByIdTest() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
//		List<Order> ols = sqlSession.selectList("dao.OrderMapper.selectOrderByUid", 15);
//		for (Order order : ols) {
//			System.out.println("方法一：" + order.toString());
//		}
		User ul = sqlSession.selectOne("dao.UserMapper.selectUserById2", 15);
		System.out.println("方法一：" + ul.toString());
	}

//	@Test
	public void allUser() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> users = sqlSession.selectList("dao.UserMapper.allUser");
		for (User u : users) {
			System.out.println(u.toString());
		}
		sqlSession.close();
	}
}
