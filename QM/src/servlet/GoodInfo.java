package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodService;
import factory.BasicFactory;

public class GoodInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService service = BasicFactory.getFactory().getService(
				GoodService.class);
		// 获取id
		String id = request.getParameter("id");
		Good good = service.findGoodById(id);
		// 2.将所有商品信息存入request域后带到页面展示
		request.setAttribute("good", good);
		request.getRequestDispatcher("/online_Commodity_details.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
