package beans;

import java.util.Date;

public class Book_Student {
	private int id;// ID号
	private String b_id;// 图书编号
	private String s_id;// 学号
	private Date borrow_date;// 借书日期
	private Date return_date;// 还书日期
	private Date practical_date;// 实际还书日期
	private int renew;// 续借
	private float money;// 超期罚款

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public Date getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public float getMoney() {
		return money;
	}

	public Date getPractical_date() {
		return practical_date;
	}

	public void setPractical_date(Date practical_date) {
		this.practical_date = practical_date;
	}

	public int getRenew() {
		return renew;
	}

	public void setRenew(int renew) {
		this.renew = renew;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Book_Student() {
		super();
	}

	public Book_Student(String b_id, String s_id, Date borrow_date, Date return_date) {
		super();
		this.b_id = b_id;
		this.s_id = s_id;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
	}
}
