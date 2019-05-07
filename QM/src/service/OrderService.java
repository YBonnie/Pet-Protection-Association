package service;

import java.util.List;

import javabean.Order;
import javabean.OrderListForm;

import annotation.Tran;

public interface OrderService extends Service{
	/**
	 * 增加订单interface
	 * @param order 订单bean
	 */
	@Tran
	void addOrder(Order order);

	/**
	 * 查询指定用户所有订单的方法
	 * @param user_id
	 * @return 查找到的数据
	 */
	List<OrderListForm> findOrders(int user_id);

	void delOrderByID(String id);

	Order findOrderById(String order_id);


	/**
	 * 修改指定id订单的支付状态
	 * @param order
	 * @param i
	 */
	void changePayState(String order, int i);

	List<Order> getAllOrder();
	/**
	 * 根据收件人名字查询订单
	 * */
	List<Order> findOrderName(String orderName);

	/**
	 * 更新订单
	 * */
	void AdminupdateOrders(Order order);

	void batchDel(String[] ids);

}
