package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Product;

@Controller
public class ProductController {
	@RequestMapping("/productList")
	public ModelAndView queryItemList() {
		// 创建页面需要显示的商品数据
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "大厅吊灯", "吊灯", 55.8, "A.jpg", "1212132333", "123", "夺压城城一地大", new Date()));
		list.add(new Product(2, "房间壁灯", "壁灯", 288.0, "B.jpg", "5634343", "123", "地有声有色", new Date()));
		list.add(new Product(3, "卫生间镜前灯", "壁灯", 1088.0, "C.jpg", "6756565", "123", "晴晴夺在线", new Date()));
		list.add(new Product(4, "客厅带风扇灯", "壁灯", 399.0, "D.jpg", "343434343", "123", "极地地区性", new Date()));
		// 创建ModelAndView，用来存放数据和视图
		ModelAndView modelAndView = new ModelAndView();
		// 设置数据到模型中
		modelAndView.addObject("productList", list);
		// 设置视图jsp，需要设置视图的物理地址
		modelAndView.setViewName("/WEB-INF/jsp/productList.jsp");
		return modelAndView;
	}
}
