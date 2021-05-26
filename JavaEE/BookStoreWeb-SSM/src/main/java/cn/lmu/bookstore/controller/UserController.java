package cn.lmu.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

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
	public String list(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize, User user, Model model) {
		// List<User> users = this.userService.getUserListWhere(user);
		// model.addAttribute("users", users);
		PageInfo<User> pageInfo = this.userService.getUserListWhereByPage(user, pageNum, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("user", user);
		return "admin/users2";
	}

	/**
	 * 请求新增时返回新增页面
	 */
	@RequestMapping(value = "/insert.action", method = { RequestMethod.GET })
	public String insert(Model model) {
		return "admin/User-Edit";
	}

	/**
	 * 新增保存请求
	 */
	@RequestMapping(value = "/insert.action", method = { RequestMethod.POST })
	@ResponseBody
	public String save(Model model, User user) {
		int rowCount = this.userService.createUser(user);
		if (rowCount > 0) {
			return "OK";
		} else {
			return "ERROR";
		}
	}

	// 请求产品编辑页面
	@RequestMapping(value = "/edit.action", method = { RequestMethod.GET })
	public String edit(Model model, int id) {
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);// 将要编辑的产品原有数据传输到前端
		return "admin/User-Edit";
	}

	/**
	 * 更新产品
	 */
	@RequestMapping(value = "/edit.action", method = { RequestMethod.POST })
	@ResponseBody
	public String update(Model model, User user) {
		int rowCount = this.userService.editUser(user);
		if (rowCount > 0) {
			return "OK";
		} else {
			return "ERROR";
		}
	}

	/**
	 * 删除产品
	 */
	@RequestMapping(value = "/delete.action", method = { RequestMethod.POST })
	@ResponseBody
	public String delete(@RequestParam(value = "idArr") String[] idArr) {
		this.userService.deleteUserByIds(idArr);
		return "success";
	}
}
