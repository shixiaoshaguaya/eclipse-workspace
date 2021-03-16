package Ex1111;

import java.util.List;

public class TransService {
	private TransDao dao;

	public TransService() {
		dao = new TransDao();
	}

	public List<Trans> getAll() throws Exception {
		return dao.getAll();
	}
	/**
	 * 根据条件查询(主键)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Trans getById(int id) throws Exception {
		return dao.getById(id);
	}

	/**
	 * 插入
	 * @param trans
	 * @return
	 * @throws Exception
	 */
	public boolean add(Trans trans) throws Exception {
		return dao.add(trans);
	}
}
