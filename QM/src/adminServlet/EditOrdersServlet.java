package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.News;
import javabean.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;
import factory.BasicFactory;

public class EditOrdersServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		
				String id =request.getParameter("id");
				//2.调用Service中根据id查找客户的方法
				Order order = service.findOrderById(id);
				if(order == null){
					throw new RuntimeException("找不到该订单信息!");
				}
				//3.将查找到的客户信息存入request域中,请求转发到AdminEditNews.jsp页面展示
				request.setAttribute("order", order);
				request.getRequestDispatcher("/Administrator_interface/AdminEditOrders.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
