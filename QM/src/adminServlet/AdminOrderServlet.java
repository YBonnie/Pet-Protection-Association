package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Order;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import factory.BasicFactory;

public class AdminOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		
//		获取Order所有数据
		List<Order> OrderList = service.getAllOrder();
//		把user所有数据保存到request域里面	
		request.setAttribute("OrderList", OrderList);
	
//		重定向回Managing_user_info.jsp
	    request.getRequestDispatcher("/Administrator_interface/Management_order.jsp").forward(request,
				response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
