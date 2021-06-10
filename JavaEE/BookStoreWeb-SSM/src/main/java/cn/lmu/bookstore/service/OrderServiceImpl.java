package cn.lmu.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lmu.bookstore.dao.OrderItemMapper;
import cn.lmu.bookstore.dao.OrderMapper;
import cn.lmu.bookstore.dao.ProductMapper;
import cn.lmu.bookstore.pojo.Order;
import cn.lmu.bookstore.pojo.OrderItem;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;
	@Autowired
	private ProductMapper productMapper;

	@Transactional // 添加事务处理
	public int createOrder(Order order) {
		int result = 0;
		result = this.orderMapper.createOrder(order);
		for (OrderItem item : order.getOrderItems()) {
			this.orderItemMapper.createOrderItem(item);
			this.productMapper.updatePrdocutNum(item);
		}
		return result;
	}
}
