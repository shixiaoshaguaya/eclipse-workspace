package beans;

import java.util.Date;

public class Book_Student {
	private int id;// ID��
	private String b_id;// ͼ����
	private String s_id;// ѧ��
	private Date borrow_date;// ��������
	private Date return_date;// ��������
	private Date practical_date;// ʵ�ʻ�������
	private int renew;// ����
	private float money;// ���ڷ���

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
