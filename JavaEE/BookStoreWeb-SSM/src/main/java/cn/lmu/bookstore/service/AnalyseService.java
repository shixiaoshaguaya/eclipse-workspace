package cn.lmu.bookstore.service;

import java.util.List;

import cn.lmu.bookstore.pojo.AnlsOrderByCatgInfo;
import cn.lmu.bookstore.pojo.OrderCondition;

public interface AnalyseService {
	public List<AnlsOrderByCatgInfo> analyseOrderByCategory(OrderCondition orderCondition);
}
