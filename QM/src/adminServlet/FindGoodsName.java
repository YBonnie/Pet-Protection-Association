package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodService;
import factory.BasicFactory;

public class FindGoodsName extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("vbfdbfd");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		GoodService service = BasicFactory.getFactory().getService(
				GoodService.class);
		
		String GoodsName = request.getParameter("FindGoodsName");
		System.out.print(GoodsName);
		List<Good> GoodList = service.findGoodsName(GoodsName);
		request.setAttribute("GoodList", GoodList);
		request.getRequestDispatcher("/Administrator_interface/Managing_commodity_info.jsp").forward(request,
				response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
