package cn.lmu.bookstore.dao;

import java.util.List;

import cn.lmu.bookstore.pojo.AnlsOrderByCatgInfo;
import cn.lmu.bookstore.pojo.Order;
import cn.lmu.bookstore.pojo.OrderCondition;

public interface OrderMapper {
	// 创建
	public int createOrder(Order order);

	// 获取某
	public Order getOrderById(String id);

	// 获取符合条件的列表
	public List<Order> getOrderList(OrderCondition orderCondition);

	// 编辑
	public int editOrder(Order order);

	// 删除
	public int deleteOrder(String id);

	// 按类别统计销售
	public List<AnlsOrderByCatgInfo> analyseOrderByCategory(OrderCondition orderCondition);
}
