package cn.lmu.bookstore.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderCondition {
	private String id; // 订单编号
	private double money; // 订单总价
	private String receiverAddress; // 送货地址
	private String receiverName; // 收货人姓名
	private String receiverPhone; // 收货人电话
	private Integer payState; // 支付状态
	private Integer orderState; // 订单状态
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate; // 下单时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate; // 下单时间
	private User user; // 订单所属用户
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

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

	public Integer getPayState() {
		return payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public OrderCondition(String id, double money, String receiverAddress, String receiverName, String receiverPhone,
			Integer paystate, Integer orderState, Date startDate, Date endDate, User user, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.money = money;
		this.receiverAddress = receiverAddress;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.payState = paystate;
		this.orderState = orderState;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		this.orderItems = orderItems;
	}

	public OrderCondition() {
		super();
	}

	@Override
	public String toString() {
		return "OrderCondition [id=" + id + ", money=" + money + ", receiverAddress=" + receiverAddress
				+ ", receiverName=" + receiverName + ", receiverPhone=" + receiverPhone + ", payState=" + payState
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", user=" + user + ", orderItems=" + orderItems
				+ "]";
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
}
