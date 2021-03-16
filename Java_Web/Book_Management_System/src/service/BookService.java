package service;

import java.util.List;

import beans.Book;
import dao.BookDao;
import utils.Page;

public class BookService {
	BookDao bookDao = new BookDao();

	/**
	 * 添加
	 * 
	 * @param book
	 * @return
	 */
	public boolean add(Book book) {
		return this.bookDao.add(book);
	}
	
	public Page<Book> getAllByPage(int pageIndex, int pageSize) {
		return this.bookDao.findAll(pageIndex, pageSize);
	}

	/**
	 * 返回所有数据
	 * 
	 * @return
	 */
	public List<Book> getAll() {
		return this.bookDao.getAll();
	}

	/**
	 * 获取
	 * 
	 * @param b_id
	 * @return
	 */
	public Book getById(String b_id) {
		return this.bookDao.find(b_id);
	}

	/**
	 * 删除
	 * 
	 * @param b_id
	 * @return
	 */
	public boolean deleteById(String b_id) {
		return this.bookDao.delete(b_id);
	}

	/**
	 * 更新
	 * 
	 * @param book
	 * @return
	 */
	public boolean update(Book book) {
		return this.bookDao.update(book);
	}
	
	/**
	 * 多条件查询
	 * @param b_id
	 * @param b_name
	 * @param writer
	 * @return
	 */
	public List<Book> findByManyCondition(String b_id, String b_name, String writer){
		return this.bookDao.findByManyCondition(b_id, b_name, writer);
	}
}
