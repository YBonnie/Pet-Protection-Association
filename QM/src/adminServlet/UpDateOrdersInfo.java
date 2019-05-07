package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;


import javabean.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import service.OrderService;
import factory.BasicFactory;

public class UpDateOrdersInfo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		
		try {
			String id =request.getParameter("id");
			//1.封装数据校验数据
			Order order = new Order();
			BeanUtils.populate(order, request.getParameterMap());
			//2.调用Service中修改客户信息的方法
			service.AdminupdateOrders(order);
			JOptionPane.showMessageDialog(null, "订单信息修改成功", "提示",JOptionPane.PLAIN_MESSAGE);
			//3.重定向到客户列表页面
			response.setHeader("Refresh", "2;url=/QM/AdminOrderServlet");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
