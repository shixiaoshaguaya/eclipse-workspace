package Ex1111;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransDao {
	/**
	 * �������ݿ�User�������м�¼
	 * @return
	 * @throws Exception
	 */
	public List<Trans> getAll() throws Exception {
		List<Trans> transList = new ArrayList<Trans>();
		Connection conn = JDBC.getConnection();
		String sql = "select ID, CardNumber, TransType, TransMoney from trans order by ID";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int ID = rs.getInt("ID");
			String CardNumber = rs.getString("CardNumber");
			String TransType = rs.getString("TransType");
			double TransMoney = rs.getDouble("TransMoney");
			Trans trans = new Trans(ID, CardNumber, TransType ,TransMoney);
			transList.add(trans);
		}
		JDBC.release(rs, ps, conn);
		return transList;
	}
	/**
	 * ����������ѯ(����)
	 * @param ID
	 * @return
	 * @throws Exception
	 */
	public Trans getById(int ID) throws Exception {
		Connection conn = JDBC.getConnection();
		String sql = "select CardNumber, TransType, TransMoney from trans where ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.valueOf(ID));
		ResultSet rs = ps.executeQuery();
		Trans trans = null;
		if (rs.next()) {
			String CardNumber = rs.getString("CardNumber");
			String TransType = rs.getString("TransType");
			double TransMoney = rs.getDouble("TransMoney");
			trans = new Trans(ID, CardNumber, TransType, TransMoney);
		}
		JDBC.release(rs, ps, conn);
		return trans;
	}
	/**
	 * ����
	 * @param trans
	 * @return
	 * @throws Exception
	 */
	public boolean add(Trans trans) throws Exception {
		boolean result = false;
		Connection conn = JDBC.getConnection();
		String sql = "Insert Into trans(ID, CardNumber, TransType, TransMoney) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, trans.getID());
		ps.setString(2, trans.getCardNumber());
		ps.setString(3, trans.getTransType());
		ps.setDouble(4, trans.getTransMoney());
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBC.release(ps, conn);
		return result;
	}
}
