package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.DaoUtils;
import util.TransactionManager;

import javabean.Order;
import javabean.OrderItem;
import javabean.User;

public class OrderDaoImpl implements OrderDao{

	public void addOrder(Order order) throws SQLException {
		String sql = "insert into orders values (?,?,?,?,?,?,null,?)";
		QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		runner.update(sql,order.getId(),order.getMoney(),order.getReceiverinfo(),order.getReceivername(),order.getReceiverphone(),order.getPaystate(),order.getUser_id());
		
	}

	public void addOrderItem(OrderItem item) throws SQLException {
		String sql = "insert into orderitem values (?,?,?)";
		QueryRunner runner = new QueryRunner(TransactionManager.getSource());
		runner.update(sql,item.getOrder_id(),item.getProduct_id(),item.getBuynum());
		
	}

	public List<Order> findOrderByUserId(int user_id) {
		String sql = "select * from orders where user_id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Order>(Order.class),user_id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<OrderItem> findOrderItems(String order_id) {
		String sql = "select * from orderitem where order_id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),order_id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delOrderItem(String order_id) {
		String sql = "delete from orderitem where order_id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,order_id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void delOrder(String id) {
		String sql = "delete from orders where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public Order finOrderById(String order_id) {
		String sql = "select * from orders where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql,new BeanHandler<Order>(Order.class),order_id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void changePayState(String order_id, int i) {
		String sql = "update orders set paystate = ? where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,i,order_id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public List<Order> getAllOrder() {
		String sql = "select * from orders";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Order>(Order.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Order> findOrderName(String orderName) {
		String sql = "select * from orders where receivername = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Order>(Order.class),orderName);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void AdminupdateOrders(Order order) {
		// TODO Auto-generated method stub
		String sql = "update orders set receivername = ? ,receiverphone = ? ,receiverinfo = ? ,paystate = ? where id=?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,order.getReceivername(),order.getReceiverphone(),order.getReceiverinfo(),order.getPaystate(),order.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from orders where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}

	
}
