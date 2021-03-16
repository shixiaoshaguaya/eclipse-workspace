package cz1110.beans;

import java.util.Date;

public class Product {
	private String Id;//产品编号
	private String title;//产品名称
	private float price;//价格
	private Date manufacture;//生产日期
	private int stock;//库存数量
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getManufacture() {
		return manufacture;
	}
	public void setManufacture(Date manufacture) {
		this.manufacture = manufacture;
	}
	public int getStock() {
		return stock;
	}
	public Product(String id, String title, float price, Date manufacture, int stock) {
		super();
		Id = id;
		this.title = title;
		this.price = price;
		this.manufacture = manufacture;
		this.stock = stock;
	}
}
