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
					+ student.getSex() + "','"+birthday+"','" + student.getCollage() + "')";
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
}