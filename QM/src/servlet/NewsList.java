package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Good;
import javabean.News;
import javabean.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodService;
import service.NewsService;
import factory.BasicFactory;

public class NewsList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NewsService service = BasicFactory.getFactory().getService(
				NewsService.class);

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//1.获取当前要显示的页和每页记录数
		int thispage = Integer.parseInt(request.getParameter("thispage"));
		System.out.print(thispage);
		int rowperpage = 5;
		
		//2.调用Service中分页查询客户的方法,查找出客户信息
		Page page = service.pageNews(thispage,rowperpage);
		
		//3.存入request域中,带到news_Center.jsp页面中进行显示
		request.setAttribute("page", page);
		request.getRequestDispatcher("/news_Center.jsp").forward(request,
				response);


	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);


	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
