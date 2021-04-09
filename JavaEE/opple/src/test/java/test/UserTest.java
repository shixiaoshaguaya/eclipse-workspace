package test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pojo.User;

public class UserTest {
//	@Test
	public void allUser() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> users = sqlSession.selectList("dao.UserMapper.allUser");
		for (User u : users) {
			System.out.println("list:" + u);
		}
		sqlSession.close();
	}

	@Test
	public void selectUserById() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User u2 = (User) sqlSession.selectOne("dao.UserMapper.selectUserById3", 15);
		System.out.println("22:" + u2.toString());
		System.out.println();
		sqlSession.close();
	}

//	@Test
	public void selectUserName() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User u2 = (User) sqlSession.selectOne("dao.UserMapper.selectUserName3", "admin");
		System.out.println("22:" + u2.toString());
		System.out.println();
		sqlSession.close();
	}

//	@Test
	public void insertUser() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("test01");
		user.setPassword("123456");
		user.setTelephone("13308091212");
		int row = sqlSession.insert("dao.UserMapper.insertUser", user);
		sqlSession.commit();
		if (row > 0) {
			System.out.println("您成功插入了" + row + "条记录！记录编号为：" + user.getId());
		} else {
			System.out.println("执行插入操作失败！！！");
		}
		sqlSession.close();
	}

//	@Test
	public void selectUserByName() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(5);
		user.setUsername("5");
		user.setPassword("555");
		user.setTelephone("13308091717");
		int row = sqlSession.update("dao.UserMapper.updateUser", user);
		if (row > 0) {
			System.out.println("您成功修改了" + row + "条记录！记录编号为：" + user.getId());
		} else {
			System.out.println("执行修改操作失败！！！");
		}
		sqlSession.commit();
		sqlSession.close();
	}

//	@Test
	public void deleteUser() throws IOException {
		String resourse = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resourse);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int row = sqlSession.delete("dao.UserMapper.deleteUser", 9);
		if (row > 0) {
			System.out.println("您成功地删除了" + row + "条记录！");
		} else {
			System.out.println("执行删除操作失败！！！");
		}
		sqlSession.commit();
		sqlSession.close();
	}
}
