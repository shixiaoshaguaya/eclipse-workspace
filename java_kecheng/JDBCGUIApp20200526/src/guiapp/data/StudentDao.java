package guiapp.data;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import guiapp.pojo.Student;

public class StudentDao {
	public List<Student> getAll() {
		List<Student> studentLst = new ArrayList<Student>();
		Student student;
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3308/student_info?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			String sql = "select * from student";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String collage = rs.getString("collage");
				student = new Student(id, name, sex, collage, birthday);
				studentLst.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return studentLst;
	}

	public boolean add(Student student) {
		Statement stmt = null;
		int result = 0;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3308/student_info?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthday = sdf.format(student.getBirthday());
			String sql = "insert into student(name,sex,birthday,collage) values('" + student.getName() + "'," + "'"
					+ student.getSex() + "','" + birthday + "','" + student.getCollage() + "')";
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据id查找学生的方法
	 * 
	 * @param id
	 * @return
	 */
	public Student getById(Integer id) {
		Student student = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			// 1. 注册数据库的驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.通过DriverManager获取数据库连接
			String url = "jdbc:mysql://localhost:3308/student_info?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
			// 3.定义要执行的SQL语句（带参数）
			String sql = "select id,name,sex,birthday,collage from student where id=?";
			// 4.通过Connection对象获取prepareStatement对象
			preStmt = conn.prepareStatement(sql);
			// 5.设置SQL语句所需的参数值，并提交执行。
			preStmt.setInt(1, id);
			rs = preStmt.executeQuery();
			// 6. 操作ResultSet结果集
			while (rs.next()) {
				String name = rs.getString("name");// 通过列名获取指定字段的值
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				String collage = rs.getString("collage");
				student = new Student(id, name, sex, collage, birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.回收数据库资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				preStmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return student;
	}

	/**
	 * 根据id删除指定用户的方法
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id) {
		PreparedStatement preStmt = null;
		int result = 0;
		Connection conn = null;
		try {
			// 1. 注册数据库的驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.通过DriverManager获取数据库连接
			String url = "jdbc:mysql://localhost:3308/student_info?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
			// 3.定义要执行的SQL语句（带参数）
			String sql = "delete from student where id=?";
			// 4.通过Connection对象获取prepareStatement对象
			preStmt = conn.prepareStatement(sql);
			// 5.设置SQL语句所需的参数值，并提交执行。
			preStmt.setInt(1, id);
			result = preStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.回收数据库资源
			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				preStmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 更新学生信息的方法
	 * 
	 * @param student
	 * @return
	 */
	public boolean update(Student student) {
		PreparedStatement preStmt = null;
		int result = 0;
		Connection conn = null;
		try {
			// 1. 注册数据库的驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.通过DriverManager获取数据库连接
			String url = "jdbc:mysql://localhost:3308/student_info?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
			// 3.定义要执行的SQL语句（带参数）
			String sql = "update student set name=?,sex=?,birthday=?,collage=? where id=?";
			// 4.通过Connection对象获取prepareStement对象
			preStmt = conn.prepareStatement(sql);
			// 5.设置SQL语句所需的参数值，并提交执行。
			preStmt.setString(1, student.getName());
			preStmt.setString(2, student.getSex());
			Date birthday = new Date(student.getBirthday().getTime());
			preStmt.setDate(3, birthday);
			preStmt.setString(4, student.getCollage());
			preStmt.setInt(5, student.getId());
			result = preStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.回收数据库资源
			if (preStmt != null) {
				try {
					preStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				preStmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
}