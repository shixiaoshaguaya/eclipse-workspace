package service;

import java.util.List;

import beans.Book_Student;
import dao.Book_StudentDao;
import utils.Page;

public class Book_StudentService {
	Book_StudentDao book_studentDao = new Book_StudentDao();

	/**
	 * 添加
	 * 
	 * @param book_student
	 * @return
	 */
	public boolean add(Book_Student book_student) {
		return this.book_studentDao.add(book_student);
	}

	public Page<Book_Student> getAllByPage(int pageIndex, int pageSize) {
		return this.book_studentDao.findAll(pageIndex, pageSize);
	}

	/**
	 * 返回所有数据
	 * 
	 * @return
	 */
	public List<Book_Student> getAll() {
		return this.book_studentDao.getAll();
	}

	/**
	 * 获取
	 * 
	 * @param id
	 * @return
	 */
	public Book_Student getById(String id) {
		return this.book_studentDao.find(id);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(String b_id) {
		return this.book_studentDao.delete(b_id);
	}

	/**
	 * 更新
	 * 
	 * @param book_student
	 * @return
	 */
	public boolean update(Book_Student book_student) {
		return this.book_studentDao.update(book_student);
	}
	
	/**
	 * 多条件查询
	 * @param b_id
	 * @param s_id
	 * @return
	 */
	public List<Book_Student> findByManyCondition(String b_id, String s_id){
		return this.book_studentDao.findByManyCondition(b_id, s_id);
	}
}
