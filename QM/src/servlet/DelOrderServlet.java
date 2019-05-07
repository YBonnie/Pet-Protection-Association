package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import factory.BasicFactory;

import service.OrderService;

public class DelOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		//1.获取订单id
		String id = request.getParameter("id");
		//2.调用Service中根据删除订单的方法
		service.delOrderByID(id);
		//3.回到订单列表页面
		JOptionPane.showMessageDialog(null, "订单删除成功!!!", "提示",JOptionPane.PLAIN_MESSAGE); 
		response.setHeader("Refresh", "3;url=/QM/OrderListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
