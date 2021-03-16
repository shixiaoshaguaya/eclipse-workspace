package Ex1111;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDao {
	/**
	 * 返回数据库User表中所有记录
	 * @return
	 * @throws Exception
	 */
	public List<Card> getAll() throws Exception {
		List<Card> cardList = new ArrayList<Card>();
		Connection conn = JDBC.getConnection();
		String sql = "select CardNumber, Balance, Password from card order by CardNumber";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String CardNumber = rs.getString("CardNumber");
			double Balance = rs.getDouble("Balance");
			String Password = rs.getString("Password");
			Card card = new Card(CardNumber, Balance, Password);
			cardList.add(card);
		}
		JDBC.release(rs, ps, conn);
		return cardList;
	}
	/**
	 * 根据条件查询(主键)
	 * @param CardNumber
	 * @return
	 * @throws Exception
	 */
	public Card getById(String CardNumber) throws Exception {
		Connection conn = JDBC.getConnection();
		String sql = "select Balance, Password from card where CardNumber=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, CardNumber);
		ResultSet rs = ps.executeQuery();
		Card card = null;
		if (rs.next()) {
			double Balance = rs.getDouble("Balance");
			String Password = rs.getString("Password");
			card = new Card(CardNumber, Balance, Password);
		}
		JDBC.release(rs, ps, conn);
		return card;
	}
	/**
	 * 更新
	 * @param card
	 * @return
	 * @throws Exception
	 */
	public boolean update(Card card) throws Exception {
		boolean result = false;
		Connection conn = JDBC.getConnection();
		String sql = "Update card set Balance=?, Password=? where CardNumber=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, card.getBalance());
		ps.setString(2, card.getPassword());
		ps.setString(3, card.getCardNumber());
		if (ps.executeUpdate() > 0) {
			result = true;
		}
		JDBC.release(ps, conn);
		return result;
	}
}
