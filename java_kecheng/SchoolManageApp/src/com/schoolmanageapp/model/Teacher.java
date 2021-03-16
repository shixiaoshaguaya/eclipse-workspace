package com.schoolmanageapp.model;

import java.util.Date;

public class Teacher {
private String id;
private String name;
private String sex;
private Date birth;
private String professionalTitle;
private String department;
private double salary;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public String getProfessionalTitle() {
	return professionalTitle;
}
public void setProfessionalTitle(String professionalTitle) {
	this.professionalTitle = professionalTitle;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public Teacher() {
	
}
/**
 * @param id
 * @param name
 * @param sex
 * @param birth
 * @param professionalTitle
 * @param department
 * @param salary
 */
public Teacher(String id, String name, String sex, Date birth, String professionalTitle, String department,
		double salary) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.birth = birth;
	this.professionalTitle = professionalTitle;
	this.department = department;
	this.salary = salary;
}
}
