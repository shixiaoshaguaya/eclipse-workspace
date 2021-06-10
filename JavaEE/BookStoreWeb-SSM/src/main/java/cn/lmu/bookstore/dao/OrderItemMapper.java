package cn.lmu.bookstore.dao;

import cn.lmu.bookstore.pojo.OrderItem;

public interface OrderItemMapper {
	// 创建
	public int createOrderItem(OrderItem orderItem);
}
