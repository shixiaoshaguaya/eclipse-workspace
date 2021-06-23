package cn.lmu.bookstore.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.lmu.bookstore.pojo.Cart;
import cn.lmu.bookstore.pojo.CartItem;
import cn.lmu.bookstore.pojo.Order;
import cn.lmu.bookstore.pojo.OrderCondition;
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
		order.setOrderTime(new Date());
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

	@RequestMapping(value = "/list.action", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, OrderCondition orderCondition, Model model) {
		PageInfo<Order> pageInfo = this.orderService.getOrderListWhereByPage(orderCondition, pageNum, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("orderCondition", orderCondition);
		return "admin/OrderList";// 转向由视图解析器去解析数据，此处明确视图页面为admin/OrderList.jsp
	}

	@RequestMapping(value = "/update.action", method = RequestMethod.POST)
	@ResponseBody
	public String update(Order order) {
		if (this.orderService.editOrdert(order) > 0) {
			return "true";
		} else {
			return "false";
		}
	}
}
