package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Good;
import javabean.Page;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodService;
import service.PetService;
import factory.BasicFactory;

public class BazaarList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		GoodService service = BasicFactory.getFactory().getService(
				GoodService.class);
		
		//1.获取当前要显示的页和每页记录数
		int thispage = Integer.parseInt(request.getParameter("thispage"));
		System.out.print(thispage);
		int rowperpage = 6;
		//2.调用Service中分页查询客户的方法,查找出客户信息
		Page page = service.pageGood(thispage,rowperpage);
	
       // 2.将所有商品信息存入request域后带到页面展示
		request.setAttribute("page", page);
		//3.存入request域中,带到online_Bazaar.jsp页面中进行显示
		request.getRequestDispatcher("/online_Bazaar.jsp").forward(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
