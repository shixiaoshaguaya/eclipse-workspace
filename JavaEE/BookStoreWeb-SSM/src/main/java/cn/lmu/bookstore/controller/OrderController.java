package cn.lmu.bookstore.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lmu.bookstore.pojo.Cart;
import cn.lmu.bookstore.pojo.CartItem;
import cn.lmu.bookstore.pojo.Order;
import cn.lmu.bookstore.pojo.OrderItem;
import cn.lmu.bookstore.pojo.User;
import cn.lmu.bookstore.service.OrderService;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/create.action", method = RequestMethod.POST)
	@ResponseBody
	public String Create(HttpSession session, Order order, Model model) {
		Cart cart = (Cart) session.getAttribute("Cart");
		User user = (User) session.getAttribute("USER_SESSION");
		if (cart == null) {
			return "购物车空空如也，请先浏览<a href='../home/index.action'>选购产品</a>。";
		}
		String oid = UUID.randomUUID().toString();
		order.setId(oid);
		order.setMoney(cart.getTotalMoney());
		order.setPayState(0);
		order.setOrderState(0);
		order.setUser(user);
		order.setOrdertime(new Date());
		OrderItem oItem = null;
		for (CartItem item : cart.getCartItemLst()) {
			oItem = new OrderItem();
			oItem.setOrder(order);
			oItem.setProduct(item.getProduct());
			oItem.setBuyNum(item.getCount());
			oItem.setBuyPrice(item.getPrice());
			order.getOrderItems().add(oItem);
		}
		int result = this.orderService.createOrder(order);
		if (result > 0) {
			session.removeAttribute("Cart");
			return "true";
		} else {
			return "提交订单失败，请联系客服。";
		}
	}

	@RequestMapping(value = "/checkOut.action", method = RequestMethod.GET)
	public String Create() {
		return "client/CheckOut";
	}
}
