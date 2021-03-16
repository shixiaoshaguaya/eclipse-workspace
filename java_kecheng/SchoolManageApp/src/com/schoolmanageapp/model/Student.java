package com.schoolmanageapp.model;

import java.util.Date;

public class Student {
private String id;
private String name;
private String sex;
private Date birth;
private String major;
private int scholarShip;
private String address;
private String tel;
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
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public int getScholarShip() {
	return scholarShip;
}
public void setScholarShip(int scholarShip) {
	this.scholarShip = scholarShip;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
/**
 * @param id
 * @param name
 * @param sex
 * @param birth
 * @param major
 * @param scholarShip
 * @param address
 * @param tel
 */
public Student(String id, String name, String sex, Date birth, String major, int scholarShip, String address,
		String tel) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.birth = birth;
	this.major = major;
	this.scholarShip = scholarShip;
	this.address = address;
	this.tel = tel;
}

}
