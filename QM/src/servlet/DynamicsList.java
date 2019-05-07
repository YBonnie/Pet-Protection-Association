package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Dynamics;
import javabean.Page;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DynamicsService;
import factory.BasicFactory;

public class DynamicsList extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		DynamicsService service = BasicFactory.getFactory().getService(
				DynamicsService.class);
		
		//1.获取当前要显示的页和每页记录数
		int thispage = Integer.parseInt(request.getParameter("thispage"));
		System.out.print(thispage);
		int rowperpage = 5;
		//2.调用Service中分页查询客户的方法,查找出客户信息
		Page page = service.pageDynamics(thispage, rowperpage);
		//3.存入request域中,带到pageList.jsp页面中进行显示
		request.setAttribute("page", page);
		request.getRequestDispatcher("/association_Dynamics.jsp").forward(request, response);
		
		
		
		
		
//		
//		        List<Dynamics> list = service.findAllDynamics();		
//		        2.将所有商品信息存入request域后带到页面展示
//				request.setAttribute("list", list);
//				request.getRequestDispatcher("/association_Dynamics.jsp").forward(request,
//						response);
		
		



		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
