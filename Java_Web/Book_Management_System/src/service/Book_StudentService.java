package service;

import java.util.List;

import beans.Book_Student;
import dao.Book_StudentDao;
import utils.Page;

public class Book_StudentService {
	Book_StudentDao book_studentDao = new Book_StudentDao();

	/**
	 * ���
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
	 * ������������
	 * 
	 * @return
	 */
	public List<Book_Student> getAll() {
		return this.book_studentDao.getAll();
	}

	/**
	 * ��ȡ
	 * 
	 * @param id
	 * @return
	 */
	public Book_Student getById(String id) {
		return this.book_studentDao.find(id);
	}

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(String b_id) {
		return this.book_studentDao.delete(b_id);
	}

	/**
	 * ����
	 * 
	 * @param book_student
	 * @return
	 */
	public boolean update(Book_Student book_student) {
		return this.book_studentDao.update(book_student);
	}
	
	/**
	 * ��������ѯ
	 * @param b_id
	 * @param s_id
	 * @return
	 */
	public List<Book_Student> findByManyCondition(String b_id, String s_id){
		return this.book_studentDao.findByManyCondition(b_id, s_id);
	}
}
