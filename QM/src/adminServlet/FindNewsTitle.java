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

public class FindNewsTitle extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		NewsService service = BasicFactory.getFactory().getService(
				NewsService.class);
		String NewsTitle = request.getParameter("FindNewsTitle");
		List<News> NewsList = service.findNewsTitle(NewsTitle);
		request.setAttribute("NewsList", NewsList);
		request.getRequestDispatcher("/Administrator_interface/Management_Association_News.jsp").forward(request,
				response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

	
}
