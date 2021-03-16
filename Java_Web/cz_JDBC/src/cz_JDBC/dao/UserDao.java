package cz_JDBC.dao;

import java.sql.*;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cz_JDBC.beans.User;
import cz_JDBC.utils.C3p0Utils;

public class UserDao {
	public boolean insert(User user){
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "INSERT INTO user(name, password) VALUES(?, ?)";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { user.getName(), user.getPassword() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	public ArrayList<User> findAll(){
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM user";
		ArrayList<User> list = null;
		try {
			list = (ArrayList<User>) runner.query(sql, new BeanListHandler(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 根据id查找指定的User
	public User find(int id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM user WHERE id=?";
		User user = null;
		try {
			user = (User) runner.query(sql, new BeanHandler(User.class), new Object[] { id });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	// 根据id查找指定的User
	public User findByName(String name) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM user WHERE name=?";
		User user = null;
		try {
			user = (User) runner.query(sql, new BeanHandler(User.class), new Object[] { name });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	// 删除指定用户
	public boolean delete(int id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "DELETE FROM user WHERE id=?";
		int num = 0;
		try {
			num = runner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// 修改用户
	public boolean update(User user) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update user set name=?, password=? where id=?";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] {user.getName(),user.getPassword(),user.getId()});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}
}
