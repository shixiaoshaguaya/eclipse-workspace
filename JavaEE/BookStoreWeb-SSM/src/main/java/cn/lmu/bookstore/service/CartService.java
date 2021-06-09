package cn.lmu.bookstore.service;

import javax.servlet.http.HttpSession;

import cn.lmu.bookstore.pojo.Cart;
import cn.lmu.bookstore.pojo.CartItem;

public interface CartService {
	public Cart getCart(HttpSession session);

	public boolean addItem(String productId, int count, HttpSession session);

	public boolean deleteItem(String[] idArr, HttpSession session);

	public CartItem findItem(String productId, HttpSession session);

	public boolean updateItem(String productId, int count, HttpSession session);

	public boolean clear(HttpSession session);
}
