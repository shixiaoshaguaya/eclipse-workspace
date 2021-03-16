package service;

import java.util.List;

import beans.Sort;
import dao.SortDao;
import utils.Page;

public class SortService {
	SortDao sortDao = new SortDao();

	/**
	 * 添加
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
	 * 返回所有数据
	 * 
	 * @return
	 */
	public List<Sort> getAll() {
		return this.sortDao.getAll();
	}

	/**
	 * 获取
	 * 
	 * @param sort_id
	 * @return
	 */
	public Sort getById(String sort_id) {
		return this.sortDao.find(sort_id);
	}

	/**
	 * 删除
	 * 
	 * @param sort_id
	 * @return
	 */
	public boolean deleteById(String sort_id) {
		return this.sortDao.delete(sort_id);
	}

	/**
	 * 更新
	 * 
	 * @param sort
	 * @return
	 */
	public boolean update(Sort sort) {
		return this.sortDao.update(sort);
	}
	
	/**
	 * 多条件查询
	 * @param sort_id
	 * @param sort_name
	 * @return
	 */
	public List<Sort> findByManyCondition(String sort_id, String sort_name){
		return this.sortDao.findByManyCondition(sort_id, sort_name);
	}
}
