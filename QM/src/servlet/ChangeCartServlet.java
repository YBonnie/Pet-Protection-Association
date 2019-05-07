package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javabean.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodService;
import factory.BasicFactory;

public class ChangeCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService service = BasicFactory.getFactory().getService(
				GoodService.class);
		//1.获取要删除的id,根据id查找出商品
		String id = request.getParameter("id");
		Good good = service.findGoodById(id);
		//2.获取购物车,修改数量
		Map<Good,Integer> cartmap = (Map<Good, Integer>) request.getSession().getAttribute("cartmap");
		cartmap.put(good, Integer.parseInt(request.getParameter("total_number")));
		//3.重定向回到购物车页面shopping_car.jsp
		response.setHeader("Refresh", "1;url=/QM/shopping_car.jsp");
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	
	}


}
