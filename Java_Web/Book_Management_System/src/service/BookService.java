package service;

import java.util.List;

import beans.Book;
import dao.BookDao;
import utils.Page;

public class BookService {
	BookDao bookDao = new BookDao();

	/**
	 * ���
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
	 * ������������
	 * 
	 * @return
	 */
	public List<Book> getAll() {
		return this.bookDao.getAll();
	}

	/**
	 * ��ȡ
	 * 
	 * @param b_id
	 * @return
	 */
	public Book getById(String b_id) {
		return this.bookDao.find(b_id);
	}

	/**
	 * ɾ��
	 * 
	 * @param b_id
	 * @return
	 */
	public boolean deleteById(String b_id) {
		return this.bookDao.delete(b_id);
	}

	/**
	 * ����
	 * 
	 * @param book
	 * @return
	 */
	public boolean update(Book book) {
		return this.bookDao.update(book);
	}
	
	/**
	 * ��������ѯ
	 * @param b_id
	 * @param b_name
	 * @param writer
	 * @return
	 */
	public List<Book> findByManyCondition(String b_id, String b_name, String writer){
		return this.bookDao.findByManyCondition(b_id, b_name, writer);
	}
}
