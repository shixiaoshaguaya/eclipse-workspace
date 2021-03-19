package cn.lmu.ssm.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//定义一个用于封装产品数据的实体类，一般要与数据库中的产品记录结构映射
@Component("product1")
public class Product {
	private int id;
	@Value("新产品")
	private String name;
	@Value("535")
	private float price;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product() {
		super();
	}

	public Product(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
}
