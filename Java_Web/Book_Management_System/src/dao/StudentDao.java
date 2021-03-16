package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import beans.Student;
import utils.Page;
import utils.C3p0Utils;

public class StudentDao {
	// ��ѯ��������
	public List<Student> getAll() {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM student";
		List<Student> list = null;
		try {
			list = (List<Student>) runner.query(sql, new BeanListHandler(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// ����s_id��ѯ����
	public Student find(String s_id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM student WHERE s_id=?";
		Student student = null;
		try {
			student = (Student) runner.query(sql, new BeanHandler(Student.class), new Object[] { s_id });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	// �������
	public boolean add(Student student) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "INSERT INTO student(s_id, s_name, s_password, sex, telephone, s_date) VALUES(?, ?, ?, ?, ?, ?)";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { student.getS_id(), student.getS_name(), student.getS_password(),
					student.getSex(), student.getTelephone(), student.getS_date() });
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
	public boolean delete(String s_id) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "DELETE FROM student WHERE s_id=?";
		int num = 0;
		try {
			num = runner.update(sql, s_id);
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
	public boolean update(Student student) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update student set s_name=?, sex=?, telephone=?, s_date=? where s_id=?";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { student.getS_name(), student.getSex(), student.getTelephone(),
					student.getS_date(), student.getS_id() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	public boolean update2(Student student) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update student set s_name=?, s_password=?, sex=?, telephone=?, s_number=?, s_money=?, s_date=?, s_identity=? where s_id=?";
		int num = 0;
		try {
			num = runner.update(sql,
					new Object[] { student.getS_name(), student.getS_password(), student.getSex(),
							student.getTelephone(), student.getS_number(), student.getS_money(), student.getS_date(),
							student.getS_identity(), student.getS_id() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// ����s_number
	public boolean updates_number(Student student) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update student set s_number=? where s_id=?";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { student.getS_number(), student.getS_id() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		}
		return false;
	}

	// ����password
	public boolean updatePassword(Student student) {
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "update student set s_password=? where s_id=?";
		int num = 0;
		try {
			num = runner.update(sql, new Object[] { student.getS_password(), student.getS_id() });
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
		String sql = "select count(*) from student";// ����QueryRunner����
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
	public Page<Student> findAll(int pageIndex, int pageSize) {
		pageSize = 3;
		// ����QueryRunner����
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		// дSQL���
		String sql = "select * from student limit ?,?";
		// ���÷���
		List<Student> list = null;
		try {
			list = (List<Student>) runner.query(sql, new BeanListHandler(Student.class),
					new Object[] { (pageIndex - 1) * pageSize, pageSize });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer count = this.getAllCount();
		// ����Page���ض���
		Page<Student> result = new Page<Student>();
		result.setPage(pageIndex);
		result.setRows(list);
		result.setSize(pageSize);
		result.setTotal(count);
		return result;
	}

	// ������ѯ
	public List<Student> findByManyCondition(String s_id, String s_name) {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from student where 1=1 ";
		QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
		if (s_id != null && s_id.trim().length() > 0) {
			sql += " and s_id=?";
			list.add(s_id);
		}
		if (s_name != null && s_name.trim().length() > 0) {
			sql += " and s_name=?";
			list.add(s_name);
		}
		Object[] params = list.toArray();
		List<Student> sList = null;
		try {
			sList = runner.query(sql, new BeanListHandler<Student>(Student.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sList;
	}
}
