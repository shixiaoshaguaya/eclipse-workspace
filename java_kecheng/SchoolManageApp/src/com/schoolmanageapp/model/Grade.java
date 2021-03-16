package com.schoolmanageapp.model;

public class Grade {
private int id;
private String studentId;
private String courseId;
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
public void setStuId(String studentId) {
	this.studentId = studentId;
}
public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
/**
 * @param stuId
 * @param courseId
 * @param grade
 */
public Grade(int id,String studentId, String courseId, int score) {
	super();
	this.id=id;
	this.studentId = studentId;
	this.courseId = courseId;
	this.score = score;
}
}
