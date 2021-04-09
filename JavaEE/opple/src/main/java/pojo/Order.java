package pojo;

import java.util.Date;

public class Order {
	private String id;
	private double money;
	private int number;
	private String receiverAddress;
	private String receiverName;
	private String receiverPhone;
	private String paystate;
	private Date ordertime;
	private int uid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getPaystate() {
		return paystate;
	}

	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Order() {
		super();
	}

	public Order(String id, double money, int number, String receiverAddress, String receiverName, String receiverPhone,
			String paystate, Date ordertime, int uid) {
		super();
		this.id = id;
		this.money = money;
		this.number = number;
		this.receiverAddress = receiverAddress;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.paystate = paystate;
		this.ordertime = ordertime;
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", money=" + money + ", number=" + number + ", receiverAddress=" + receiverAddress
				+ ", receiverName=" + receiverName + ", receiverPhone=" + receiverPhone + ", paystate=" + paystate
				+ ", ordertime=" + ordertime + ", uid=" + uid + "]";
	}
}
