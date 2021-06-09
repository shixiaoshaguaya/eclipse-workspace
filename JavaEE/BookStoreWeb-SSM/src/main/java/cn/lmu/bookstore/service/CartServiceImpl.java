package cn.lmu.bookstore.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lmu.bookstore.pojo.Cart;
import cn.lmu.bookstore.pojo.CartItem;
import cn.lmu.bookstore.pojo.Product;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private ProductService productService;

	public boolean addItem(String productId, int count, HttpSession session) {
		if (productId == null || "".equals(productId))
			return false;
		Product product = this.productService.getProductById(productId);
		if (product == null)
			return false;
		Cart cart = this.getCart(session);
		CartItem cartItem = this.findItem(productId, session);
		if (cartItem != null) {
			cartItem.setCount(cartItem.getCount() + count);
		} else {
			cartItem = new CartItem(product, count, product.getPrice());
			cart.getCartItemLst().add(cartItem);
			session.setAttribute("Cart", cart);
		}
		return true;
	}

	public Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("Cart");
		if (cart == null) {
			cart = new Cart();
		}
		return cart;
	}

	public CartItem findItem(String productId, HttpSession session) {
		Cart cart = this.getCart(session);
		for (CartItem item : cart.getCartItemLst()) {
			if (item.getProduct().getId().equals(productId)) {
				return item;
			}
		}
		return null;
	}

	public boolean updateItem(String productId, int count, HttpSession session) {
		Cart cart = this.getCart(session);
		for (CartItem item : cart.getCartItemLst()) {
			if (item.getProduct().getId().equals(productId)) {
				item.setCount(count);
				session.setAttribute("Cart", cart);
				return true;
			}
		}
		return false;
	}

	public boolean deleteItem(String[] idArr, HttpSession session) {
		if (idArr == null || idArr.length == 0)
			return false;
		Cart cart = this.getCart(session);
		for (String productId : idArr) {
			Product product = this.productService.getProductById(productId);
			if (product != null) {
				CartItem cartItem = this.findItem(productId, session);
				if (cartItem != null) {
					cart.getCartItemLst().remove(cartItem);
				}
			}
		}
		session.setAttribute("Cart", cart);
		return true;
	}

	public boolean clear(HttpSession session) {
		Cart cart = this.getCart(session);
		cart.getCartItemLst().clear();
		return true;
	}
}
