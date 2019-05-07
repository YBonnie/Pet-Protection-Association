package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Good;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodService;
import factory.BasicFactory;

public class AdminGoodsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		GoodService service = BasicFactory.getFactory().getService(
				GoodService.class);
		List<Good> GoodList = service.findAllGood();
//		把Good所有数据保存到request域里面	
		request.setAttribute("GoodList", GoodList);
	
//		重定向回Managing_commodity_info.jsp
	    request.getRequestDispatcher("/Administrator_interface/Managing_commodity_info.jsp").forward(request,
				response);

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
