package cn.lmu.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lmu.bookstore.pojo.Cart;
import cn.lmu.bookstore.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/list.action", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(HttpSession session, Model model) {
		// 获取购物车记录
		Cart cart = this.cartService.getCart(session);
		model.addAttribute("cart", cart);
		return "client/Cart";
	}

	@RequestMapping(value = "/buy.action", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String buy(String id, int count, HttpSession session, Model model) {
		if (this.cartService.addItem(id, count, session))
			return "true";
		return "false";
	}

	@RequestMapping(value = "/change.action", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String buy2(String id, int count, HttpSession session, Model model) {
		if (this.cartService.updateItem(id, count, session))
			return "true";
		return "false";
	}

	@RequestMapping(value = "/delete.action", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String delete(String[] idArr, HttpSession session) {
		if (this.cartService.deleteItem(idArr, session))
			return "true";
		return "false";
	}

	@RequestMapping(value = "/clear.action", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String clear(HttpSession session) {
		if (this.cartService.clear(session))
			return "true";
		return "false";
	}
}
