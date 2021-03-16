package com.schoolmanageapp.model;

public class GradeInfo {
	private int id;
	private String studentId;
	private String studentName;
	
	private String courseId;
	private String courseName;
	private int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @param id
	 * @param studentId
	 * @param studentName
	 * @param courseId
	 * @param courseName
	 * @param score
	 */
	public GradeInfo(int id, String studentId, String studentName, String courseId, String courseName, int score) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.score = score;
	}

}
