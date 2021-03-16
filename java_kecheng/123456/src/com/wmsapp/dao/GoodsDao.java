package com.wmsapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.wmsapp.model.Goods;
import com.wmsapp.util.JDBCUtil;

public class GoodsDao {
	/**
	 * 返回数据库User表中所有记录
	 * @return
	 * @throws Exception
	 */
	public List<Goods> getAll() throws Exception {
		List<Goods> goodsList = new ArrayList<Goods>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select g_ID, g_Name, g_Price, g_Number, g_Factory from goods order by g_ID";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String g_ID = rs.getString("g_ID");
			String g_Name = rs.getString("g_Name");
			float g_Price = rs.getFloat("g_Price");
			int g_Number = rs.getInt("g_Number");
			String g_Factory = rs.getString("g_Factory");
			Goods goods = new Goods(g_ID, g_Name, g_Price, g_Number, g_Factory);
			goodsList.add(goods);
		}
		JDBCUtil.release(rs, ps, conn);
		return goodsList;
	}

	/**根据条件查询(主键)
	 * @param g_ID
	 * @return
	 * @throws Exception
	 */
	public Goods getById(String g_ID) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select g_Name, g_Price, g_Number, g_Factory from goods where g_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(g_ID));
		ResultSet rs = ps.executeQuery();
		Goods goods = null;
		if (rs.next()) {
			String g_Name = rs.getString("g_Name");
			float g_Price = rs.getFloat("g_Price");
			int g_Number = rs.getInt("g_Number");
			String g_Factory = rs.getString("g_Factory");
			goods = new Goods(g_ID, g_Name, g_Price, g_Number, g_Factory);
		}
		JDBCUtil.release(rs, ps, conn);
		return goods;
	}

	/**
	 * 插入
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public boolean add(Goods goods) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Insert Into goods(g_ID,g_Name,g_Price,g_Number,g_Factory) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, goods.getG_ID());
		ps.setString(2, goods.getG_Name());
		ps.setFloat(3, goods.getG_Price());
		ps.setInt(4, goods.getG_Number());
		ps.setString(5, goods.getG_Factory());
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}

	/**
	 * 删除
	 * @param g_ID
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String g_ID) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Delete from goods where g_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(g_ID));
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}

	/**
	 * 更新
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public boolean update(Goods goods) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Update goods set g_Name=?,g_Price=?,g_Number=?,g_Factory=? where g_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, goods.getG_Name());
		ps.setFloat(2, goods.getG_Price());
		ps.setInt(3, goods.getG_Number());
		ps.setString(4, goods.getG_Factory());
		ps.setString(5, goods.getG_ID());
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}
}
