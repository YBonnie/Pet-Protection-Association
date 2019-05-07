package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.News;
import javabean.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import factory.BasicFactory;

public class FindOrderName extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		
		String OrderName = request.getParameter("FindOrderName");
		List<Order> OrderList = service.findOrderName(OrderName);
		request.setAttribute("OrderList", OrderList);
		request.getRequestDispatcher("/Administrator_interface/Management_order.jsp").forward(request,
				response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}


}
