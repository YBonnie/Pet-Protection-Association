package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javabean.Good;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodService;
import factory.BasicFactory;

public class AddShoppingCar extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService service = BasicFactory.getFactory().getService(
				GoodService.class);
		User user=(User)request.getSession().getAttribute("user2");
		if(user==null){
			request.getRequestDispatcher("/sign_In.jsp").forward(request,
				response);
		}
		//1.根据id查找出要购买的商品
		String id = request.getParameter("id");
		Good good = service.findGoodById(id);
		//2.向cartmap中添加这个商品,如果之前没有这个商品,则添加并将数量设置为1,如果已经有过这个商品,数量+1
		if(good==null){
			throw new RuntimeException("找不到该商品!");
		}else{
			Map<Good,Integer> cartmap = (Map<Good, Integer>) request.getSession().getAttribute("cartmap");
			cartmap.put(good, cartmap.containsKey(good)?cartmap.get(good)+1 : 1);
		}
		//3.重定向到购物车页面进行展示
		response.setHeader("Refresh", "1;url=/QM/shopping_car.jsp");
//		response.sendRedirect("/QM/shopping_car.jsp");

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}


}
