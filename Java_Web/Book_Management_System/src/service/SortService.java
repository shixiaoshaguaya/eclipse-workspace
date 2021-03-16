package service;

import java.util.List;

import beans.Sort;
import dao.SortDao;
import utils.Page;

public class SortService {
	SortDao sortDao = new SortDao();

	/**
	 * ���
	 * 
	 * @param sort
	 * @return
	 */
	public boolean add(Sort sort) {
		return this.sortDao.add(sort);
	}

	public Page<Sort> getAllByPage(int pageIndex, int pageSize) {
		return this.sortDao.findAll(pageIndex, pageSize);
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public List<Sort> getAll() {
		return this.sortDao.getAll();
	}

	/**
	 * ��ȡ
	 * 
	 * @param sort_id
	 * @return
	 */
	public Sort getById(String sort_id) {
		return this.sortDao.find(sort_id);
	}

	/**
	 * ɾ��
	 * 
	 * @param sort_id
	 * @return
	 */
	public boolean deleteById(String sort_id) {
		return this.sortDao.delete(sort_id);
	}

	/**
	 * ����
	 * 
	 * @param sort
	 * @return
	 */
	public boolean update(Sort sort) {
		return this.sortDao.update(sort);
	}
	
	/**
	 * ��������ѯ
	 * @param sort_id
	 * @param sort_name
	 * @return
	 */
	public List<Sort> findByManyCondition(String sort_id, String sort_name){
		return this.sortDao.findByManyCondition(sort_id, sort_name);
	}
}
