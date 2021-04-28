package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.Product;

@Controller
public class ProductController2 {
	@RequestMapping("/productList2")
	public String queryItemList(Model model) {
		// 创建页面需要显示的商品数据
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "大厅吊灯", "吊灯", 55.8, "A.jpg", "1212132333", "123", "夺压城城一地大", new Date()));
		list.add(new Product(2, "房间壁灯", "壁灯", 288.0, "B.jpg", "5634343", "123", "地有声有色", new Date()));
		list.add(new Product(3, "卫生间镜前灯", "壁灯", 1088.0, "C.jpg", "6756565", "123", "晴晴夺在线", new Date()));
		list.add(new Product(4, "客厅带风扇灯", "壁灯", 399.0, "D.jpg", "343434343", "123", "极地地区性", new Date()));
		// 设置数据到模型中
		model.addAttribute("productList", list);
		// 设置视图jsp，需要设置视图的物理地址
		return "productList";
	}

	@RequestMapping("/productList3")
	public String queryItemListById(int productid, Model model) {
		// 创建页面需要显示的商品数据
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "大厅吊灯", "吊灯", 55.8, "A.jpg", "1212132333", "123", "夺压城城一地大", new Date()));
		list.add(new Product(2, "房间壁灯", "壁灯", 288.0, "B.jpg", "5634343", "123", "地有声有色", new Date()));
		list.add(new Product(3, "卫生间镜前灯", "壁灯", 1088.0, "C.jpg", "6756565", "123", "晴晴夺在线", new Date()));
		list.add(new Product(4, "客厅带风扇灯", "壁灯", 399.0, "D.jpg", "343434343", "123", "极地地区性", new Date()));
		List<Product> list1 = new ArrayList<Product>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			if (product.getId() == productid) {
				list1.add(product);
			}
		}
		model.addAttribute("productList", list1);
		// 设置视图jsp，需要设置视图的物理地址
		return "productList";
	}

	@RequestMapping("/productName")
	public String queryItemListByName(String productname, Model model) {
		// 创建页面需要显示的商品数据
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "大厅吊灯", "吊灯", 55.8, "A.jpg", "1212132333", "123", "夺压城城一地大", new Date()));
		list.add(new Product(2, "房间壁灯", "壁灯", 288.0, "B.jpg", "5634343", "123", "地有声有色", new Date()));
		list.add(new Product(3, "卫生间镜前灯", "壁灯", 1088.0, "C.jpg", "6756565", "123", "晴晴夺在线", new Date()));
		list.add(new Product(4, "客厅带风扇灯", "壁灯", 399.0, "D.jpg", "343434343", "123", "极地地区性", new Date()));
		List<Product> list1 = new ArrayList<Product>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			if (product.getProductname() == productname) {
				list1.add(product);
			}
		}
		model.addAttribute("productList", list1);
		// 设置视图jsp，需要设置视图的物理地址
		return "productList";
	}

	@RequestMapping(value = "/productList4", method = RequestMethod.POST)
	public String queryItemListById2(int productid, Model model) {
		// 创建页面需要显示的商品数据
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "大厅吊灯", "吊灯", 55.8, "A.jpg", "1212132333", "123", "夺压城城一地大", new Date()));
		list.add(new Product(2, "房间壁灯", "壁灯", 288.0, "B.jpg", "5634343", "123", "地有声有色", new Date()));
		list.add(new Product(3, "卫生间镜前灯", "壁灯", 1088.0, "C.jpg", "6756565", "123", "晴晴夺在线", new Date()));
		list.add(new Product(4, "客厅带风扇灯", "壁灯", 399.0, "D.jpg", "343434343", "123", "极地地区性", new Date()));
		List<Product> list1 = new ArrayList<Product>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			if (product.getId() == productid) {
				list1.add(product);
			}
		}
		model.addAttribute("productList", list1);
		// 设置视图jsp，需要设置视图的物理地址
		return "productList";
	}

	@RequestMapping(value = "/productName2", method = RequestMethod.POST)
	public String queryItemListByName2(String productname, Model model) {
		// 创建页面需要显示的商品数据
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "大厅吊灯", "吊灯", 55.8, "A.jpg", "1212132333", "123", "夺压城城一地大", new Date()));
		list.add(new Product(2, "房间壁灯", "壁灯", 288.0, "B.jpg", "5634343", "123", "地有声有色", new Date()));
		list.add(new Product(3, "卫生间镜前灯", "壁灯", 1088.0, "C.jpg", "6756565", "123", "晴晴夺在线", new Date()));
		list.add(new Product(4, "客厅带风扇灯", "壁灯", 399.0, "D.jpg", "343434343", "123", "极地地区性", new Date()));
		List<Product> list1 = new ArrayList<Product>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			if (product.getProductname() == productname) {
				list1.add(product);
			}
		}
		model.addAttribute("productList", list1);
		// 设置视图jsp，需要设置视图的物理地址
		return "productList";
	}

	@RequestMapping(value = "/productList5", method = RequestMethod.POST)
	public String queryItemListById5(HttpServletRequest request, Model model) {
		int productid = Integer.parseInt(request.getParameter("productid"));
		// 创建页面需要显示的商品数据
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "大厅吊灯", "吊灯", 55.8, "A.jpg", "1212132333", "123", "夺压城城一地大", new Date()));
		list.add(new Product(2, "房间壁灯", "壁灯", 288.0, "B.jpg", "5634343", "123", "地有声有色", new Date()));
		list.add(new Product(3, "卫生间镜前灯", "壁灯", 1088.0, "C.jpg", "6756565", "123", "晴晴夺在线", new Date()));
		list.add(new Product(4, "客厅带风扇灯", "壁灯", 399.0, "D.jpg", "343434343", "123", "极地地区性", new Date()));
		List<Product> list1 = new ArrayList<Product>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			if (product.getId() == productid) {
				list1.add(product);
			}
		}
		model.addAttribute("productList", list1);
		// 设置视图jsp，需要设置视图的物理地址
		return "productList";
	}

	@RequestMapping(value = "/productName3", method = RequestMethod.POST)
	public String queryItemListByName3(HttpServletRequest request, Model model) {
		String productname = request.getParameter("productname");
		// 创建页面需要显示的商品数据
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "大厅吊灯", "吊灯", 55.8, "A.jpg", "1212132333", "123", "夺压城城一地大", new Date()));
		list.add(new Product(2, "房间壁灯", "壁灯", 288.0, "B.jpg", "5634343", "123", "地有声有色", new Date()));
		list.add(new Product(3, "卫生间镜前灯", "壁灯", 1088.0, "C.jpg", "6756565", "123", "晴晴夺在线", new Date()));
		list.add(new Product(4, "客厅带风扇灯", "壁灯", 399.0, "D.jpg", "343434343", "123", "极地地区性", new Date()));
		List<Product> list1 = new ArrayList<Product>();
		// 设置数据到模型中
		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			if (product.getProductname() == productname) {
				list1.add(product);
			}
		}
		model.addAttribute("productList", list1);
		// 设置视图jsp，需要设置视图的物理地址
		return "productList";
	}
}
