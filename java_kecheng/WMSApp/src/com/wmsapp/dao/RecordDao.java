package com.wmsapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.wmsapp.model.Record;
import com.wmsapp.util.JDBCUtil;

public class RecordDao {
	/**
	 * 返回数据库User表中所有记录
	 * @return
	 * @throws Exception
	 */
	public List<Record> getAll() throws Exception {
		List<Record> recordList = new ArrayList<Record>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select r_Date,g_ID,r_Number,s_ID,r_Type from record order by s_ID";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String r_Date = rs.getString("r_Data");
			String g_ID = rs.getString("g_ID");
			String r_Number = rs.getString("r_Number");
			String s_ID = rs.getString("s_ID");
			String r_Type = rs.getString("r_Type");
			Record record = new Record(r_Date, g_ID, r_Number, s_ID, r_Type);
			recordList.add(record);
		}
		JDBCUtil.release(rs, ps, conn);
		return recordList;
	}

	/**
	 * 根据条件查询(主键)
	 * @param s_ID
	 * @return
	 * @throws Exception
	 */
	public Record getById(String s_ID) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select r_Date,g_ID,r_Number,s_ID,r_Type from record where s_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(s_ID));
		ResultSet rs = ps.executeQuery();
		Record record = null;
		if (rs.next()) {
			String r_Date = rs.getString("r_Data");
			String g_ID = rs.getString("g_ID");
			String r_Number = rs.getString("r_Number");
			String r_Type = rs.getString("r_Type");
			record = new Record(r_Date, g_ID, r_Number, s_ID, r_Type);
		}
		JDBCUtil.release(rs, ps, conn);
		return record;
	}

	/**
	 * 插入
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public boolean add(Record record) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Insert Into record(r_Date,g_ID,r_Number,s_ID,r_Type) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, record.getR_Date());
		ps.setString(2, record.getG_ID());
		ps.setString(3, record.getR_Number());
		ps.setString(4, record.getS_ID());
		ps.setString(5, record.getR_Type());
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}

	/**
	 * 删除
	 * @param s_ID
	 * @return
	 * @throws Exception
	 */
	public boolean delete(String s_ID) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Delete from record where s_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(s_ID));
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}

	/**
	 * 更新
	 * @param record
	 * @return
	 * @throws Exception
	 */
	public boolean update(Record record) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Update User set r_Date=?, g_ID=?, r_Number=?, r_Type=? where s_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, record.getR_Date());
		ps.setString(2, record.getG_ID());
		ps.setString(3, record.getR_Number());
		ps.setString(4, record.getR_Type());
		ps.setString(5, record.getS_ID());
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}

}
