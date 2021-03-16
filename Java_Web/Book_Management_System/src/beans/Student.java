package beans;

import java.util.Date;

public class Student {
	private String s_id;// 学号
	private String s_name;// 姓名
	private String s_password;// 密码
	private String sex;// 性别
	private String telephone;// 电话
	private int s_number;// 已借书数量
	private Float s_money;// 欠款金额
	private Date s_date;// 创建日期
	private String s_identity;

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_password() {
		return s_password;
	}

	public void setS_password(String s_password) {
		this.s_password = s_password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getS_number() {
		return s_number;
	}

	public void setS_number(int s_number) {
		this.s_number = s_number;
	}

	public Float getS_money() {
		return s_money;
	}

	public void setS_money(Float s_money) {
		this.s_money = s_money;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public String getS_identity() {
		return s_identity;
	}

	public void setS_identity(String s_identity) {
		this.s_identity = s_identity;
	}

	public Student() {
		super();
	}

	public Student(String s_id, String s_name, String s_password, String sex, String telephone, Date s_date) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_password = s_password;
		this.sex = sex;
		this.telephone = telephone;
		this.s_date = s_date;
	}

	public Student(String s_id, String s_name, String sex, String telephone, Date s_date) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.sex = sex;
		this.telephone = telephone;
		this.s_date = s_date;
	}

	public Student(String s_id, String s_name, String s_password, String sex, String telephone, int s_number,
			Float s_money, Date s_date, String s_identity) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_password = s_password;
		this.sex = sex;
		this.telephone = telephone;
		this.s_number = s_number;
		this.s_money = s_money;
		this.s_date = s_date;
		this.s_identity = s_identity;
	}
	
	
}
