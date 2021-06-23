package cn.lmu.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lmu.bookstore.dao.OrderMapper;
import cn.lmu.bookstore.pojo.AnlsOrderByCatgInfo;
import cn.lmu.bookstore.pojo.OrderCondition;

@Service
public class AnalyseServiceImpl implements AnalyseService {
	@Autowired
	private OrderMapper orderMapper;

	public List<AnlsOrderByCatgInfo> analyseOrderByCategory(OrderCondition orderCondition) {
		return this.orderMapper.analyseOrderByCategory(orderCondition);
	}

}
