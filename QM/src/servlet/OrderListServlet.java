package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.OrderListForm;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.BasicFactory;

import service.OrderService;

public class OrderListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		
		//1.获取用户id
		User user = (User) request.getSession().getAttribute("user2");
		int id = user.getId();
		
		//2.调用Service中根据用户id查询用户具有的订单的方法
		List<OrderListForm> list = service.findOrders(id);
		
		//3.存入request域带到页面显示orderList.jsp
		request.setAttribute("list", list);
		request.getRequestDispatcher("/orderList.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
