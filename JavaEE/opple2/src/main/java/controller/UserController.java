package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.User;

@Controller
public class UserController {
	@RequestMapping("/userList")
	public ModelAndView queryItemList() {
		// 创建页面需要显示的商品数据
		List<User> list = new ArrayList<User>();
		list.add(new User(1, "u1", "123", "普通用户", new Date()));
		list.add(new User(2, "Test", "123", "普通用户", new Date()));
		list.add(new User(3, "Admin", "123", "管理员", new Date()));
		list.add(new User(4, "u4", "123", "普通用户", new Date()));
		list.add(new User(5, "u5", "123", "配送员", new Date()));
		// 创建ModelAndView，用来存放数据和视图
		ModelAndView modelAndView = new ModelAndView();
		// 设置数据到模型中
		modelAndView.addObject("userList", list);
		// 设置视图jsp，需要设置视图的物理地址
		modelAndView.setViewName("/WEB-INF/jsp/userList.jsp");
		return modelAndView;
	}
}
