package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;
import factory.BasicFactory;

public class PageCustServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		NewsService service = BasicFactory.getFactory().getService(
				NewsService.class);
		
		//1.获取当前要显示的页和每页记录数
				int thispage = Integer.parseInt(request.getParameter("thispage"));
				System.out.print(thispage);
				int rowperpage = 5;
				
				//2.调用Service中分页查询客户的方法,查找出客户信息
				Page page = service.pageNews(thispage,rowperpage);
				
				//3.存入request域中,带到news_Center_2.jsp页面中进行显示
				request.setAttribute("page", page);
				request.getRequestDispatcher("/news_Center_2.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
