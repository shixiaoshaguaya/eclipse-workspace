package service;

import java.sql.SQLException;
import java.util.List;

import beans.Student;
import dao.StudentDao;
import utils.Page;

public class StudentService {
	StudentDao studentDao = new StudentDao();
	
	String msg;

	public String getMsg() {
		return msg;
	}

	public StudentService() {
		super();
		studentDao=new StudentDao();
		msg="";
	}

	//注册
	public boolean addUser (Student student) throws SQLException {
		if (this.existUser(student.getS_id())) {
			this.msg = "该用户己存在，请修改新用户名称! ";
			return false;
		}
		if (this.studentDao.add (student)) {
			this.msg = "增加成功! ";
			return true;
		} else {
			this.msg = "增加失败! ";
			return false;
		}
	}
		
		public boolean existUser (String s_id) {
			if (this.studentDao.find(s_id) != null) {
				return true;
			} else {
				return false;
			}
		}
	

	public Student checkLogin(String s_id, String s_password) {
		Student student = null;
		student = studentDao.find(s_id);
		if (student != null) {
			if (student.getS_password().equals(s_password)) {
				return student;
			}
		}
		return null;
	}

	/**
	 * 添加
	 * 
	 * @param student
	 * @return
	 */
	public boolean add(Student student) {
		return this.studentDao.add(student);
	}

	/**
	 * 返回所有数据
	 * 
	 * @return
	 */
	public List<Student> getAll() {
		return this.studentDao.getAll();
	}

	public Page<Student> getAllByPage(int pageIndex, int pageSize) {
		return this.studentDao.findAll(pageIndex, pageSize);
	}

	/**
	 * 获取
	 * 
	 * @param s_id
	 * @return
	 */
	public Student getById(String s_id) {
		return this.studentDao.find(s_id);
	}

	/**
	 * 删除
	 * 
	 * @param s_id
	 * @return
	 */
	public boolean deleteById(String s_id) {
		return this.studentDao.delete(s_id);
	}

	/**
	 * 更新
	 * 
	 * @param student
	 * @return
	 */
	public boolean update(Student student) {
		return this.studentDao.update(student);
	}
	
	public boolean update2(Student student) {
		return this.studentDao.update2(student);
	}
	
	public boolean updates_number(Student student) {
		return this.studentDao.updates_number(student);
	}
	
	public boolean updatePassword(Student student) {
		return this.studentDao.updatePassword(student);
	}
	
	/**
	 * 多条件查询
	 * @param s_id
	 * @param s_name
	 * @return
	 */
	public List<Student> findByManyCondition(String s_id, String s_name) {
		return this.studentDao.findByManyCondition(s_id, s_name);
	}
}
