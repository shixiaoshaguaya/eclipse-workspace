package cn.lmu.bookstore.pojo;

//购物车列表项
public class CartItem {
	private Product product;
	private int count;
	private float price;
	private float money;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public CartItem(Product product, int count, float price) {
		super();
		this.product = product;
		this.count = count;
		this.price = price;
	}

	public float getMoney() {
		return price * count;
	}

	public void setMoney(float money) {
		this.money = money;
	}
}
