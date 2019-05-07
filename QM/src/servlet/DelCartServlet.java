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

public class DelCartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService service = BasicFactory.getFactory().getService(
				GoodService.class);
		//1.获取要删除的id,根据id查找出商品
		String id = request.getParameter("id");
		Good good = service.findGoodById(id);
		//2.获取购物车,删除该商品
		Map<Good,Integer> cartmap = (Map<Good, Integer>) request.getSession().getAttribute("cartmap");
		cartmap.remove(good);
		//3.重定向回到购物车页面
		response.setHeader("Refresh", "1;url=/QM/shopping_car.jsp");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	

}
