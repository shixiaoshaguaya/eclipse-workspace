package cn.lmu.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lmu.bookstore.pojo.AnlsOrderByCatgInfo;
import cn.lmu.bookstore.pojo.OrderCondition;
import cn.lmu.bookstore.service.AnalyseService;

@Controller
@RequestMapping("analyse") // 响应用户的/analyse请求
public class AnalyseController {
	@Autowired
	private AnalyseService analyseService;

	@RequestMapping(value = "/anlsOrderByCatg.action", method = { RequestMethod.GET })
	public String analyseOrderByCategory() {
		return "admin/AnlsOrderByCatg";
	}

	@RequestMapping(value = "/anlsOrderByCatg.action", method = { RequestMethod.POST })
	@ResponseBody
	public List<AnlsOrderByCatgInfo> analyseOrderByCategory(@RequestBody OrderCondition orderCondition) {
		return this.analyseService.analyseOrderByCategory(orderCondition);
	}
}