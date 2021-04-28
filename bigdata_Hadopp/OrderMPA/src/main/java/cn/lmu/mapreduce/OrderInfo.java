package cn.lmu.mapreduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class OrderInfo implements Writable {// 为了能够在MapReduce过程中实现数据传输与存储
	// OrderInfo类必须实现序列化功能
	private String order_id;// 订单ID
	private String product_id;// 产品ID
	private int buyNum;// 购买数量
	private float buyPrice;// 购买价格
	private float buyMoney;// 购买金额
	private int buyCount;// 成交笔数

	public OrderInfo() {// 定义一个无参数构造方法，用于反序列化时反射调用创建实例对象
		super();
	}

	public OrderInfo(String order_id, String product_id, int buyNum, float buyPrice, float buyMoney, int buyCount) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.buyNum = buyNum;
		this.buyPrice = buyPrice;
		this.buyMoney = buyMoney;
		this.buyCount = buyCount;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public float getBuyMoney() {
		return buyMoney;
	}

	public void setBuyMoney(float buyMoney) {
		this.buyMoney = buyMoney;
	}

	public float getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	@Override
	public String toString() {
		return "order_id=" + order_id + ", product_id=" + product_id + ", buyNum=" + buyNum + ", buyPrice=" + buyPrice
				+ ", buyMoney=" + buyMoney + ", buyCount=" + buyCount;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// 反序列化时，顺序务必与序列化时顺序一致
		this.order_id = in.readUTF();
		this.product_id = in.readUTF();
		this.buyNum = in.readInt();
		this.buyPrice = in.readFloat();
		this.buyMoney = in.readFloat();
		this.buyCount = in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(order_id);
		out.writeUTF(product_id);
		out.writeInt(buyNum);
		out.writeFloat(buyPrice);
		out.writeFloat(buyMoney);
		out.writeInt(buyCount);
	}

}
