package com.schoolmanageapp.model;

public class Course {
	 private String id;
	  private String name;
	  private int hours;// '学时',
	  private int credit;//'学分',
	  private String type;//'课程类型',
	  private int limitedNum;//'限选人数',
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
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLimitedNum() {
		return limitedNum;
	}
	public void setLimitedNum(int limitedNum) {
		this.limitedNum = limitedNum;
	}
	/**
	 * @param id
	 * @param name
	 * @param hours
	 * @param credit
	 * @param type
	 * @param limitedNum
	 */
	public Course(String id, String name, int hours, int credit, String type, int limitedNum) {
		super();
		this.id = id;
		this.name = name;
		this.hours = hours;
		this.credit = credit;
		this.type = type;
		this.limitedNum = limitedNum;
	}
}
