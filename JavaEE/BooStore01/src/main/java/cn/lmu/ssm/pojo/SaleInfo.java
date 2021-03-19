package cn.lmu.ssm.pojo;

import java.sql.Date;

public class SaleInfo {
	private int id;
	private int product_id;
	private float salePrice;
	private int quantity;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SaleInfo() {
		super();
	}

	public SaleInfo(int id, int product_id, float salePrice, int quantity, Date createTime) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.salePrice = salePrice;
		this.quantity = quantity;
		this.createTime = createTime;
	}
}
