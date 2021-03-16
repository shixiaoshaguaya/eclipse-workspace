package cz_JDBC.beans;

import java.util.Date;

public class Product {
	private String id;
	private String title;
	private float price;
	private Date manufacture;
	private int stock;
	private String picturePath;
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Product(String id, String title, float price, Date manufacture, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.manufacture = manufacture;
		this.stock = stock;
	}
	public Product() {
		super();
	}
	public Product(String id, String title, float price, Date manufacture, int stock, String picturePath) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.manufacture = manufacture;
		this.stock = stock;
		this.picturePath = picturePath;
	}
}
