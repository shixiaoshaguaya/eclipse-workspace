package cn.lmu.bookstore.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.lmu.bookstore.pojo.Order;
import cn.lmu.bookstore.pojo.OrderCondition;

public interface OrderService {
	public int createOrder(Order order);

	public Order getOrderById(String id);

	public List<Order> getOrderListWhere(OrderCondition orderCondition);

	public int editOrdert(Order order);

	public int deleteOrderById(String id);

	public PageInfo<Order> getOrderListWhereByPage(OrderCondition orderCondition, Integer pageNum, Integer pageSize);
}
