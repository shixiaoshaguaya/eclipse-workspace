package com.schoolmanageapp.model;

public class TeacherLesson {
private int id;
private String teacherId;
private String courseId;
private String classId;
private String period;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTeacherId() {
	return teacherId;
}
public void setTeacherId(String teacherId) {
	this.teacherId = teacherId;
}
public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public String getClassId() {
	return classId;
}
public void setClassId(String classId) {
	this.classId = classId;
}
public String getPeriod() {
	return period;
}
public void setPeriod(String period) {
	this.period = period;
}
/**
 * @param teacherId
 * @param courseId
 * @param classId
 * @param period
 */
public TeacherLesson(int id, String courseId, String classId, String teacherId,String period) {
	super();
	this.id=id;
	this.teacherId = teacherId;
	this.courseId = courseId;
	this.classId = classId;
	this.period = period;
}

}
