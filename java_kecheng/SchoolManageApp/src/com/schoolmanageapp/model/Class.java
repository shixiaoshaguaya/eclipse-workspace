package com.schoolmanageapp.model;

public class Class {
private String id;
private String name;
private int num;
private String moniter;
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
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getMoniter() {
	return moniter;
}
public void setMoniter(String moniter) {
	this.moniter = moniter;
}
/**
 * @param id
 * @param name
 * @param num
 * @param monitor
 */
public Class(String id, String name, int num, String monitor) {
	super();
	this.id = id;
	this.name = name;
	this.num = num;
	this.moniter = moniter;
}
}
