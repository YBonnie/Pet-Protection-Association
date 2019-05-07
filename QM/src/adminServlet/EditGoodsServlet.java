package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Good;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodService;
import factory.BasicFactory;

public class EditGoodsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		GoodService service = BasicFactory.getFactory().getService(
				GoodService.class);
		

		 //1.获取要查询的客户id
		String id =request.getParameter("id");
		//2.调用Service中根据id查找客户的方法
		Good goods = service.findGoodById(id);
		if(goods == null){
			throw new RuntimeException("找不到该商品!");
		}
		//3.将查找到的客户信息存入request域中,请求转发到AdminEditGoods.jsp页面展示
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("/Administrator_interface/AdminEditGoods.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	

}
