package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.News;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;
import factory.BasicFactory;

public class AdminNewsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		NewsService service = BasicFactory.getFactory().getService(
				NewsService.class);
		List<News> NewsList = service.findAllNews();
//		把news所有数据保存到request域里面	
		request.setAttribute("NewsList", NewsList);

//		重定向回Management_Association_News.jsp
	    request.getRequestDispatcher("/Administrator_interface/Management_Association_News.jsp").forward(request,
				response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	

}
