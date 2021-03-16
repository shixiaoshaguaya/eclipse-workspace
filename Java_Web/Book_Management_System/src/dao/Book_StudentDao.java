package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import beans.Book_Student;
import utils.C3p0Utils;
import utils.Page;

public class Book_StudentDao {
	// ��ѯ��������
	public List<Book_Student> getAll() {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM book_student";
		List<Book_Student> list = null;
		try {
			list = (List<Book_Student>) runner.query(sql, new BeanListHandler(Book_Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// ����id��ѯ����
	public Book_Student find(String id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM book_student WHERE id=?";
		Book_Student book_student = null;
		try {
			book_student = (Book_Student) runner.query(sql, new BeanHandler(Book_Student.class), new Object[] { id });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book_student;
	}

	// �������
	public boolean add(Book_Student book_student) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "INSERT INTO book_student(b_id, s_id, borrow_date, return_date) VALUES(?, ?, ?, ?)";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { book_student.getB_id(), book_student.getS_id(),
					book_student.getBorrow_date(), book_student.getReturn_date() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// ɾ������
	public boolean delete(String id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "DELETE FROM book_student WHERE id=?";
		int num = 0;
		try {
			num = runner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// ��������
	public boolean update(Book_Student book_student) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update book_student set b_id=?, s_id=?, borrow_date=?, return_date=?, practical_date=?, renew=?, money=? where id=?";
		int num = 0;
		try {
			num = runner.update(sql,
					new Object[] { book_student.getB_id(), book_student.getS_id(), book_student.getBorrow_date(),
							book_student.getReturn_date(), book_student.getPractical_date(), book_student.getRenew(),
							book_student.getMoney(), book_student.getId() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// ͳ�Ƽ�¼��
	public int getAllCount() {
		String sql = "select count(*) from book_student";// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource()); // ���÷���
		Number num = 0;
		try {
			num = (Number) runner.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num.intValue();
	}

	// ��ҳ��ѯ��������
	public Page<Book_Student> findAll(int pageIndex, int pageSize) {
		pageSize = 3;
		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from book_student limit ?,?";
		// ���÷���
		List<Book_Student> list = null;
		try {
			list = (List<Book_Student>) runner.query(sql, new BeanListHandler(Book_Student.class),
					new Object[] { (pageIndex - 1) * pageSize, pageSize });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = this.getAllCount();
		// ����Page���ض���
		Page<Book_Student> result = new Page<Book_Student>();
		result.setPage(pageIndex);
		result.setRows(list);
		result.setSize(pageSize);
		result.setTotal(count);
		return result;
	}

	// ������ѯ
	public List<Book_Student> findByManyCondition(String b_id, String s_id) {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from book_student where 1=1 ";
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		if (b_id != null && b_id.trim().length() > 0) {
			sql += " and b_id=?";
			list.add(b_id);
		}
		if (s_id != null && s_id.trim().length() > 0) {
			sql += " and s_id=?";
			list.add(s_id);
		}
		Object[] params = list.toArray();
		List<Book_Student> b_sList = null;
		try {
			b_sList = runner.query(sql, new BeanListHandler<Book_Student>(Book_Student.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b_sList;
	}
}
