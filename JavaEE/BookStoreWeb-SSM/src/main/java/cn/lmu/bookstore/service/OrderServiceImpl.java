package cn.lmu.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.lmu.bookstore.dao.OrderItemMapper;
import cn.lmu.bookstore.dao.OrderMapper;
import cn.lmu.bookstore.dao.ProductMapper;
import cn.lmu.bookstore.pojo.Order;
import cn.lmu.bookstore.pojo.OrderCondition;
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

	public int editOrdert(Order order) {
		return this.orderMapper.editOrder(order);
	}

	public int deleteOrderById(String id) {
		return this.orderMapper.deleteOrder(id);
	}

	public Order getOrderById(String id) {
		return this.orderMapper.getOrderById(id);
	}

	public List<Order> getOrderListWhere(OrderCondition orderCondition) {
		return this.orderMapper.getOrderList(orderCondition);
	}

	public PageInfo<Order> getOrderListWhereByPage(OrderCondition orderCondition, Integer pageNum, Integer pageSize) {
		// 分页
		PageHelper.startPage(pageNum, pageSize);// page 指定页码，pageSize 为每页显示几条数据
		List<Order> list = this.orderMapper.getOrderList(orderCondition);// 调用查询
		PageInfo<Order> pageInfo = new PageInfo(list);
		return pageInfo;
	}
}
