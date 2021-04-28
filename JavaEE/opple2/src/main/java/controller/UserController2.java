package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.User;

@Controller
public class UserController2 {
	@RequestMapping("/userList2")
	public String queryltemList(Model model) {
		// 创建页面需要显示的商品数据
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "u1121212", "123", "普通用户", new Date()));
		list.add(new User(2, "Test34343", "123", "普通用户", new Date()));
		list.add(new User(3, "Admin555", "123", "管理员", new Date()));
		list.add(new User(4, "u4", "123", "普通用户", new Date()));
		list.add(new User(5, "u5", "123", "配送员", new Date()));
		// 设置数据到模型中
		model.addAttribute("userList", list);
		// 设置视图jsp，需要设置视图的物理地址
		return "userList";
	}

	@RequestMapping("/userList3")
	public String queryltemListById(int userid, Model model) {
		System.out.println("用户查找的ID：" + userid);
		// 创建页面需要显示的商品数据
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "uB1", "123", "普通用户", new Date()));
		list.add(new User(2, "TestB", "123", "普通用户", new Date()));
		list.add(new User(3, "AdminB", "123", "管理员", new Date()));
		list.add(new User(4, "uB4", "123", "普通用户", new Date()));
		list.add(new User(5, "uB5", "123", "配送员", new Date()));
		List<User> list1 = new ArrayList<User>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			if (user.getId() == userid) {
				list1.add(user);
			}
		}
		model.addAttribute("userList", list1);
		// 设置视图jsp，需要设置视图的物理地址
		return "userList";
	}

	@RequestMapping(value = "/userList4", method = RequestMethod.POST)
	public String queryltemListById2(int userid, Model model) {
		System.out.println("用户查找的ID：" + userid);
		// 创建页面需要显示的商品数据
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "uB1", "123", "普通用户", new Date()));
		list.add(new User(2, "TestB", "123", "普通用户", new Date()));
		list.add(new User(3, "AdminB", "123", "管理员", new Date()));
		list.add(new User(4, "uB4", "123", "普通用户", new Date()));
		list.add(new User(5, "uB5", "123", "配送员", new Date()));
		List<User> list1 = new ArrayList<User>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			if (user.getId() == userid) {
				list1.add(user);
			}
		}
		model.addAttribute("userList", list1);
		// 设置视图jsp，需要设置视图的物理地址
		return "userList";
	}

	@RequestMapping(value = "/userList5", method = RequestMethod.POST)
	public String queryItemListById5(HttpServletRequest request, Model model) {
//		String userid = request.getParameter("userid");
		int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println("用户查找的ID：" + userid);
		// 创建页面需要显示的商品数据
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "uB1", "123", "普通用户", new Date()));
		list.add(new User(2, "TestB", "123", "普通用户", new Date()));
		list.add(new User(3, "AdminB", "123", "管理员", new Date()));
		list.add(new User(4, "uB4", "123", "普通用户", new Date()));
		list.add(new User(5, "uB5", "123", "配送员", new Date()));

		List<User> list1 = new ArrayList<User>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			if (user.getId() == userid) {
				list1.add(user);
			}
		}
		model.addAttribute("userList", list1);
		return "userList";
	}
}
