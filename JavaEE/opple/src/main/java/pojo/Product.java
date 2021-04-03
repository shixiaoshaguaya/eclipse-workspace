package pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	private int id;
	private String productno;
	private String productname;
	private String category;
	private double price;
	private String image;
	private String qrcode;
	private String description;
	private Date protime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductno() {
		return productno;
	}

	public void setProductno(String productno) {
		this.productno = productno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getProtime() {
		return protime;
	}

	public void setProtime(Date protime) {
		this.protime = protime;
	}

	public void setProtime(String protime) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = fmt.parse(protime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.protime = d;
	}

	public Product(int id, String productno, String productname, String category, double price, String image,
			String qrcode, String description, Date protime) {
		super();
		this.id = id;
		this.productno = productno;
		this.productname = productname;
		this.category = category;
		this.price = price;
		this.image = image;
		this.qrcode = qrcode;
		this.description = description;
		this.protime = protime;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productno=" + productno + ", productname=" + productname + ", category="
				+ category + ", price=" + price + ", image=" + image + ", qrcode=" + qrcode + ", description="
				+ description + ", protime=" + protime + "]";
	}
}
