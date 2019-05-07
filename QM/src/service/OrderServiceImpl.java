package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import util.DaoUtils;
import util.TransactionManager;

import dao.GoodDao;
import dao.OrderDao;
import dao.UserDao;
import factory.BasicFactory;

import javabean.Good;
import javabean.Order;
import javabean.OrderItem;
import javabean.OrderListForm;
import javabean.User;

public class OrderServiceImpl implements OrderService{
	OrderDao orderDao = BasicFactory.getFactory().getDao(OrderDao.class);
	GoodDao goodDao = BasicFactory.getFactory().getDao(GoodDao.class);
	UserDao userDao = BasicFactory.getFactory().getDao(UserDao.class);
	public void addOrder(Order order) {
		try{
			//1.生成订单
			orderDao.addOrder(order);
			//2.生成订单项/扣除商品数量
			for(OrderItem item : order.getList()){
				orderDao.addOrderItem(item);
				goodDao.delPnum(item.getProduct_id(),item.getBuynum());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	public List<OrderListForm> findOrders(int user_id) {
		try{

			List<OrderListForm> olfList = new ArrayList<OrderListForm>();
			//1.根据用户id查询这个id用户的所有订单
			List<Order> list = orderDao.findOrderByUserId(user_id);
			//2.遍历订单 生成orderListForm对象,存入List中
			for(Order order : list){
				//--设置订单信息
				OrderListForm olf = new OrderListForm();
				BeanUtils.copyProperties(olf, order);
				//--设置用户名
				User user = userDao.findUserById(order.getUser_id());
				olf.setUsername(user.getUsername());
				//--设置商品信息
				//----查询当前订单所有订单项
				List<OrderItem> itemList = orderDao.findOrderItems(order.getId());
				//----遍历所有订单项,获取商品id,查找对应的商品,存入list
				Map<Good,Integer> prodMap = new HashMap<Good,Integer>();
				for(OrderItem item : itemList){
					int prod_id = item.getProduct_id();
					Good prod = goodDao.findGoodById(prod_id);
					prodMap.put(prod, item.getBuynum());
				}
				olf.setProdMap(prodMap);
				
				olfList.add(olf);
			}
			
			return olfList;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public void delOrderByID(String id) {
		//1.根据id查询出所有订单项
				List<OrderItem>list = orderDao.findOrderItems(id);
				//2.遍历订单项,将对应prod_id的商品的库存加回去
				for(OrderItem item : list){
					goodDao.addPnum(item.getProduct_id(),item.getBuynum());
				}
				//3.删除订单项
				orderDao.delOrderItem(id);
				//4.删除订单
				orderDao.delOrder(id);
		
	}
	public Order findOrderById(String order_id) {
		return orderDao.finOrderById(order_id);
	}
	public void changePayState(String order, int i) {
		orderDao.changePayState(order,i);
		
	}
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrder();
	}
	public List<Order> findOrderName(String orderName) {
		// TODO Auto-generated method stub
		return orderDao.findOrderName(orderName);
	}
	public void AdminupdateOrders(Order order) {
		// TODO Auto-generated method stub
		orderDao.AdminupdateOrders(order);
	}
	public void batchDel(String[] ids) {
		// TODO Auto-generated method stub
		java.sql.Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
				orderDao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

}
