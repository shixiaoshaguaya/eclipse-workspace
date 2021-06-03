package cn.lmu.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	 * 向用户返回登录页面
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(User user, Model model, HttpSession session, HttpServletRequest request) {
		// 从数据库中获取对用户名和密码后进行判断
		User loginedUser = this.userService.checkLogin(user);
		if (loginedUser != null) {
			// 将用户对象添加到Session中
			session.setAttribute("USER_SESSION", loginedUser);
			// 重定向到主页面的跳转方法
			if (session.getAttribute("fromUrl") != null) {
				String fromUrl = session.getAttribute("fromUrl").toString();
				fromUrl = fromUrl.substring(fromUrl.indexOf("/", 1));
				return "redirect:" + fromUrl;
			} else {
				String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath() + "/";
				if (loginedUser.getRole() == "超级用户") {
					path = path + "product/list.action";
				} else {
					path = path + "home/index.action";
				}
				return "redirect:" + path;
			}
		}
		model.addAttribute("msg", "用户名或密码错误，请重新登录！");
		return "login";
	}

	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
		// 清除session
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:login.action";
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
