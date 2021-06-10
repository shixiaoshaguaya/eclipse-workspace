package cn.lmu.bookstore.dao;

import cn.lmu.bookstore.pojo.Order;

public interface OrderMapper {
	// 创建
	public int createOrder(Order order);
}
