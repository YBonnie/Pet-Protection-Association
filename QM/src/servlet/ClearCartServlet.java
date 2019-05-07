package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javabean.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<Good,Integer> cartmap = (Map<Good, Integer>) request.getSession().getAttribute("cartmap");
		/**
		 * 清空购物车
		 * 
		 * */
		cartmap.clear();
		response.setHeader("Refresh", "1;url=/QM/shopping_car.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
