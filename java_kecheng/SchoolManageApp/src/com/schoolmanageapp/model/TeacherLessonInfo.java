package com.schoolmanageapp.model;

public class TeacherLessonInfo {
	private int id;
	private String teacherId;
	private String teacherName;
	private String courseId;
	private String courseName;
	private String classId;
	private String className;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public TeacherLessonInfo() {}
	/**
	 * @param id
	 * @param teacherId
	 * @param teacherName
	 * @param courseId
	 * @param courseName
	 * @param classId
	 * @param className
	 * @param period
	 */
	public TeacherLessonInfo(int id, String teacherId, String teacherName, String courseId, String courseName,
			String classId, String className, String period) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.classId = classId;
		this.className = className;
		this.period = period;
	}
}
