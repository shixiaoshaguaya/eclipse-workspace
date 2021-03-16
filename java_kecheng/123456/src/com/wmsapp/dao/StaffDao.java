package com.wmsapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.wmsapp.model.Staff;
import com.wmsapp.util.JDBCUtil;

public class StaffDao {
	/**
	 * 返回数据库表中所有记录
	 * @return List<Staff>
	 * @throws Exception
	 */
	public List<Staff> getAll() throws Exception {
		List<Staff> StaffList = new ArrayList<Staff>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "select s_ID,s_Name,s_Address,s_Gender,s_Telephone from staff order by s_ID";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String s_ID = rs.getString("s_ID");
			String s_Name = rs.getString("s_Name");
			String s_Address = rs.getString("s_Address");
			String s_Gender = rs.getString("s_Gender");
			String s_Telephone = rs.getString("s_Telephone");
			Staff Staff = new Staff(s_ID, s_Name, s_Address, s_Gender, s_Telephone);
			StaffList.add(Staff);
		}
		JDBCUtil.release(rs, ps, conn);
		return StaffList;
	}

	/**
	 * 根据条件查询(主键)
	 * @param s_ID
	 * @return Staff
	 * @throws Exception
	 */
	public Staff getById(String s_ID) throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "select s_ID,s_Name,s_Address,s_Gender,s_Telephone from staff where s_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(s_ID));
		ResultSet rs = ps.executeQuery();
		Staff Staff = null;
		if (rs.next()) {
			String s_Name = rs.getString("s_Name");
			String s_Address = rs.getString("s_Address");
			String s_Gender = rs.getString("s_Gender");
			String s_Telephone = rs.getString("s_Telephone");
			Staff = new Staff(s_ID, s_Name, s_Address, s_Gender, s_Telephone);
		}
		JDBCUtil.release(rs, ps, conn);
		return Staff;
	}

	/**
	 * 插入
	 * @param staff
	 * @return boolean
	 * @throws Exception
	 */
	public boolean add(Staff staff) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Insert Into staff(s_ID,s_Name,s_Address,s_Gender,s_Telephone) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, staff.getS_ID());
		ps.setString(2, staff.getS_Name());
		ps.setString(3, staff.getS_Address());
		ps.setString(4, staff.getS_Gender());
		ps.setString(5, staff.getS_Telephone());
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}

	/**
	 *  删除
	 * @param id
	 * @return boolean
	 * @throws Exception
	 */
	public boolean delete(String id) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Delete from staff where s_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(id));
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}

	/**
	 *  更新
	 * @param staff
	 * @return boolean
	 * @throws Exception
	 */
	public boolean update(Staff staff) throws Exception {
		boolean result = false;
		Connection conn = JDBCUtil.getConnection();
		String sql = "Update staff set s_Name=?,s_Address=?,s_Gender=?,s_Telephone=? where s_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, staff.getS_Name());
		ps.setString(2, staff.getS_Address());
		ps.setString(3, staff.getS_Gender());
		ps.setString(4, staff.getS_Telephone());
		ps.setString(5, staff.getS_ID());
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBCUtil.release(ps, conn);
		return result;
	}
}
