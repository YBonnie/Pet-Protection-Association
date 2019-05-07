package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javabean.Good;
import javabean.Order;
import javabean.OrderItem;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;

import service.OrderService;

import factory.BasicFactory;

public class AddOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		
		
		try {
			//1.将订单信息存入Order bean中
			Order order = new Order();
			//--订单编号
			order.setId(UUID.randomUUID().toString());
			
			//--支付状态
			order.setPaystate(0);
			
			//--收货地址
			BeanUtils.populate(order, request.getParameterMap());
			
			//--金额/将订单项信息存入order中
			Map<Good,Integer> cartmap = (Map<Good, Integer>) request.getSession().getAttribute("cartmap");
			double money = 0;
			List <OrderItem> list = new ArrayList<OrderItem>();
			for(Map.Entry<Good, Integer> entry : cartmap.entrySet()){
				money += entry.getKey().getPrice() * entry.getValue();
				
				OrderItem item = new OrderItem();
				item.setOrder_id(order.getId());
				item.setProduct_id(entry.getKey().getId());
				item.setBuynum(entry.getValue());
				list.add(item);
			}
			String receiverinfo =  request.getParameter("receiverinfo");
			String receivername =  request.getParameter("receivername");
			String receiverphone =  request.getParameter("receiverphone");
			order.setReceivername(receivername);
			order.setReceiverphone(receiverphone);
			order.setReceiverinfo(receiverinfo );
			order.setMoney(money);
			order.setList(list);
			
			//--客户编号
			User user = (User) request.getSession().getAttribute("user2");
			order.setUser_id(user.getId());
			
			//2.调用Service中添加订单的方法
			service.addOrder(order);
			
			//3.清空购物车
			cartmap.clear();
			
			//4.回到主页
			JOptionPane.showMessageDialog(null, "订单生成成功!请去支付!", "提示",JOptionPane.PLAIN_MESSAGE); 
			response.setHeader("refresh", "1;url=/QM/OrderListServlet");
		} catch (Exception e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	

}
