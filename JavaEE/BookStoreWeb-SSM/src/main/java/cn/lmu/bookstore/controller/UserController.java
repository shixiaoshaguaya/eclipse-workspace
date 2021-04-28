package cn.lmu.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lmu.bookstore.pojo.User;
import cn.lmu.bookstore.service.UserService;

@CrossOrigin(origins = "*") // 支持跨域
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * API接口：返回JSON格式的产品列表
	 */
	@RequestMapping(value = "/list2.action", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<User> list(User user) {
		List<User> users = this.userService.getUserListWhere(user);
		return users;
	}

	/**
	 * MVC方法：设置Model数据并请求JSP页面解析展示数据
	 */
	@RequestMapping(value = "/list.action", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(User user, Model model) {
		List<User> users = this.userService.getUserListWhere(user);
		model.addAttribute("users", users);
		model.addAttribute("user", user);
		return "admin/users2";
	}

	/**
	 * 创建
	 */
	@RequestMapping(value = "/create.action")
	@ResponseBody
	public String Create(User user) {
		// 执行Service层中的创建方法，返回的是受影响的行数
		int rows = this.userService.createUser(user);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

	@RequestMapping("/getUserById.action")
	@ResponseBody
	public User getProductById(int id) {
		User user = this.userService.getUserById(id);
		return user;
	}

	/**
	 * 更新产品
	 */
	@RequestMapping("/update.action")
	@ResponseBody
	public String update(User user) {
		int rows = this.userService.editUser(user);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}

	/**
	 * 删除产品
	 */
	@RequestMapping("/delete.action")
	@ResponseBody
	public String delete(int id) {
		int rows = this.userService.deleteUserById(id);
		if (rows > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
}
