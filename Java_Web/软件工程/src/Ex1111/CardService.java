package Ex1111;

import java.util.List;

public class CardService {
	private CardDao dao;

	public CardService() {
		dao = new CardDao();
	}

	public List<Card> getAll() throws Exception {
		return dao.getAll();
	}
	
	/**
	 * ����������ѯ(����)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Card getById(String CardNumber) throws Exception {
		return dao.getById(CardNumber);
	}
	
	/**����
	 * @param card
	 * @return
	 * @throws Exception
	 */
		public boolean update(Card card) throws Exception {
			return dao.update(card);
		}
}
