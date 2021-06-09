package cn.lmu.bookstore.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> cartItemLst; // 购物车中的购物列表
	private int totalCount; // 总数量
	private float totalMoney;// 总金额
	private User user;// 购物用户

	public List<CartItem> getCartItemLst() {
		return cartItemLst;
	}

	public void setCartItemLst(List<CartItem> cartItemLst) {
		this.cartItemLst = cartItemLst;
	}

	public int getTotalCount() {
		totalCount = 0;
		if (this.cartItemLst != null && this.cartItemLst.size() > 0) {
			for (CartItem it : this.cartItemLst) {
				totalCount += it.getCount();
			}
		}
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public float getTotalMoney() {
		totalMoney = 0;
		if (this.cartItemLst != null && this.cartItemLst.size() > 0) {
			for (CartItem it : this.cartItemLst) {
				totalMoney += it.getMoney();
			}
		}
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart(List<CartItem> cartItemLst, int totalCount, float totalMoney, User user) {
		super();
		this.cartItemLst = cartItemLst;
		this.totalCount = totalCount;
		this.totalMoney = totalMoney;
		this.user = user;
	}

	public Cart() {
		super();
		this.cartItemLst = new ArrayList<CartItem>();
	}
}
