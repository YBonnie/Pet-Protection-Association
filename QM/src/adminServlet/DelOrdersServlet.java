package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.OrderService;
import factory.BasicFactory;

public class DelOrdersServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		OrderService service = BasicFactory.getFactory().getService(OrderService.class);
		//1.获取订单id
		String id = request.getParameter("id");
		//2.调用Service中根据删除订单的方法
		service.delOrderByID(id);
		//3.回到订单列表页面
		JOptionPane.showMessageDialog(null, "订单删除成功!!!", "提示",JOptionPane.PLAIN_MESSAGE);
		//重定向回/AdminOrderServlet
		 request.getRequestDispatcher("/AdminOrderServlet").forward(request,
					response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
