package cz1110.beans;

import java.util.Date;

public class Product {
	private String Id;//��Ʒ���
	private String title;//��Ʒ����
	private float price;//�۸�
	private Date manufacture;//��������
	private int stock;//�������
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
