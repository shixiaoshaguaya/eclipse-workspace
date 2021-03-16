package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import beans.Book;
import utils.C3p0Utils;
import utils.Page;

public class BookDao {
	// ��ѯ��������
	public List<Book> getAll() {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM book";
		List<Book> list = null;
		try {
			list = (List<Book>) runner.query(sql, new BeanListHandler(Book.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// ����b_id��ѯ����
	public Book find(String b_id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM book WHERE b_id=?";
		Book book = null;
		try {
			book = (Book) runner.query(sql, new BeanHandler(Book.class), new Object[] { b_id });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	// �������
	public boolean add(Book book) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "INSERT INTO book(b_id, b_name, writer, sort_id, price, total_number, current_number, borrow_number, picturePath) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int num = 0;
		try {
			num = runner.update(sql,
					new Object[] { book.getB_id(), book.getB_name(), book.getWriter(), book.getSort_id(),
							book.getPrice(), book.getTotal_number(), book.getCurrent_number(), book.getBorrow_number(),
							book.getPicturePath() });
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
	public boolean delete(String b_id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "DELETE FROM book WHERE b_id=?";
		int num = 0;
		try {
			num = runner.update(sql, b_id);
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
	public boolean update(Book book) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update book set b_name=?, writer=?, sort_id=?, price=?, total_number=?, current_number=?, borrow_number=? where b_id=?";
		int num = 0;
		try {
			num = runner.update(sql,
					new Object[] { book.getB_name(), book.getWriter(), book.getSort_id(), book.getPrice(),
							book.getTotal_number(), book.getCurrent_number(), book.getBorrow_number(),
							book.getB_id() });
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
		String sql = "select count(*) from book";// ����QueryRunner����
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
	public Page<Book> findAll(int pageIndex, int pageSize) {
		pageSize = 3;
		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from book limit ?,?";
		// ���÷���
		List<Book> list = null;
		try {
			list = (List<Book>) runner.query(sql, new BeanListHandler(Book.class),
					new Object[] { (pageIndex - 1) * pageSize, pageSize });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = this.getAllCount();
		// ����Page���ض���
		Page<Book> result = new Page<Book>();
		result.setPage(pageIndex);
		result.setRows(list);
		result.setSize(pageSize);
		result.setTotal(count);
		return result;
	}

	// ������ѯ
	public List<Book> findByManyCondition(String b_id, String b_name, String writer) {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from book where 1=1 ";
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		if (b_id != null && b_id.trim().length() > 0) {
			sql += " and b_id=?";
			list.add(b_id);
		}
		if (b_name != null && b_name.trim().length() > 0) {
			sql += " and b_name=?";
			list.add(b_name);
		}
		if (writer != null && writer.trim().length() > 0) {
			sql += " and writer=?";
			list.add(writer);
		}
		Object[] params = list.toArray();
		List<Book> bList = null;
		try {
			bList = runner.query(sql, new BeanListHandler<Book>(Book.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bList;
	}
}
